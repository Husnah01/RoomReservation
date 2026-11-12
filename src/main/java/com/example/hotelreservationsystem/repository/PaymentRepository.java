package com.example.hotelreservationsystem.repository;

import com.example.hotelreservationsystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
