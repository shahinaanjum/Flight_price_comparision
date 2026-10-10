
import { useLocation, useNavigate } from "react-router-dom";
import { useState } from "react";
import "../App.css";

function BookingConfirmation() {
    const location = useLocation();
    const navigate = useNavigate();

    const booking = location.state || {};
    const flight = booking.flight || {};
    const passenger = booking.passenger || {};

    const [savedBooking] = useState(() => {
        const newBooking = {
            bookingReference:
                "FL" + Math.random().toString(36).substring(2, 8).toUpperCase(),
            airline: flight.airline || "Not available",
            from: flight.from || "",
            to: flight.to || "",
            departureDate: flight.departureDate || "",
            departure: flight.departure || "",
            passengerName: passenger.fullName || "",
            price: flight.price ?? 0,
        };

        if (location.state) {
            const existingBookings = JSON.parse(
                localStorage.getItem("bookings") || "[]"
            );

            existingBookings.push(newBooking);

            localStorage.setItem(
                "bookings",
                JSON.stringify(existingBookings)
            );
        }

        return newBooking;
    });

    return (
        <div className="confirmation-page">
            <div className="confirmation-card">
                <div className="success-icon">✓</div>

                <h1>Booking Confirmed!</h1>

                <p className="confirmation-message">
                    Your booking details are ready.
                </p>

                <div className="booking-reference">
                    <p>Booking Reference</p>
                    <h2>{savedBooking.bookingReference}</h2>
                </div>

                <div className="confirmation-details">
                    <h2>Flight Details ✈️</h2>

                    <p>
                        <strong>Airline:</strong>{" "}
                        {savedBooking.airline}
                    </p>

                    <p>
                        <strong>Route:</strong>{" "}
                        {savedBooking.from || "Not available"} →{" "}
                        {savedBooking.to || "Not available"}
                    </p>

                    <p>
                        <strong>Departure:</strong>{" "}
                        {savedBooking.departureDate ||
                            savedBooking.departure ||
                            "Not available"}
                    </p>

                    <p>
                        <strong>Passenger:</strong>{" "}
                        {savedBooking.passengerName || "Not available"}
                    </p>

                    <p>
                        <strong>Total Price:</strong>{" "}
                        ₹{savedBooking.price}
                    </p>
                </div>

                <button
                    className="confirmation-button"
                    onClick={() => navigate("/dashboard")}
                >
                    Back to Dashboard
                </button>
            </div>
        </div>
    );
}

export default BookingConfirmation;
