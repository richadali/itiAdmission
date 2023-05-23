package com.dect.itiAdmission.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categories {
    @Id
    private Integer categoryId;
    private String categoryName;
}
