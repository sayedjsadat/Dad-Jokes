package edu.greenriver.dev.dadjokes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DadJoke {

    //getters/setters, toString(), equals/hashcode, ...
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Movie
    {
        //auto-increment field
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String dadjoke;
    }
}
