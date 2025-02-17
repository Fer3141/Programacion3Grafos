package com.grupo7.progra3.repository;

import com.grupo7.progra3.entity.Artista;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Flux;

public interface ArtistaRepositorio extends ReactiveNeo4jRepository<Artista, String> {
    Flux<Artista> findAllByOrderByNombreAsc();
}
