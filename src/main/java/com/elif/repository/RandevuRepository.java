package com.elif.repository;

import com.elif.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RandevuRepository extends JpaRepository<Randevu,Long> {

    List<Randevu> findAllByDoktorid (Long id);
}
