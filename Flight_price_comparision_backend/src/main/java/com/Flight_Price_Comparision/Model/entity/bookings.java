package com.Flight_Price_Comparision.Model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private users user;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private flights flight;

    @ManyToOne
    @JoinColumn(name = "price_id", nullable = false)
    private flight_prices price;

    @Column(name = "booking_references", nullable = false, unique = true)
    private String bookingReferences;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus = "pending";

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private String currency = "inr";

    @Column(name = "booked_at", nullable = false)
    private LocalDateTime bookedAt;


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public flights getFlight() {
        return flight;
    }

    public void setFlight(flights flight) {
        this.flight = flight;
    }

    public flight_prices getPrice() {
        return price;
    }

    public void setPrice(flight_prices price) {
        this.price = price;
    }

    public String getBookingReferences() {
        return bookingReferences;
    }

    public void setBookingReferences(String bookingReferences) {
        this.bookingReferences = bookingReferences;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }
}