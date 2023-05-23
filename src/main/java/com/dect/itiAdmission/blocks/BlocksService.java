package com.dect.itiAdmission.blocks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocksService {

    private BlocksRepository blocksRepository;

    public BlocksService(BlocksRepository blocksRepository) {
        this.blocksRepository = blocksRepository;
    }

    public List<Blocks> getBlock() {
        return blocksRepository.findAll();
    }
}
