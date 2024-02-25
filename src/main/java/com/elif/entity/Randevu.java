package com.elif.entity;

import com.elif.utility.enums.EDurum;
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
@Table(name = "tbl_randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "doktor_id")
    Long doktorid;
    @Column(name = "hasta_id")
    Long hastaid;
    String gun;
    String ay;
    String yil;
    String saat;
    @Enumerated(EnumType.STRING)
    EDurum durum;
}
