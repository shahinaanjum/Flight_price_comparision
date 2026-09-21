package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.search_history;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface search_historyRepository extends JpaRepository<search_history, Long> {

    List<search_history> findByUserId(Long userId);

    List<search_history> findByDepartureAirportIdAndArrivalAirportId(
            Long departureAirportId,
            Long arrivalAirportId
    );

    List<search_history> findByCabinClass(String cabinClass);

}
