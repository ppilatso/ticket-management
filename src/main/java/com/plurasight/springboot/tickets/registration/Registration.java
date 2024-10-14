package com.plurasight.springboot.tickets.registration;

public record Registration(
        Integer id,
        Integer productId,
        String ticketCode,
        String attendeeName) {
}
