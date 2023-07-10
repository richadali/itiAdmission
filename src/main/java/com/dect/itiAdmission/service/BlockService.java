package com.dect.itiAdmission.service;

import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Districts;
import com.dect.itiAdmission.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    @Autowired
    BlockRepository blockRepository;

    public List<Blocks> getAllBlocks(){
        List<Blocks> blocksList = blockRepository.findAll();
        return  blocksList;
    }

    public List<Blocks> geAllBlocksWithDistrict(Districts districts){
        List<Blocks> blocksList = blockRepository.findAllByDistricts(districts);
        return blocksList;
    }
}
