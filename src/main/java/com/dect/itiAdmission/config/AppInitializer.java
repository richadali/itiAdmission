package com.dect.itiAdmission.config;
import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.domain.States;
import com.dect.itiAdmission.domain.Villages;
import com.dect.itiAdmission.dtos.DistrictDTO;
import com.dect.itiAdmission.dtos.StateDTO;
import com.dect.itiAdmission.dtos.SubDistrictDTO;
import com.dect.itiAdmission.dtos.VillageDTO;
import com.dect.itiAdmission.repository.BlockRepository;
import com.dect.itiAdmission.repository.DistrictRepository;
import com.dect.itiAdmission.repository.StateRepository;
import com.dect.itiAdmission.repository.VillageRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Slf4j
public class AppInitializer {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private VillageRepository villageRepository;

    private final String LGD_URI="https://lgdirectory.gov.in/webservices/lgdws/";

    @PostConstruct
    private void init() {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List result;

//        https://lgdirectory.gov.in/webservices/lgdws/villageList

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<String> request =
                    new HttpEntity<String>(new Object().toString());
            result =  restTemplate.postForObject(LGD_URI+"stateList", request, List.class);

            try{

                List<StateDTO> stateDTOList = mapper.convertValue(result, new TypeReference<>() {});

                for (StateDTO s: stateDTOList) {
                    States states= new States();
                    states.setId(s.getStateCode());
                    states.setName(s.getStateNameEnglish());
                    stateRepository.save(states);

                    if (s.getStateCode() == 17){

                        try {
                            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
                            formData.add("stateCode", String.valueOf(17));
                            HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(formData, headers);


                            result =  restTemplate.postForObject(LGD_URI+"districtList", req, List.class);

                            List<DistrictDTO> districtDTOS = mapper.convertValue(result, new TypeReference<>() {});

                            States state=stateRepository.getReferenceById(17L);

                            for (DistrictDTO d : districtDTOS) {
                                Districts district=new Districts();
                                district.setId(d.getDistrictCode());
                                district.setName(d.getDistrictNameEnglish());
                                district.setStates(state);
                                districtRepository.saveAndFlush(district);

                                formData = new LinkedMultiValueMap<>();
                                formData.add("districtCode", String.valueOf(d.getDistrictCode()));
                                req = new HttpEntity<>(formData, headers);

                                result =  restTemplate.postForObject(LGD_URI+"subdistrictList", req, List.class);
                                List<SubDistrictDTO> subDistrictDTOS = mapper.convertValue(result, new TypeReference<>() {});

                                for (SubDistrictDTO sd: subDistrictDTOS) {
                                    Blocks blocks = new Blocks();
                                    blocks.setId(sd.getSubdistrictCode());
                                    blocks.setName(sd.getSubdistrictNameEnglish());
                                    blocks.setDistricts(district);
                                    blockRepository.saveAndFlush(blocks);

                                    formData = new LinkedMultiValueMap<>();
                                    formData.add("subDistrictCode", String.valueOf(sd.getSubdistrictCode()));
                                    req = new HttpEntity<>(formData, headers);

                                    result =  restTemplate.postForObject(LGD_URI+"villageList", req, List.class);

                                    List<VillageDTO> villageDTOS = mapper.convertValue(result, new TypeReference<>() {});

                                    List<Villages> villagesList=new ArrayList<>();
                                    for (VillageDTO v: villageDTOS) {
                                        Villages villages = new Villages();
                                        villages.setId(v.getVillageCode());
                                        villages.setName(v.getVillageNameEnglish());
                                        villages.setBlocks(blocks);
                                        villagesList.add(villages);
                                    }
                                    villageRepository.saveAllAndFlush(villagesList);

                                }

                            }

                            System.out.println(result);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

//					System.out.println(result);
            }catch (Exception e){}


        }
    }


