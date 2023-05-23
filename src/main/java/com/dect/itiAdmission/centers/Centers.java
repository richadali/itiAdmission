package com.dect.itiAdmission.centers;

import com.dect.itiAdmission.districts.District;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Centers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer centerId;
    private String centerName;
    private Character centerType;
    private String address;
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District districtId;
}
