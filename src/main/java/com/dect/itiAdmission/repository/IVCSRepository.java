//package com.dect.itiAdmission.repository;
//import com.dect.itiAdmission.domain.IVCS;
//import com.dect.itiAdmission.dtos.IvcsCountDistrictWise;
//import com.dect.itiAdmission.dtos.VillageTempDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//
//@Repository
//public interface IVCSRepository extends JpaRepository<IVCS,Long> {
//    IVCS findByiVCSSerialNumber(String serialNumber);
//
//
//    @Query(value="SELECT v.* from village_operated_in " +
//            "INNER JOIN villages v on village_operated_in.village_id=v.id " +
//            "WHERE village_operated_in.ivcs_id = ?1",
//            nativeQuery = true)
//    Collection<VillageTempDTO> findVillagesOparatedin(Long id);
//
//
//    @Query(value = "SELECT districts.id, districts.name, COUNT(ivcs.id) FROM ivcs RIGHT JOIN districts ON districts.id = ivcs.district_id GROUP BY" +
//            " ivcs.district_id, districts.name,districts.id ORDER BY COUNT(ivcs.id) DESC",nativeQuery = true)
//    Collection<IvcsCountDistrictWise> getCountDistrictWise();
//
//}
