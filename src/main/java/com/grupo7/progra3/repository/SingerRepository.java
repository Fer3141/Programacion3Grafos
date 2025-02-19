package com.grupo7.progra3.repository;

import com.grupo7.progra3.entity.SingerEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface SingerRepository extends ReactiveNeo4jRepository<SingerEntity, String> {}
