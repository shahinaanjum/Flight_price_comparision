package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.aircrafts;
import com.Flight_Price_Comparision.Repository.aircraftsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class aircraftsService {
    private final aircraftsRepository aircraftsRepository;
    public aircraftsService(aircraftsRepository aircraftsRepository) {
        this.aircraftsRepository = aircraftsRepository;
    }
    public aircrafts createAircraft(aircrafts aircraft) {
        return aircraftsRepository.save(aircraft);
    }
    public List<aircrafts> getAllAircrafts() {
        return aircraftsRepository.findAll();
    }
    public Optional<aircrafts> getAircraftById(Long id) {
        return aircraftsRepository.findById(id);
    }
    public Optional<aircrafts> getAircraftByRegistrationNumber(String registrationNumber) {
        return aircraftsRepository.findByRegistrationNumber(registrationNumber);
    }
    public void deleteAircraft(Long id) {
        aircraftsRepository.deleteById(id);
    }
}
