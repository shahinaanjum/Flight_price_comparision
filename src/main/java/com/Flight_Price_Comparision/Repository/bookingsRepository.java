package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface bookingsRepository extends JpaRepository<bookings, Long> {

    Optional<bookings> findByBookingReferences(String bookingReferences);

    List<bookings> findByUserId(Long userId);

    List<bookings> findByFlightId(Long flightId);

    List<bookings> findByBookingStatus(String bookingStatus);

}