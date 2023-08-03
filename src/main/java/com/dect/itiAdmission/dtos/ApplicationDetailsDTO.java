package com.dect.itiAdmission.dtos;

import com.dect.itiAdmission.domain.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
public class ApplicationDetailsDTO {
    private String applicationnumber;
    private String applicantname;
    private String fathername;
    private String mothername;
    private String gender;
    private Date dob;
    private String categories;
    private Integer religions;
    private Integer tribes;
    private String maritalStatus;
    private String mothertongue;
    private Long districts;
    private String townperm;
    private String addressperm;
    private String pincodeperm;
    private Long districtscorr;
    private String towncorr;
    private String addresscorr;
    private String pincodecorr;
    private String accountnumber;
    private String ifsccode;
    private String bankname;
//    private String institutetenth;
//    private String boardtenth;
//    private String yearpassingtenth;
//    private String percentagetenth;
//    private String divisiontenth;
//    private String subjectstenth;
//    private String haveyoupassedboth;
//    private String marksmaths;
//    private String marksscience;
//    private String instituteeight;
//    private String boardeight;
//    private String yearpassingeight;
//    private String percentageeight;
//    private String divisioneight;
//    private String subjectseight;
//    private String ph;
}
