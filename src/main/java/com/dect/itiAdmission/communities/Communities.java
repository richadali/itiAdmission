package com.dect.itiAdmission.communities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Communities {
    @Id
    private Integer communityId;
    private String communityName;
}
