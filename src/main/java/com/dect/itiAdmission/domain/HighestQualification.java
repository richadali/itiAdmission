package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HighestQualification {
    @Id
    private Integer qualificationId;
    private String qualificationName;
}
