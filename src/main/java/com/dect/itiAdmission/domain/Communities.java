package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Communities {
    @Id
    private Integer communityId;
    private String communityName;
}
