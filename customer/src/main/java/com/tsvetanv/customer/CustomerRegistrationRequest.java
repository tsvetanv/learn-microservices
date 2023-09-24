package com.tsvetanv.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email) {
}
