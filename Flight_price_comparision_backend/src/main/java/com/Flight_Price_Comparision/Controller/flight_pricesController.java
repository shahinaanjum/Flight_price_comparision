package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.flight_prices;
import com.Flight_Price_Comparision.Service.flight_pricesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/flight-prices")
public class flight_pricesController {
    private final flight_pricesService flight_pricesService;
    public flight_pricesController(flight_pricesService flight_pricesService) {
        this.flight_pricesService = flight_pricesService;
    }
    @PostMapping
    public flight_prices createFlightPrice(@RequestBody flight_prices price) {
        return flight_pricesService.createFlightPrice(price);
    }
    @GetMapping
    public List<flight_prices> getAllFlightPrices() {
        return flight_pricesService.getAllFlightPrices();
    }
    @GetMapping("/{id}")
    public ResponseEntity<flight_prices> getFlightPriceById(@PathVariable Long id) {
        return flight_pricesService.getFlightPriceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/flight/{flightId}")
    public List<flight_prices> getPricesByFlightId(@PathVariable Long flightId) {
        return flight_pricesService.getPricesByFlightId(flightId);
    }
    @GetMapping("/cabin/{cabinClass}")
    public List<flight_prices> getPricesByCabinClass(
            @PathVariable String cabinClass) {
        return flight_pricesService.getPricesByCabinClass(cabinClass);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightPrice(@PathVariable Long id) {
        flight_pricesService.deleteFlightPrice(id);
        return ResponseEntity.noContent().build();
    }
}