import { useLocation, useNavigate } from "react-router-dom";
import { useState } from "react";
import "../App.css";

function Booking() {
    const location = useLocation();
    const navigate = useNavigate();

    const flight = location.state || {};

    const [passenger, setPassenger] = useState({
        fullName: "",
        email: "",
        phone: "",
        dateOfBirth: "",
        nationality: ""
    });

    const handleChange = (e) => {
        setPassenger({
            ...passenger,
            [e.target.name]: e.target.value
        });
    };


    const handleSubmit = (e) => {
    e.preventDefault();

    navigate("/booking-confirmation", {
        state: {
            flight,
            passenger
        }
    });
};

    return (
        <div className="booking-page">
            <div className="booking-container">

                <button
                    className="back-button"
                    onClick={() => navigate("/flight-results")}
                >
                    ← Back to Flights
                </button>

                <h1>Complete Your Booking ✈️</h1>

                <div className="booking-flight">
                    <h2>{flight.airline || "Selected Airline"}</h2>

                    <p>
                        {flight.from || "Departure"} → {flight.to || "Destination"}
                    </p>

                    <h2>₹{flight.price || 0}</h2>
                </div>

                <h2>Passenger Details</h2>

                <form onSubmit={handleSubmit} className="booking-form">

                    <label>Full Name</label>
                    <input
                        type="text"
                        name="fullName"
                        placeholder="Enter full name"
                        value={passenger.fullName}
                        onChange={handleChange}
                        required
                    />

                    <label>Email Address</label>
                    <input
                        type="email"
                        name="email"
                        placeholder="Enter email address"
                        value={passenger.email}
                        onChange={handleChange}
                        required
                    />

                    <label>Phone Number</label>
                    <input
                        type="tel"
                        name="phone"
                        placeholder="Enter phone number"
                        pattern="[0-9]{10}"
                        title="Enter a 10-digit phone number"
                        value={passenger.phone}
                        onChange={handleChange}
                        required
                    />

                    <label>Date of Birth</label>
                    <input
                        type="date"
                        name="dateOfBirth"
                        value={passenger.dateOfBirth}
                        onChange={handleChange}
                        required
                    />

                    <label>Nationality</label>
                    <input
                        type="text"
                        name="nationality"
                        placeholder="Enter nationality"
                        value={passenger.nationality}
                        onChange={handleChange}
                        required
                    />

                    <button type="submit" className="booking-submit">
                        Continue Booking
                    </button>

                </form>
            </div>
        </div>
    );
}

export default Booking;