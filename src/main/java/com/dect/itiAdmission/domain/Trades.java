package com.dect.itiAdmission.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Trades {
    @Id
    private Integer tradeCode;
    private String tradeName;
    private Character tenthPass;
    private Character mathSc;
}
