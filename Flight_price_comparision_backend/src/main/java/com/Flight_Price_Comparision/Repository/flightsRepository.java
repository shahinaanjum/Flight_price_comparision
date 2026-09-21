package com.Flight_Price_Comparision.Repository;
import com.Flight_Price_Comparision.Model.entity.flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface flightsRepository extends JpaRepository<flights, Long> {
    Optional<flights> findByFlightNumber(String flightNumber);
    List<flights> findByStatus(String status);
}