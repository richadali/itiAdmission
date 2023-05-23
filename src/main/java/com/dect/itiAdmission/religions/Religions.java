package com.dect.itiAdmission.religions;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Religions {
    @Id
    private Integer religionId;
    private String religionName;
}
