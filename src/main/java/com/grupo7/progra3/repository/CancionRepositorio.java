package com.grupo7.progra3.repository;

import com.grupo7.progra3.entity.Cancion;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface CancionRepositorio extends ReactiveNeo4jRepository<Cancion, String> {
}
