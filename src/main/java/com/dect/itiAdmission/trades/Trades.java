package com.dect.itiAdmission.trades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Trades {
    @Id
    private Integer tradeId;
    private String tradeName;
    private Integer minQualification;
    private Character isMsMandatory;
}
