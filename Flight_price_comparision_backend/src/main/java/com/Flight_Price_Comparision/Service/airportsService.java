package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.airports;
import com.Flight_Price_Comparision.Repository.airportsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class airportsService {
    private final airportsRepository airportsRepository;
    public airportsService(airportsRepository airportsRepository) {
        this.airportsRepository = airportsRepository;
    }
    public airports createAirport(airports airport) {
        return airportsRepository.save(airport);
    }
    public List<airports> getAllAirports() {
        return airportsRepository.findAll();
    }
    public Optional<airports> getAirportById(Long id) {
        return airportsRepository.findById(id);
    }
    public Optional<airports> getAirportByIataCode(String iataCode) {
        return airportsRepository.findByIataCode(iataCode);
    }
    public void deleteAirport(Long id) {
        airportsRepository.deleteById(id);
    }
}