package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.payments;
import com.Flight_Price_Comparision.Repository.paymentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class paymentsService {
    private final paymentsRepository paymentsRepository;
    public paymentsService(paymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }
    public payments createPayment(payments payment) {
        return paymentsRepository.save(payment);
    }
    public List<payments> getAllPayments() {
        return paymentsRepository.findAll();
    }
    public Optional<payments> getPaymentById(Long id) {
        return paymentsRepository.findById(id);
    }
    public Optional<payments> getPaymentByTransactionId(String transactionId) {
        return paymentsRepository.findByTransactionId(transactionId);
    }
    public List<payments> getPaymentsByBookingId(Long bookingId) {
        return paymentsRepository.findByBookingId(bookingId);
    }
    public List<payments> getPaymentsByStatus(String paymentStatus) {
        return paymentsRepository.findByPaymentStatus(paymentStatus);
    }
    public void deletePayment(Long id) {
        paymentsRepository.deleteById(id);
    }
}
