package com.elif.controller;
import com.elif.dto.request.DoktorInfoRequestDto;
import com.elif.dto.request.DoktorSaveRequestdto;
import com.elif.dto.response.DoktorResponseDto;
import com.elif.entity.Doktor;
import com.elif.entity.Randevu;
import com.elif.service.DoktorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.elif.utility.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
public class DoktorController {
    private final DoktorService doktorService;

    @PostMapping(ADD)
    public ResponseEntity<DoktorResponseDto> save(@RequestBody @Valid DoktorSaveRequestdto dto){
        return ResponseEntity.ok(doktorService.save(dto));
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<Doktor>> getAll(){
        return ResponseEntity.ok( doktorService.findAll());
    }

    //Hastane doktorların durumlarını görmek için randevularını bu metot sayesinde bulabilir;
    @PostMapping(GET_RANDEVULAR_BY_DOKTOR_INFO)
    public ResponseEntity<List<Randevu>> getAllByDoctorInfo(@RequestBody @Valid DoktorInfoRequestDto dto){
        return ResponseEntity.ok(doktorService.findAllByDoctorInfo(dto));
    }
}
