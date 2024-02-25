package com.elif.dto.response;

import com.elif.utility.enums.EBrans;
import com.elif.utility.enums.EUnvan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoktorResponseDto {
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    EBrans brans;
    EUnvan unvan;
}
