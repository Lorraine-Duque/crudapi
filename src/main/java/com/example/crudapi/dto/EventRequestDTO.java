package com.example.crudapi.dto;

import com.example.crudapi.model.Event;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EventRequestDTO {

    @NotBlank(message = "Nome do evento é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "Local é obrigatório")
    private String local;

    @NotNull(message = "Data de início é obrigatória")
    private LocalDate dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    private LocalDate dataFim;

    @NotNull(message = "Indicação de evento para adultos é obrigatória")
    private Boolean publicoAlvoAdulto;

    // Método para converter DTO em Model
    public Event toEntity() {
        Event event = new Event();
        event.setNome(this.nome);
        event.setDescricao(this.descricao);
        event.setLocal(this.local);
        event.setDataInicio(this.dataInicio);
        event.setDataFim(this.dataFim);
        event.setPublicoAlvoAdulto(this.publicoAlvoAdulto);
        return event;
    }
}
