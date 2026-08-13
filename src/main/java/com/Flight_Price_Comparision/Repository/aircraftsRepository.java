package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.aircrafts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface aircraftsRepository extends JpaRepository<aircrafts, Long> {

    Optional<aircrafts> findByRegistrationNumber(String registrationNumber);

    List<aircrafts> findByAirlineId(Long airlineId);

}