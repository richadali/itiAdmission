package com.dect.itiAdmission.domain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CenterTrades {

    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Centers centerId;
    @ManyToOne
    @JoinColumn(name = "trade_id")
    private Trades tradeId;
    private Integer maxSeats;
    private Character isActive;

}
