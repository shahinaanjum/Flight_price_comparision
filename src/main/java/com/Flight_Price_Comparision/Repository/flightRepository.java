package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface flightRepository extends JpaRepository<flights, Long> {

    Optional<flights> findByFlightNumber(String flightNumber);

    List<flights> findByAirlineId(Long airlineId);

    List<flights> findByDepartureAirportIdAndArrivalAirportId(
            Long departureAirportId,
            Long arrivalAirportId
    );

    List<flights> findByStatus(String status);

}