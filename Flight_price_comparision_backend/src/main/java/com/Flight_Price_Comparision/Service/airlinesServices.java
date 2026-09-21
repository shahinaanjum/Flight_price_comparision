package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.airlines;
import com.Flight_Price_Comparision.Repository.airlinesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class airlinesServices {
    private final airlinesRepository airlinesRepository;
    public airlinesServices(airlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }
    public airlines createAirline(airlines airline) {
        return airlinesRepository.save(airline);
    }
    public List<airlines> getAllAirlines() {
        return airlinesRepository.findAll();
    }
    public Optional<airlines> getAirlineById(Long id) {
        return airlinesRepository.findById(id);
    }
    public Optional<airlines> getAirlineByCode(String airlinesCode) {
        return airlinesRepository.findByAirlinesCode(airlinesCode);
    }
    public void deleteAirline(Long id) {
        airlinesRepository.deleteById(id);
    }
}