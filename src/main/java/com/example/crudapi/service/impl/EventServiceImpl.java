package com.example.crudapi.service.impl;

import com.example.crudapi.model.Event;
import com.example.crudapi.repository.EventRepository;
import com.example.crudapi.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    @Override
    public Event update(Long id, Event eventUpdate) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com id: " + id));

        existingEvent.setNome(eventUpdate.getNome());
        existingEvent.setDescricao(eventUpdate.getDescricao());
        existingEvent.setLocal(eventUpdate.getLocal());
        existingEvent.setDataInicio(eventUpdate.getDataInicio());
        existingEvent.setDataFim(eventUpdate.getDataFim());
        existingEvent.setPublicoAlvoAdulto(eventUpdate.getPublicoAlvoAdulto());

        return eventRepository.save(existingEvent);

    }

    @Override
    public void delete(Long id) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com id: " + id));
        eventRepository.delete(existingEvent);
    }

    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com id: " + id));

    }
}
