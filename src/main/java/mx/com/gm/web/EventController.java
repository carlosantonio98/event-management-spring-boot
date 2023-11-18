package mx.com.gm.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.gm.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;

import mx.com.gm.domain.Event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@Slf4j
public class EventController {

    // Inyección de dependencia
    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        try {
            List<Event> events = eventService.listarEventos();

            System.out.println(events);

            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/events")
    public ResponseEntity<Event> create(@RequestBody Event event) {
        try {
            Event _event = eventService.guardar(new Event(event.getName(), event.getDescription(), event.getStartDate(), event.getEndDate(), event.getLocation(), event.getPrice(), event.getCapacity(), event.getRequirements(), event.getCategoryFk()));
            return new ResponseEntity<>(_event, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> update(@RequestBody Event event) {
        try {
            Event _event = eventService.guardar(event);
            return new ResponseEntity<>(_event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            Event event = new Event();
            event.setId(id);
            
            eventService.eliminar(event);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> eventById(@PathVariable("id") long id) {
        try {
            Event event = new Event();
            event.setId(id);

            Event _event = eventService.encontrarEvento(event);

            return new ResponseEntity<>(_event, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
