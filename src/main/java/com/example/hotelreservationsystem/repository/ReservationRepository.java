
package com.example.hotelreservationsystem.repository;

import com.example.hotelreservationsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {

    @Query("""
        SELECT COUNT(r) > 0
        FROM Reservation r
        WHERE r.room.roomId = :roomId
        AND r.status <> 'CANCELLED'
        AND r.checkInDate < :checkOut
        AND r.checkOutDate > :checkIn
        AND (:reservationId IS NULL OR r.reservationId <> :reservationId)
    """)
    boolean isRoomBooked(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut,
            @Param("reservationId") Long reservationId
    );
}