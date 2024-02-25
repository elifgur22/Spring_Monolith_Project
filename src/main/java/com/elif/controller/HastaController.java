package com.elif.controller;
import com.elif.entity.Hasta;
import com.elif.service.HastaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.elif.utility.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HASTA)
public class HastaController {
    private final HastaService hastaService;
    @PostMapping(ADD)
    public ResponseEntity<Hasta> save(@RequestBody @Valid Hasta hasta){
        return ResponseEntity.ok(hastaService.save(hasta));
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<Optional<Hasta>> findById(@PathVariable Long id){
        return ResponseEntity.ok(hastaService.findById(id));
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Hasta>> getAllFeatures() {
        return ResponseEntity.ok(hastaService.findAll());
    }
}
