package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.flight_prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface flight_pricesRepository extends JpaRepository<flight_prices, Long> {

    // Find all prices for a particular flight
    List<flight_prices> findByFlightId(Long flightId);

    // Find prices from a particular source
    List<flight_prices> findBySource(String source);

    // Find prices by cabin class
    List<flight_prices> findByCabinClass(String cabinClass);

    // Find prices by flight and cabin class
    List<flight_prices> findByFlightIdAndCabinClass(
            Long flightId,
            String cabinClass
    );
}