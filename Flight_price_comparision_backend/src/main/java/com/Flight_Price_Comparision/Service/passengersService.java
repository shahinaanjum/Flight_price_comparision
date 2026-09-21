package com.Flight_Price_Comparision.Service;
import com.Flight_Price_Comparision.Model.entity.passengers;
import com.Flight_Price_Comparision.Repository.passengersRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class passengersService {
    private final passengersRepository passengersRepository;
    public passengersService(passengersRepository passengersRepository) {
        this.passengersRepository = passengersRepository;
    }
    public passengers createPassenger(passengers passenger) {
        return passengersRepository.save(passenger);
    }
    public List<passengers> getAllPassengers() {
        return passengersRepository.findAll();
    }
    public Optional<passengers> getPassengerById(Long id) {
        return passengersRepository.findById(id);
    }

    public List<passengers> getPassengersByBookingId(Long bookingId) {
        return passengersRepository.findByBookingId(bookingId);
    }
    public Optional<passengers> getPassengerByPassportNumber(String passportNumber) {
        return passengersRepository.findByPassportNumber(passportNumber);
    }
    public void deletePassenger(Long id) {
        passengersRepository.deleteById(id);
    }
}
