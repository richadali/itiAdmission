package com.dect.itiAdmission.blocks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class BlocksController<BlockService> {

    private BlocksService blocksService;

    public BlocksController(BlocksService blocksService) {
        this.blocksService = blocksService;
    }

    @GetMapping("api/getBlocks")
    public ResponseEntity<?> getBlocks(){
        return new ResponseEntity<>(blocksService.getBlock(), HttpStatus.OK);
    }
}
