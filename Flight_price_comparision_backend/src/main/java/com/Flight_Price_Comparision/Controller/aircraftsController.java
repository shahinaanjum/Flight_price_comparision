package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.aircrafts;
import com.Flight_Price_Comparision.Service.aircraftsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/aircrafts")
public class aircraftsController {
    private final aircraftsService aircraftsService;
    public aircraftsController(aircraftsService aircraftsService) {
        this.aircraftsService = aircraftsService;
    }
    @PostMapping
    public aircrafts createAircraft(@RequestBody aircrafts aircraft) {
        return aircraftsService.createAircraft(aircraft);
    }
    @GetMapping
    public List<aircrafts> getAllAircrafts() {
        return aircraftsService.getAllAircrafts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<aircrafts> getAircraftById(@PathVariable Long id) {
        return aircraftsService.getAircraftById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/registration/{registrationNumber}")
    public ResponseEntity<aircrafts> getAircraftByRegistration(
            @PathVariable String registrationNumber) {
        return aircraftsService.getAircraftByRegistrationNumber(registrationNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        aircraftsService.deleteAircraft(id);
        return ResponseEntity.noContent().build();
    }
}