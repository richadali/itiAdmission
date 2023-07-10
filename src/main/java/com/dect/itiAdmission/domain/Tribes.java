package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Tribes {
    @Id
    private Integer tribeId;
    private String tribeName;
}
