package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.flights;
import com.Flight_Price_Comparision.Repository.flightsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class flightsService {
    private final flightsRepository flightsRepository;
    public flightsService(flightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }
    public flights createFlight(flights flight) {
        return flightsRepository.save(flight);
    }
    public List<flights> getAllFlights() {
        return flightsRepository.findAll();
    }
    public Optional<flights> getFlightById(Long id) {
        return flightsRepository.findById(id);
    }
    public Optional<flights> getFlightByFlightNumber(String flightNumber) {
        return flightsRepository.findByFlightNumber(flightNumber);
    }
    public List<flights> getFlightsByStatus(String status) {
        return flightsRepository.findByStatus(status);
    }
    public void deleteFlight(Long id) {
        flightsRepository.deleteById(id);
    }
}