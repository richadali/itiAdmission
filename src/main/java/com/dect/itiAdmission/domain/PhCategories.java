package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PhCategories {
    @Id
    private Integer phCategoryId;
    private String phCategoryType;
    private Integer phPercentage;
}
