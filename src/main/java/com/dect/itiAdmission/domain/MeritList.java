package com.dect.itiAdmission.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeritList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long meritListId;
    @OneToOne
    @JoinColumn(name = "applicantionnumber")
    private ApplicationDetails applicationDetails;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    private String ph;
    @ManyToOne
    @JoinColumn(name = "trade_code")
    private Trades trades;
    @ManyToOne
    @JoinColumn(name= "center_id")
    private Centers centers;
}
