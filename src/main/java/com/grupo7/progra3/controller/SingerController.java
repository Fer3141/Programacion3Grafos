package com.grupo7.progra3.controller;

import com.grupo7.progra3.entity.SingerEntity;
import com.grupo7.progra3.repository.SingerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/singers")
public class SingerController {
    private final SingerRepository singerRepository;

    public SingerController(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    // Obtener todos los cantantes
    @GetMapping(value = { "", "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<SingerEntity> getAllSingers() {
        return singerRepository.findAll();
    }

    // Obtener un cantante por nombre
    @GetMapping("/find")
    public Mono<SingerEntity> getSingerByName(@RequestParam String name) {
        return singerRepository.findById(name);
    }
}
