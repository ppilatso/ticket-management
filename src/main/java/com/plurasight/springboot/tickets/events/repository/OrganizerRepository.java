package com.plurasight.springboot.tickets.events.repository;

import com.plurasight.springboot.tickets.events.Organizer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}
