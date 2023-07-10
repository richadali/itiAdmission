package com.dect.itiAdmission.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Categories {
    @Id
    private String categoryId;
    private String categoryName;
}