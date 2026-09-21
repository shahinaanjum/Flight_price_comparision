package com.Flight_Price_Comparision.Repository;
import com.Flight_Price_Comparision.Model.entity.airlines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface airlinesRepository extends JpaRepository<airlines, Long> {
    Optional<airlines> findByAirlinesCode(String airlinesCode);
}