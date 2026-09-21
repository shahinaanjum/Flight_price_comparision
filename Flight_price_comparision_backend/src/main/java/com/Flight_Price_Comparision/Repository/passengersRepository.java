package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.passengers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface passengersRepository extends JpaRepository<passengers, Long> {

    // Find all passengers of a particular booking
    List<passengers> findByBookingId(Long bookingId);

    // Search passenger using passport number
    Optional<passengers> findByPassportNumber(String passportNumber);

}
