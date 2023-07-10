package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Centers;
import com.dect.itiAdmission.repository.CenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    private CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public List<Centers> getCenters() {
        return centerRepository.findAll();
    }

    public Centers addCenter(Centers centers) {
        return centerRepository.save(centers);
    }

    public Long centerCount(){
        return centerRepository.count();
    }

}
