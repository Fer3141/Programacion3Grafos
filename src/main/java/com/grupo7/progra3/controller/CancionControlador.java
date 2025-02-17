package com.grupo7.progra3.controller;

import com.grupo7.progra3.entity.Cancion;
import com.grupo7.progra3.repository.CancionRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/canciones")
@CrossOrigin(origins = "*")  // Habilita peticiones desde cualquier origen
public class CancionControlador {
    private final CancionRepositorio cancionRepositorio;

    public CancionControlador(CancionRepositorio cancionRepositorio) {
        this.cancionRepositorio = cancionRepositorio;
    }

    @PutMapping
    public Mono<ResponseEntity<Cancion>> crearCancion(@RequestBody Cancion nuevaCancion) {
        return cancionRepositorio.save(nuevaCancion)
                .map(cancion -> ResponseEntity.ok().body(cancion))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public Flux<Cancion> obtenerCanciones() {
        return cancionRepositorio.findAll();
    }
}
