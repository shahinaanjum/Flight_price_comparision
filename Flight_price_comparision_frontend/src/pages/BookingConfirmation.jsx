import { useLocation, useNavigate } from "react-router-dom";
import "../App.css";

function BookingConfirmation() {
    const location = useLocation();
    const navigate = useNavigate();

    const booking = location.state || {};

    const bookingReference =
        "FL" + Math.random().toString(36).substring(2, 8).toUpperCase();

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
                    <h2>{bookingReference}</h2>
                </div>

                <div className="confirmation-details">
                    <h2>Flight Details ✈️</h2>

                    <p>
                        <strong>Airline:</strong>{" "}
                        {booking.airline || "Not available"}
                    </p>

                    <p>
                        <strong>Route:</strong>{" "}
                        {booking.from || "Not available"} →{" "}
                        {booking.to || "Not available"}
                    </p>

                    <p>
                        <strong>Departure:</strong>{" "}
                        {booking.departureDate || "Not available"}
                    </p>

                    <p>
                        <strong>Passenger:</strong>{" "}
                        {booking.passengerName || "Not available"}
                    </p>

                    <p>
                        <strong>Total Price:</strong>{" "}
                        ₹{booking.price || 0}
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