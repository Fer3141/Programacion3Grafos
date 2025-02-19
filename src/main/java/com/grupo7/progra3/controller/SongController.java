package com.grupo7.progra3.controller;


import com.grupo7.progra3.entity.SingerEntity;
import com.grupo7.progra3.entity.SongEntity;
import com.grupo7.progra3.repository.SongRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/songs")
public class SongController {
    private final SongRepository songRepository;
    public SongController(SongRepository songRepository) { this.songRepository = songRepository; }

    @PutMapping
    Mono<SongEntity> createOrUpdateSong(@RequestBody SongEntity newSong) {
        return songRepository.save(newSong);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<SongEntity> getSongs() {
        return songRepository.findAll();
    }

    @PutMapping("/add")
    public Mono<SongEntity> createOrUpdateSongByParams(
            @RequestParam String title,
            @RequestParam List<String> singers) {

        Set<SingerEntity> singerEntities = singers.stream()
                .map(SingerEntity::new)
                .collect(Collectors.toSet());

        SongEntity newSong = new SongEntity(title, singerEntities);
        return songRepository.save(newSong);
    }


    @GetMapping("/add")
    public Mono<SongEntity> addSongByGet(
            @RequestParam String title,
            @RequestParam List<String> singers) {

        Set<SingerEntity> singerEntities = singers.stream()
                .map(SingerEntity::new)
                .collect(Collectors.toSet());

        SongEntity newSong = new SongEntity(title, singerEntities);
        return songRepository.save(newSong);
    }


}