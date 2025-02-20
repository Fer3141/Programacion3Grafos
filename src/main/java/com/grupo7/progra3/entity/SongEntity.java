package com.grupo7.progra3.entity;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.Set;

@Node("Song")
public class SongEntity {
    @Id
    private String title;

    @Relationship(type = "SUNG_BY")
    private Set<SingerEntity> singers;

    public SongEntity(String title, Set<SingerEntity> singers) {
        this.title = title;
        this.singers = singers;
    }

    public String getTitle() { return title; }
    public Set<SingerEntity> getSingers() { return singers; }

}