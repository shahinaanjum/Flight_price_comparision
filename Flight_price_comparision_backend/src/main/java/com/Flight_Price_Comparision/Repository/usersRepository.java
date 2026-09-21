package com.Flight_Price_Comparision.Repository;

import com.Flight_Price_Comparision.Model.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usersRepository extends JpaRepository<users, Long> {

    Optional<users> findByEmail(String email);

}