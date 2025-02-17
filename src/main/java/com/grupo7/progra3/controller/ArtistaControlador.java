package com.grupo7.progra3.controller;

import com.grupo7.progra3.entity.Artista;
import com.grupo7.progra3.repository.ArtistaRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artistas")
@CrossOrigin(origins = "*")
public class ArtistaControlador {

    private final ArtistaRepositorio artistaRepositorio;

    public ArtistaControlador(ArtistaRepositorio artistaRepositorio) {
        this.artistaRepositorio = artistaRepositorio;
    }

    @PutMapping
    public Mono<ResponseEntity<Artista>> crearArtista(@RequestBody Artista nuevoArtista) {
        return artistaRepositorio.save(nuevoArtista)
                .map(artista -> ResponseEntity.ok().body(artista))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public Flux<Artista> obtenerArtistas() {
        return artistaRepositorio.findAllByOrderByNombreAsc();
    }
}
