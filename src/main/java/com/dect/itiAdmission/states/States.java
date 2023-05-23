package com.dect.itiAdmission.states;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class States {
    @Id
    private Integer stateCode;
    private String stateName;
}
