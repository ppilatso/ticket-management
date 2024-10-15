package com.plurasight.springboot.tickets.events.repository;

import com.plurasight.springboot.tickets.events.Event;
import com.plurasight.springboot.tickets.events.Organizer;
import com.plurasight.springboot.tickets.events.Venue;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private final List<Event> events = List.of(
            new Event(501, "Globomatics Tech Conference",
                    new Organizer(101, "Globomatics", "Globomatics Technology Corporations"),
                    new Venue(201, "Globomatics Main Office", "Test Street 222", "New York", "USA"),
                    LocalDate.of(2024, 11, 2), LocalDate.of(2024, 11, 4)),
            new Event(502, "Globomatics Developer Day",
                    new Organizer(101, "Globomatics", "Globomatics Technology Corporations"),
                    new Venue(201, "Globomatics Main Office", "Test Street 222", "New York", "USA"),
                    LocalDate.of(2024, 11, 10), LocalDate.of(2024, 11, 10)),
            new Event(503, "Carved Rock New Products Day",
                    new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
                    new Venue(202, "Sea View Hotel","Beach Boulevard 222", "Los Angels", "USA"),
                    LocalDate.of(2024, 11, 20), LocalDate.of(2024, 11, 24)));

    public List<Event> findByOrganizationId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }
}
