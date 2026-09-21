package com.Flight_Price_Comparision.Model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_prices")
public class flight_prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private flights flight;

    @Column(nullable = false)
    private String source;

    @Column(name = "faren_type", nullable = false)
    private String farenType;

    @Column(name = "cabin_class", nullable = false)
    private String cabinClass;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String currency;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    @Column(name = "baggage_allowance")
    private String baggageAllowance;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public flights getFlight() {
        return flight;
    }

    public void setFlight(flights flight) {
        this.flight = flight;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFarenType() {
        return farenType;
    }

    public void setFarenType(String farenType) {
        this.farenType = farenType;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getBaggageAllowance() {
        return baggageAllowance;
    }

    public void setBaggageAllowance(String baggageAllowance) {
        this.baggageAllowance = baggageAllowance;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
