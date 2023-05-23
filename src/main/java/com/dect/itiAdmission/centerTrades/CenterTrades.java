package com.dect.itiAdmission.centerTrades;

import com.dect.itiAdmission.centers.Centers;
import com.dect.itiAdmission.trades.Trades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

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
