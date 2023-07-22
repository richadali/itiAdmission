package com.dect.itiAdmission.dtos;

import com.dect.itiAdmission.domain.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
public class GetApplicationDetailsDTO {
    private String applicationnumber;
    private String centers;
    private String applicantname;
    private String fathername;
    private String mothername;
    private Gender gender;
    private Date dob;
    private String categories;
    private Religions religions;
    private Tribes tribes;
    private String maritalStatus;
    private String mothertongue;
    private String mobilenumber;
    private String photograph;
    private String highestQualification;
    private String email;
    private String states;
    private String districts;
    private String townperm;
    private String addressperm;
    private String pincodeperm;
    private String statescorr;
    private String districtscorr;
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
    private String trades1;
    private String trades2;
    private String trades3;
    private Date submissiondate;
    private String ph;
    private Double percentage;
    private Character mathsScience;
    private Character tenthPass;
}
