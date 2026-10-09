package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.airlines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface airlinesRepository extends JpaRepository<airlines, Long> {

}