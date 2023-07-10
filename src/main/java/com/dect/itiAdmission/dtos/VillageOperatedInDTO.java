package com.dect.itiAdmission.dtos;

//import com.dect.itiAdmission.domain.IVCS;
import com.dect.itiAdmission.domain.Villages;
import com.dect.itiAdmission.repository.VillageRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageOperatedInDTO {
    private Long id;
//    private IVCS ivcsIs;
    private Villages villages;

    @Autowired
    static
    VillageRepository villageRepository;

//    public static VillageOperatedIn convertDTOToEntity(Villages villages,IVCS ivcs){
//        VillageOperatedIn villageOperatedIn = new VillageOperatedIn();
//
//
//        villageOperatedIn.setVillage(villages);
//        villageOperatedIn.setIvcs(ivcs);
//        return villageOperatedIn;
//    }

}
