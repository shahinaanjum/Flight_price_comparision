package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.passengers;
import com.Flight_Price_Comparision.Service.passengersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/passengers")
public class passengersController {
    private final passengersService passengersService;
    public passengersController(passengersService passengersService) {
        this.passengersService = passengersService;
    }
    @PostMapping
    public passengers createPassenger(@RequestBody passengers passenger) {
        return passengersService.createPassenger(passenger);
    }
    @GetMapping
    public List<passengers> getAllPassengers() {
        return passengersService.getAllPassengers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<passengers> getPassengerById(
            @PathVariable Long id) {
        return passengersService.getPassengerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/booking/{bookingId}")
    public List<passengers> getPassengersByBookingId(
            @PathVariable Long bookingId) {

        return passengersService.getPassengersByBookingId(bookingId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(
            @PathVariable Long id) {
        passengersService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}