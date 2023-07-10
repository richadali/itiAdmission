package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Religions {
    @Id
    private Integer religionId;
    private String religionName;
}
