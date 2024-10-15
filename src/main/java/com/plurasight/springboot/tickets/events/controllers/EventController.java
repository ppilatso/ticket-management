package com.plurasight.springboot.tickets.events.controllers;

import com.plurasight.springboot.tickets.events.Event;
import com.plurasight.springboot.tickets.events.Organizer;
import com.plurasight.springboot.tickets.events.Product;
import com.plurasight.springboot.tickets.events.repository.EventRepository;
import com.plurasight.springboot.tickets.events.repository.OrganizerRepository;
import com.plurasight.springboot.tickets.events.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final ProductRepository productRepository;
    private final EventRepository eventRepository;

    private EventController(OrganizerRepository organizerRepository,
                            ProductRepository productRepository,
                            EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.organizerRepository = organizerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(path = "/events")
    public List<Event> getEventsByOrganizer(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizationId(organizerId);
    }

    @GetMapping(path = "/events/{id}")
    public Event getEventById(@PathVariable("id") int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NoSuchElementException("Event not found " + eventId));
    }

    @GetMapping(path = "/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }
}
