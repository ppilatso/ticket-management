package com.plurasight.springboot.tickets.events;

public record Event(
        int id,
        String name,
        Organizer organizer,
        Venue venue,
        LocalDate startDate,
        LocalDate endDate) {
}
