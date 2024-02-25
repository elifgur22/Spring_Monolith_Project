package com.elif.repository;

import com.elif.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoktorRepository extends JpaRepository<Doktor,Long> {
    Optional<Doktor> findOptionalByAdAndSoyad(String ad, String soyad);

}
