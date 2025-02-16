package com.grupo7.progra3.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Cancion")
public class Cancion {
    @Id
    private final String titulo;

    @Property("genero")
    private final String genero;

    @Property("anioLanzamiento")
    private final Integer anioLanzamiento;

    @Relationship(type = "CANTADA_POR", direction = INCOMING)
    private Set<Artista> artistas = new HashSet<>();

    public Cancion(String titulo, String genero, Integer anioLanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", artistas=" + artistas +
                '}';
    }
}
