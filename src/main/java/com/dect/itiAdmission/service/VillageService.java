package com.dect.itiAdmission.service;
import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Villages;
import com.dect.itiAdmission.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillageService {
    @Autowired
    VillageRepository villageRepository;

    public List<Villages> getAllVillages(){
        List<Villages> villagesList = villageRepository.findAll();
        return villagesList;


    }

    public List<Villages> getAllVillagesByBlocks(Blocks blocks){
       List<Villages> villagesList= villageRepository.findAllByBlocks(blocks);
       return villagesList;
    }
}
