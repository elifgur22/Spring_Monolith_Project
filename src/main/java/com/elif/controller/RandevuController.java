package com.elif.controller;
import com.elif.entity.Randevu;
import com.elif.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.elif.utility.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(ADD)
    public ResponseEntity<Randevu> save(@RequestBody @Valid Randevu randevu){
        return ResponseEntity.ok(randevuService.save(randevu));
    }


    @GetMapping(GET_ALL)
    public ResponseEntity<List<Randevu>> getAllFeatures() {
        List<Randevu> randevuList = randevuService.findAll();
        return ResponseEntity.ok(randevuList);
    }


}
