package com.plurasight.springboot.tickets.events.repository;

import com.plurasight.springboot.tickets.events.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
}
