package com.dect.itiAdmission.maritalStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MaritalStatus {
    @Id
    private Integer maritalStatusId;
    private String maritalStatus;
}
