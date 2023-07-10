package com.dect.itiAdmission.repository;
import com.dect.itiAdmission.domain.Blocks;
import com.dect.itiAdmission.domain.Villages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Villages,Long> {
    List<Villages>  findAllByBlocks(Blocks blocks);

}
