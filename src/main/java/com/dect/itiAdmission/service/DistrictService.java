package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public List<Districts> getAllDistricts(){
        List<Districts> districts = districtRepository.findAll();
        return  districts;
    }


}
