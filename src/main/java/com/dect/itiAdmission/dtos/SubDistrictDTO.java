package com.dect.itiAdmission.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubDistrictDTO {

    private Long subdistrictCode;
    private String subdistrictNameEnglish;
    private String subdistrictNameLocal;
    private String census2001Code;
    private String census2011Code;
    private String sscode;
}
