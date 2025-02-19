package com.grupo7.progra3.repository;


import com.grupo7.progra3.entity.SongEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface SongRepository extends ReactiveNeo4jRepository<SongEntity, String> {}