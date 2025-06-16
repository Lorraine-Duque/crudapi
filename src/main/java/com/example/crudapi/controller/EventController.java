package com.example.crudapi.controller;

import com.example.crudapi.dto.EventRequestDTO;
import com.example.crudapi.model.Event;
import com.example.crudapi.service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@AllArgsConstructor
@CrossOrigin
public class EventController {

    EventService eventService;

    @GetMapping
    public List<Event> listAll() {
        return eventService.listAll();
    }

    @PostMapping
    public ResponseEntity<Event> create(
            @RequestBody @Valid EventRequestDTO eventRequest) {
        Event newEvent = eventRequest.toEntity();
        return ResponseEntity.ok(eventService.create(newEvent));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(
            @PathVariable Long id,
            @RequestBody @Valid EventRequestDTO eventRequest){
        Event eventUpdate = eventRequest.toEntity();
        return ResponseEntity.ok(eventService.update(id, eventUpdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        Event event = eventService.getById(id);
        return ResponseEntity.ok(event);
    }


}
