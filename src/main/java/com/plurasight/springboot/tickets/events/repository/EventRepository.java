package com.plurasight.springboot.tickets.events.repository;

import com.plurasight.springboot.tickets.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);
}
