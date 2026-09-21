package com.Flight_Price_Comparision.Service;

import com.Flight_Price_Comparision.Model.entity.users;
import com.Flight_Price_Comparision.Repository.usersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usersService {

    private final usersRepository usersRepository;

    public usersService(usersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public users createUser(users user) {
        return usersRepository.save(user);
    }

    public List<users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<users> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    public Optional<users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}