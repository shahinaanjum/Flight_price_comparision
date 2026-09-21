package com.Flight_Price_Comparision.dto;
public class BookingRequest{
    private Long userId;
    private Long flightId;
    private Long priceId;
    private int passengers;
    public BookingRequest() {
    }
    public BookingRequest(Long userId, Long flightId, Long priceId, int passengers) {
        this.userId = userId;
        this.flightId = flightId;
        this.priceId = priceId;
        this.passengers = passengers;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    public Long getPriceId() {
        return priceId;
    }
    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
    public int getPassengers() {
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}