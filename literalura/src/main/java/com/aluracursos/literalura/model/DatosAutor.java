package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias ("birth_year") String fecha_nacimiento,
        @JsonAlias ("death_year") String fecha_fallecimiento
) {
}
