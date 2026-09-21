package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.airlines;
import com.Flight_Price_Comparision.Service.airlinesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/airlines")
public class airlinesController {
    private final airlinesServices airlinesServices;
    public airlinesController(airlinesServices airlinesServices) {
        this.airlinesServices = airlinesServices;
    }
    @PostMapping
    public airlines createAirline(@RequestBody airlines airline) {
        return airlinesServices.createAirline(airline);
    }
    @GetMapping
    public List<airlines> getAllAirlines() {
        return airlinesServices.getAllAirlines();
    }
    @GetMapping("/{id}")
    public ResponseEntity<airlines> getAirlineById(@PathVariable Long id) {
        return airlinesServices.getAirlineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<airlines> getAirlineByCode(@PathVariable String code) {
        return airlinesServices.getAirlineByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        airlinesServices.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }
}