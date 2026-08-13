package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.payments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface paymentsRepository extends JpaRepository<payments, Long> {

    // Search payment using transaction ID
    Optional<payments> findByTransactionId(String transactionId);

    // Find payments for a particular booking
    List<payments> findByBookingId(Long bookingId);

    // Find payments by payment status
    List<payments> findByPaymentStatus(String paymentStatus);

}
