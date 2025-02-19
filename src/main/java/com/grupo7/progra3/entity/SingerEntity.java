package com.grupo7.progra3.entity;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Singer")
public class SingerEntity {
    @Id
    private String name;

    public SingerEntity(String name) { this.name = name; }

    public String getName() { return name; }
}
