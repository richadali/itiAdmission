package com.dect.itiAdmission.blocks;

import com.dect.itiAdmission.districts.District;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Blocks {
    @Id
    private Integer blockCode;
    private String blockName;
    @ManyToOne
    @JoinColumn(name = "district_code")
    private District districtCode;
}
