package com.example.crudapi.service;

import com.example.crudapi.model.Event;
import java.util.List;

public interface EventService {
    List<Event> listAll();

    Event create(Event newEvent);

    Event update(Long id, Event eventUpdate);

    void delete(Long id);

    Event getById(Long id);
}
