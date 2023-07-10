package com.dect.itiAdmission.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MeritList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long meritListId;
    @OneToOne
    @JoinColumn(name = "applicantionnumber")
    private ApplicationDetails applicationDetails;
    private Integer phase;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    private String ph;
}
