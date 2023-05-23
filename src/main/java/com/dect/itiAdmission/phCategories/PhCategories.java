package com.dect.itiAdmission.phCategories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PhCategories {
    @Id
    private Integer phCategoryId;
    private String phCategoryType;
    private Integer phPercentage;
}
