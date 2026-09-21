package com.Flight_Price_Comparision.Controller;
import com.Flight_Price_Comparision.Model.entity.payments;
import com.Flight_Price_Comparision.Service.paymentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/payments")
public class paymentsController {
    private final paymentsService paymentsService;
    public paymentsController(paymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }
    @PostMapping
    public payments createPayment(@RequestBody payments payment) {
        return paymentsService.createPayment(payment);
    }
    @GetMapping
    public List<payments> getAllPayments() {
        return paymentsService.getAllPayments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<payments> getPaymentById(@PathVariable Long id) {
        return paymentsService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/booking/{bookingId}")
    public List<payments> getPaymentsByBookingId(
            @PathVariable Long bookingId) {
        return paymentsService.getPaymentsByBookingId(bookingId);
    }
    @GetMapping("/status/{status}")
    public List<payments> getPaymentsByStatus(
            @PathVariable String status) {
        return paymentsService.getPaymentsByStatus(status);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentsService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}