package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Gender {
    @Id
    private String genderId;
    private String genderName;
}
