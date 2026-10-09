import { useLocation, useNavigate } from "react-router-dom";
import "../App.css";
function FlightResults() {
    const location = useLocation();
    const navigate = useNavigate();
    const search = location.state || {};
    const flights = [
        {
            airline: "Air India",
            departure: "06:00 AM",
            arrival: "08:45 AM",
            duration: "2h 45m",
            price: 4500
        },
        {
            airline: "IndiGo",
            departure: "10:30 AM",
            arrival: "01:15 PM",
            duration: "2h 45m",
            price: 3800
        },
        {
            airline: "Akasa Air",
            departure: "04:00 PM",
            arrival: "06:50 PM",
            duration: "2h 50m",
            price: 4200
        }
    ];
    return (
        <div className="flight-results">
            <button onClick={() => navigate("/dashboard")}>
                ← Back to Dashboard
            </button>

            <h1>Available Flights ✈️</h1>

            <h3>
                {search.from} → {search.to}

            </h3>
            <p>Departure Date: {search.departureDate}</p>

            {flights.map((flight, index) => (
                <div className="flight-card" key={index}>
                    <h2>{flight.airline}</h2>

                    <div className="flight-details">
                        <div>
                            <h3>{flight.departure}</h3>
                            <p>{search.from}</p>
                        </div>

                        <div>
                            <p>{flight.duration}</p>
                            <span>✈ ────── ✈</span>
                        </div>

                        <div>
                            <h3>{flight.arrival}</h3>
                            <p>{search.to}</p>
                        </div>

                        <div>
                            <h2>₹{flight.price}</h2>
                            <button
                            onClick={() =>
                            navigate("/booking", {
                            state: {
                            airline: flight.airline,
                            from: search.from,
                            to: search.to,
                            price: flight.price,
                            departure: flight.departure,
                            arrival: flight.arrival,
                            duration: flight.duration,
                            departureDate: search.departureDate
            }
        })
    }
>
    Select Flight
</button>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}
export default FlightResults;