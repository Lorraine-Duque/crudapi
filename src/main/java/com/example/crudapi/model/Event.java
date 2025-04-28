package com.example.crudapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do evento é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(nullable = false)
    private String descricao;

    @NotBlank(message = "Local é obrigatório")
    @Column(nullable = false)
    private String local;

    @NotNull(message = "Data de início é obrigatória")
    @Column(nullable = false)
    private LocalDate dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    @Column(nullable = false)
    private LocalDate dataFim;

    @NotNull(message = "Indicação de evento para adultos é obrigatória")
    @Column(nullable = false)
    private Boolean publicoAlvoAdulto;


}
