//package com.dect.itiAdmission.domain;
//
//import javax.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Set;
//import java.util.UUID;
////
////@Entity
////@Table(name = "ivcs",
////        uniqueConstraints = { @UniqueConstraint(columnNames = { "ivcs_serial_no"})})
////
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
//public class IVCS {
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private  Long id;
////    private String registrationNo;
////    @Column(unique = true)
////    private String name;
////    private Long bankId;
////    private Long bankBranch;
////    private String bankIfsc;
////    private Boolean whetherBankAccountOpened;
////
////    private String bankAccount;
////    private Boolean isPanCardAvailable;
////    private String panCardNo;
////    private Boolean isOfficeSpaceAvailable;
////
////    private String addressOfficeSpace;
////    private Integer districtId;
////    private Long blockId;
////    @Column(name = "ivcs_serial_no")
////    private String iVCSSerialNumber;
////
//////    @OneToMany(mappedBy = "ivcs")
//////    private Set<VillageOperatedIn> villageOperatedInList;
////
//////    @OneToOne(mappedBy = "ivcs")
//////    private IVCSSecretary ivcsSecretary;
////
////    private Date createdOn;
////
////    private Date updatedOn;
////
////    @PrePersist
////    public void onCreate() {
////        Calendar cal = Calendar.getInstance();
////        Date date = new Date();
////        this.setCreatedOn(date);
////        this.setUpdatedOn(date);
////
////        String serial = "ML/IVCS/"+cal.get(Calendar.YEAR)+"/"+ UUID.randomUUID().toString().substring(0,5);
////        this.setIVCSSerialNumber(serial);
////    }
////
////    @PreUpdate
////    public void onUpdate(){
////        Calendar cal = Calendar.getInstance();
////        Date date = new Date();
////        this.setUpdatedOn(date);
////
////    }
//
//}
