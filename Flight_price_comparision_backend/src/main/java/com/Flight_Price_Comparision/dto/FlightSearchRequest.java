package com.Flight_Price_Comparision.dto;
import java.time.LocalDate;
public class FlightSearchRequest {
    private Long departureAirportId;
    private Long arrivalAirportId;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int passengers;
    private String cabinClass;
    public FlightSearchRequest() {
    }
    public FlightSearchRequest(Long departureAirportId,
                               Long arrivalAirportId,
                               LocalDate departureDate,
                               LocalDate returnDate,
                               int passengers,
                               String cabinClass) {
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengers = passengers;
        this.cabinClass = cabinClass;
    }
    public Long getDepartureAirportId() {
        return departureAirportId;
    }
    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }
    public Long getArrivalAirportId() {
        return arrivalAirportId;
    }
    public void setArrivalAirportId(Long arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengers() {
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    public String getCabinClass() {
        return cabinClass;
    }
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }
}