package com.Flight_Price_Comparision.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthController {
    @GetMapping("/health")
    public String health() {
        return "Flight Booking API is running successfully!";
    }
}