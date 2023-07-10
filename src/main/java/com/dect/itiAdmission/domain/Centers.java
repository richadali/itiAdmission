package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.*;

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
    private Districts districtId;
}
