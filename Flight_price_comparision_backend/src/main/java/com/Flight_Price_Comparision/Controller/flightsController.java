package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.flights;
import com.Flight_Price_Comparision.Service.flightsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/flights")
public class flightsController {
    private final flightsService flightsService;
    public flightsController(flightsService flightsService) {
        this.flightsService = flightsService;
    }
    @PostMapping
    public flights createFlight(@RequestBody flights flight) {
        return flightsService.createFlight(flight);
    }
    @GetMapping
    public List<flights> getAllFlights() {
        return flightsService.getAllFlights();
    }
    @GetMapping("/{id}")
    public ResponseEntity<flights> getFlightById(@PathVariable Long id) {
        return flightsService.getFlightById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/status/{status}")
    public List<flights> getFlightsByStatus(
            @PathVariable String status) {

        return flightsService.getFlightsByStatus(status);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightsService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}