package com.dect.itiAdmission.districts;

import com.dect.itiAdmission.states.States;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.profile.Fetch;

@Entity
@Data
public class District {
    @Id
    private Integer districtCode;
    private String districtName;
    @ManyToOne
    @JoinColumn(name = "state_code")
    private States stateCode;
}
