package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ApplicationDetails {

    @Id
    private String applicationnumber;
    @OneToOne
    @JoinColumn(name = "iticentrecode")
    private Centers centers;
    private String applicantname;
    private String fathername;
    private String mothername;
    @OneToOne
    @JoinColumn(name = "gender")
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToOne
    @JoinColumn(name = "category")
    private Categories categories;
    @OneToOne
    @JoinColumn(name = "religion")
    private Religions religions;
    @OneToOne
    @JoinColumn(name = "tribe")
    private Tribes tribes;
    @OneToOne
    @JoinColumn(name = "maritalstatus")
    private MaritalStatus maritalStatus;
    private String mothertongue;
    private String mobilenumber;
    @Column(columnDefinition = "TEXT")
    private String photograph;
    @OneToOne
    @JoinColumn(name = "highestqualification")
    private HighestQualification highestQualification;
    private String email;
    @OneToOne
    @JoinColumn(name = "stateperm")
    private States states;
    @OneToOne
    @JoinColumn(name = "districtperm")
    private Districts districts;
    private String townperm;
    private String addressperm;
    private String pincodeperm;
    @OneToOne
    @JoinColumn(name = "statecorr")
    private States statescorr;
    @OneToOne
    @JoinColumn(name = "districtcorr")
    private Districts districtscorr;
    private String towncorr;
    private String addresscorr;
    private String pincodecorr;
    private String accountnumber;
    private String ifsccode;
    private String bankname;
    private String institutetenth;
    private String boardtenth;
    private String yearpassingtenth;
    private String percentagetenth;
    private String divisiontenth;
    private String subjectstenth;
    private String haveyoupassedboth;
    private String marksmaths;
    private String marksscience;
    private String instituteeight;
    private String boardeight;
    private String yearpassingeight;
    private String percentageeight;
    private String divisioneight;
    private String subjectseight;
    @OneToOne
    @JoinColumn(name = "preferenceone")
    private Trades trades1;
    @OneToOne
    @JoinColumn(name = "preferencetwo", nullable = true)
    private Trades trades2;
    @OneToOne
    @JoinColumn(name = "preferencethree", nullable = true )
    private Trades trades3;
    @Temporal(TemporalType.DATE)
    private Date submissiondate;
    private String ph;

}
