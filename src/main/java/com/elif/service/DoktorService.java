package com.elif.service;

import com.elif.dto.request.DoktorInfoRequestDto;
import com.elif.dto.request.DoktorSaveRequestdto;
import com.elif.dto.response.DoktorResponseDto;
import com.elif.entity.Doktor;
import com.elif.entity.Randevu;
import com.elif.exception.ErrorType;
import com.elif.exception.HastaneRandevuException;
import com.elif.mapper.DoktorMapper;
import com.elif.repository.DoktorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoktorService  {
    private final DoktorRepository doktorRepository;
    private final RandevuService randevuService;


    public DoktorResponseDto save(DoktorSaveRequestdto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.fromDoktorSaveRequestDtoToDoktor(dto);
        Optional<Doktor> optionalDoktor= doktorRepository.findOptionalByAdAndSoyad(doktor.getAd(),doktor.getSoyad());
        if(optionalDoktor.isEmpty()){
            doktorRepository.save(doktor);
           return DoktorMapper.INSTANCE.fromDoktorToDoktorResponseDto(doktor);
        }else {
            throw new HastaneRandevuException(ErrorType.ERROR_DUPLICATE_DOKTOR_HATASI);
        }

    }


    public Doktor update(Doktor doktor) {
        return doktorRepository.save(doktor);
    }


    public Iterable<Doktor> saveAll(Iterable<Doktor> t) {
        return doktorRepository.saveAll(t);
    }


    public Doktor deleteById(Long id) {
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if(optionalDoktor.isPresent()){
            return doktorRepository.save(optionalDoktor.get());
        }else{
            throw new NullPointerException("Doctor not found");
        }
    }


    public Optional<Doktor> findById(Long id) {
        Optional<Doktor> doktor = doktorRepository.findById(id);
        if (doktor.isPresent()) {
            return doktor;
        } else {
            throw new NullPointerException("Doctor not found");
        }
    }

    public List<Doktor> findAll() {
        List<Doktor> doktorList = doktorRepository.findAll();
        if (doktorList.isEmpty()) {
            throw new NullPointerException("List is empty.");
        }
        return doktorList;
    }


    public Optional<Doktor> findOptionalByAdAndSoyad(String ad, String soyad) {
        return doktorRepository.findOptionalByAdAndSoyad(ad,soyad);
    }

    public List<Randevu> findAllByDoctorInfo(DoktorInfoRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.fromDoktorInfoRequestDtoToDoktor(dto);
        Optional<Doktor> optionalDoktor= doktorRepository.findOptionalByAdAndSoyad(doktor.getAd(),doktor.getSoyad());

        if(optionalDoktor.isEmpty()){
            throw new HastaneRandevuException(ErrorType.ERROR_DOCTOR_NOT_FOUND);
        }

        List<Randevu> randevuList = randevuService.findAllByDoktorid(optionalDoktor.get().getId());
        if (randevuList.isEmpty()){
            throw new HastaneRandevuException(ErrorType.ERROR_EMPTY_LIST);
        }
        return randevuList;
    }
}
