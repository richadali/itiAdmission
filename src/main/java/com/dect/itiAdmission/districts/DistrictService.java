package com.dect.itiAdmission.districts;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private DistrictRepository districtRepository;
    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    public List<District> getDistricts() {
        return districtRepository.findAll();
    }
}
