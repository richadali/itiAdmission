package com.dect.itiAdmission.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {

    private Long districtCode;
    private String districtNameEnglish;
    private String districtNameLocal;
    private String census2001Code;
    private String census2011Code;
    private String sscode;
}
