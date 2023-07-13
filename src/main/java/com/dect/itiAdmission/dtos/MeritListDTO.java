package com.dect.itiAdmission.dtos;

import com.dect.itiAdmission.domain.ApplicationDetails;
import com.dect.itiAdmission.domain.Categories;
import com.dect.itiAdmission.domain.Trades;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MeritListDTO implements Serializable {
    private final String applicationNumber;
    private final Integer selectedPhase;
    private final String selectedReservation;
    private final String selectedPh;
    private final Integer selectedTrade;
    private final Integer selectedITI;
}
