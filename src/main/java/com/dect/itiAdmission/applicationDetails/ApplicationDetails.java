package com.dect.itiAdmission.applicationDetails;

import com.dect.itiAdmission.blocks.Blocks;
import com.dect.itiAdmission.categories.Categories;
import com.dect.itiAdmission.centers.Centers;
import com.dect.itiAdmission.communities.Communities;
import com.dect.itiAdmission.districts.District;
import com.dect.itiAdmission.languages.Languages;
import com.dect.itiAdmission.maritalStatus.MaritalStatus;
import com.dect.itiAdmission.phCategories.PhCategories;
import com.dect.itiAdmission.religions.Religions;
import com.dect.itiAdmission.trades.Trades;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Block;

import java.util.Date;

@Entity
@Data
public class ApplicationDetails {

    @Id
    private Long applicantId;
    private String spApplicantId;
    private String advertNo;
    private String fullName;
    private String fatherName;
    private String motherName;
    private String guardianName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String localityName;
    @OneToOne
    @JoinColumn(name = "block_id")
    private Blocks blockId;
    @OneToOne
    @JoinColumn(name = "district_id")
    private District districtId;
    private String mobileNo;
    private String email;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Categories categoryId;
    @OneToOne
    @JoinColumn(name = "community_id")
    private Communities communityId;
    @OneToOne
    @JoinColumn(name = "religion_id")
    private Religions religionId;
    @OneToOne
    @JoinColumn(name = "language_spoken_id")
    private Languages languageId;
    @OneToOne
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatusId;
    @OneToOne
    @JoinColumn(name = "ph_category_id")
    private PhCategories phCategoryId;
    private String bankName;
    private String bankBranch;
    private String bankAcNo;
    private String bankIfsc;
    private String institutionName8;
    private String boardName8;
    private String passingYear8;
    private String percentage8;
    private String institutionName10;
    private String boardName10;
    private String passingYear10;
    private String percentage10;
    private String mathsMarks;
    private String scienceMarks;
    @OneToOne
    @JoinColumn(name = "center_id")
    private Centers centerId;
    @OneToOne
    @JoinColumn(name = "trade_1_id")
    private Trades tradeId1;
    @OneToOne
    @JoinColumn(name = "trade_2_id")
    private Trades tradeId2;
    @OneToOne
    @JoinColumn(name = "trade_3_id")
    private Trades tradeId3;
    @Lob
    private Byte[] photo;
    @Lob
    private Byte[] dob_cert;
    @Lob
    private Byte[] marksheet8;
    @Lob
    private Byte[] marksheet10;

}
