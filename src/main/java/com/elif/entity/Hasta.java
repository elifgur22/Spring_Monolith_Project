package com.elif.entity;

import com.elif.utility.enums.ECinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_hasta")
public class Hasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String ad;
    @Column(nullable = false)
    String soyad;
    @Column(nullable = false)
    String telefon;
    @Lob
    String adres;
    int yas;
    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;

}
