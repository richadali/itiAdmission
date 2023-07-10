package com.dect.itiAdmission.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateDTO {
    private Long stateCode;
    private String stateNameEnglish;
    private String stateNameLocal;
    private String census2001Code;
    private String census2011Code;
}
