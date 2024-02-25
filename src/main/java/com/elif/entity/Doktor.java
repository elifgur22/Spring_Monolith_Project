package com.elif.entity;

import com.elif.utility.enums.EBrans;
import com.elif.utility.enums.EUnvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    EBrans brans =EBrans.BELIRTILMEDI;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    EUnvan unvan= EUnvan.UZMAN;

    @ElementCollection
    Map<String,String> musaitZamanlar;
    //daha doğrusu Map<String, LocalDate> şeklinde yazmak olabilirdi işlemleri karıştırmasın diye yazmadım.
}
