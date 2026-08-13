package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.airports;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface airportsRepository extends JpaRepository<airports, Long> {

    Optional<airports> findByIataCode(String iataCode);

}