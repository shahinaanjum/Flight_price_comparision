package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.bookings;
import com.Flight_Price_Comparision.Repository.bookingsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class bookingsService {
    private final bookingsRepository bookingsRepository;

    public bookingsService(bookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }
    public bookings createBooking(bookings booking) {
        return bookingsRepository.save(booking);
    }
    public List<bookings> getAllBookings() {
        return bookingsRepository.findAll();
    }
    public Optional<bookings> getBookingById(Long id) {
        return bookingsRepository.findById(id);
    }
    public Optional<bookings> getBookingByReference(String bookingReference) {
        return bookingsRepository.findByBookingReferences(bookingReference);
    }
    public List<bookings> getBookingsByUserId(Long userId) {
        return bookingsRepository.findByUserId(userId);
    }
    public List<bookings> getBookingsByStatus(String bookingStatus) {
        return bookingsRepository.findByBookingStatus(bookingStatus);
    }
    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }
}
