package com.dect.itiAdmission.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VillageDTO {

    private Long villageCode;
    private String villageNameEnglish;
    private String villageNameLocal;
    private String census2001Code;
    private String census2011Code;
    private String sscode;
}
