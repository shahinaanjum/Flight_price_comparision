
import { useNavigate } from "react-router-dom";
import "../App.css";

function MyBookings() {
    const navigate = useNavigate();

    const bookings = JSON.parse(
        localStorage.getItem("bookings") || "[]"
    );

    return (
        <div className="confirmation-page">
            <div className="confirmation-card">
                <h1>My Bookings ✈️</h1>

                {bookings.length === 0 ? (
                    <>
                        <p>No bookings found yet.</p>
                        <button
                            className="confirmation-button"
                            onClick={() => navigate("/dashboard")}
                        >
                            Search Flights
                        </button>
                    </>
                ) : (
                    bookings.map((booking, index) => (
                        <div key={index} className="booking-reference">
                            <h2>{booking.airline}</h2>

                            <p>
                                <strong>Route:</strong>{" "}
                                {booking.from} → {booking.to}
                            </p>

                            <p>
                                <strong>Departure:</strong>{" "}
                                {booking.departureDate || booking.departure}
                            </p>

                            <p>
                                <strong>Passenger:</strong>{" "}
                                {booking.passengerName}
                            </p>

                            <p>
                                <strong>Price:</strong> ₹{booking.price}
                            </p>

                            <hr />
                        </div>
                    ))
                )}

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

export default MyBookings;
