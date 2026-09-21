package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.flight_prices;
import com.Flight_Price_Comparision.Repository.flight_pricesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class flight_pricesService {
    private final flight_pricesRepository flight_pricesRepository;
    public flight_pricesService(flight_pricesRepository flight_pricesRepository) {
        this.flight_pricesRepository = flight_pricesRepository;
    }
    public flight_prices createFlightPrice(flight_prices flightPrice) {
        return flight_pricesRepository.save(flightPrice);
    }
    public List<flight_prices> getAllFlightPrices() {
        return flight_pricesRepository.findAll();
    }
    public Optional<flight_prices> getFlightPriceById(Long id) {
        return flight_pricesRepository.findById(id);
    }
    public List<flight_prices> getPricesByFlightId(Long flightId) {
        return flight_pricesRepository.findByFlightId(flightId);
    }
    public List<flight_prices> getPricesByCabinClass(String cabinClass) {
        return flight_pricesRepository.findByCabinClass(cabinClass);
    }
    public void deleteFlightPrice(Long id) {
        flight_pricesRepository.deleteById(id);
    }
}
