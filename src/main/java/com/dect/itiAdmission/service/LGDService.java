package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.domain.Villages;
import com.dect.itiAdmission.repository.BlockRepository;
import com.dect.itiAdmission.repository.DistrictRepository;
import com.dect.itiAdmission.repository.StateRepository;
import com.dect.itiAdmission.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LGDService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private VillageRepository villageRepository;

    public LGDService() {}


    public List<Districts> getDistricts(){
        return districtRepository.findAll();
    }

    public List<Blocks> getBlocks(Long distrcictId){
        return blockRepository.findAllByDistricts(districtRepository.getReferenceById(distrcictId));
    }

    public List<Villages> getVillages(Long blockId){
        return villageRepository.findAllByBlocks(blockRepository.getReferenceById(blockId));
    }

}
