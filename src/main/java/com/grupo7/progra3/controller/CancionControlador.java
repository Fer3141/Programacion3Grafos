package com.grupo7.progra3.controller;

import com.grupo7.progra3.entity.Cancion;
import com.grupo7.progra3.repository.CancionRepositorio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/canciones")
public class CancionControlador {
    private final CancionRepositorio cancionRepositorio;

    public CancionControlador(CancionRepositorio cancionRepositorio) {
        this.cancionRepositorio = cancionRepositorio;
    }

    @PutMapping
    public Mono<Cancion> crearOActualizarCancion(@RequestBody Cancion nuevaCancion) {
        return cancionRepositorio.save(nuevaCancion);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Cancion> obtenerCanciones() {
        return cancionRepositorio.findAll();
    }
}
