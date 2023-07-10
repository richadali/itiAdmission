package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MaritalStatus {
    @Id
    private String maritalStatusId;
    private String maritalStatus;
}
