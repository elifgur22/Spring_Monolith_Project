package com.elif.service;

import com.elif.entity.Hasta;
import com.elif.repository.HastaRepository;
import com.elif.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HastaService implements ICrudService<Hasta,Long> {
    private final HastaRepository hastaRepository;

    @Override
    public Hasta save(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    @Override
    public Hasta update(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    @Override
    public Iterable<Hasta> saveAll(Iterable<Hasta> t) {
        return hastaRepository.saveAll(t);
    }

    @Override
    public Hasta deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Hasta> findById(Long id) {
        Optional<Hasta> optionalHasta = hastaRepository.findById(id);
        if(optionalHasta.isPresent()){
             hastaRepository.delete(optionalHasta.get());
             return optionalHasta;
        }else{
            throw new NullPointerException("Hasta is not found");
        }
    }

    @Override
    public List<Hasta> findAll() {
        List<Hasta> hastaList = hastaRepository.findAll();
        if (hastaList.isEmpty()) {
            throw new NullPointerException("List is empty.");
        }
        return hastaList;
    }
}
