package com.dect.itiAdmission.languages;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Languages {
    @Id
    private Integer languageId;
    private String language;
}
