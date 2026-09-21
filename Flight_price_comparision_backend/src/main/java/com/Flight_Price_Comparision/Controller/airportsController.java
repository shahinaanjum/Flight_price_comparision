package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.airports;
import com.Flight_Price_Comparision.Service.airportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/airports")
public class airportsController {
    private final airportsService airportsService;
    public airportsController(airportsService airportsService) {
        this.airportsService = airportsService;
    }
    @PostMapping
    public airports createAirport(@RequestBody airports airport) {
        return airportsService.createAirport(airport);
    }
    @GetMapping
    public List<airports> getAllAirports() {
        return airportsService.getAllAirports();
    }
    @GetMapping("/{id}")
    public ResponseEntity<airports> getAirportById(@PathVariable Long id) {
        return airportsService.getAirportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<airports> getAirportByCode(@PathVariable String code) {
        return airportsService.getAirportByIataCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportsService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}