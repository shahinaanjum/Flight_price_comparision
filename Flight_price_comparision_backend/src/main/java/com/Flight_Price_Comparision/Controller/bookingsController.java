package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.bookings;
import com.Flight_Price_Comparision.Service.bookingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/bookings")
public class bookingsController {
    private final bookingsService bookingsService;
    public bookingsController(bookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }
    @PostMapping
    public bookings createBooking(@RequestBody bookings booking) {
        return bookingsService.createBooking(booking);
    }
    @GetMapping
    public List<bookings> getAllBookings() {
        return bookingsService.getAllBookings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<bookings> getBookingById(@PathVariable Long id) {
        return bookingsService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}")
    public List<bookings> getBookingsByUserId(
            @PathVariable Long userId) {
        return bookingsService.getBookingsByUserId(userId);
    }
    @GetMapping("/status/{status}")
    public List<bookings> getBookingsByStatus(
            @PathVariable String status) {
        return bookingsService.getBookingsByStatus(status);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingsService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}