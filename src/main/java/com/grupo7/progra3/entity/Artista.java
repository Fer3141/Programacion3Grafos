package com.grupo7.progra3.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Artista")
public class Artista {
    @Id
    private final String nombre;
    private final Integer anioNacimiento;

    @Relationship(type = "COLABORO_CON", direction = INCOMING)
    private Set<Artista> colaboraciones = new HashSet<>();

    public Artista(String nombre, Integer anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public Set<Artista> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(Set<Artista> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", colaboraciones=" + colaboraciones +
                '}';
    }
}
