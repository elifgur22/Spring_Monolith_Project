package com.elif.service;

import com.elif.entity.Randevu;
import com.elif.repository.RandevuRepository;
import com.elif.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandevuService implements ICrudService<Randevu,Long>{

    private final RandevuRepository randevuRepository;

    @Override
    public Randevu save(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    @Override
    public Randevu update(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    @Override
    public Iterable<Randevu> saveAll(Iterable<Randevu> t) {
        return randevuRepository.saveAll(t);
    }

    @Override
    public Randevu deleteById(Long id) {
        return null;
    }

    @Override
    public Optional<Randevu> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Randevu> findAll() {
        List<Randevu> randevuList = randevuRepository.findAll();
        if (randevuList.isEmpty()) {
            throw new NullPointerException("List is empty.");
        }
        return randevuList;
    }

    public List<Randevu> findAllByDoktorid(Long id) {
        return randevuRepository.findAllByDoktorid(id);
    }
}
