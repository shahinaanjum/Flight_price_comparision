import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Dashboard() {

    const navigate = useNavigate();

    const [from, setFrom] = useState("");
    const [to, setTo] = useState("");
    const [departureDate, setDepartureDate] = useState("");
    const [returnDate, setReturnDate] = useState("");
    const [passengers, setPassengers] = useState(1);
    const [cabinClass, setCabinClass] = useState("Economy");

    const handleSearch = (e) => {
        e.preventDefault();

        console.log({
            from,
            to,
            departureDate,
            returnDate,
            passengers,
            cabinClass
        });

        alert("Flight search started!");
    };

    const handleLogout = () => {

        localStorage.removeItem("token");

        navigate("/signin");
    };

    return (
        <div className="dashboard">

            {/* Navbar */}
            <nav className="navbar">

                <div
                    className="logo"
                    onClick={() => navigate("/dashboard")}
                >
                    ✈️ FlightFinder
                </div>

                <div className="nav-links">
                    <button onClick={() => navigate("/dashboard")}>
                        Home
                    </button>

                    <button>
                        My Bookings
                    </button>

                    <button>
                        Profile
                    </button>

                    <button
                        className="logout-btn"
                        onClick={handleLogout}
                    >
                        Logout
                    </button>
                </div>

            </nav>


            {/* Hero Section */}
            <section className="hero">

                <div className="hero-content">

                    <h1>
                        Find Your Perfect Flight
                    </h1>

                    <p>
                        Compare flight prices from multiple airlines
                        and find the best option for your journey.
                    </p>

                </div>


                {/* Search Card */}
                <div className="search-card">

                    <h2>Search Flights</h2>

                    <form onSubmit={handleSearch}>

                        <div className="search-row">

                            {/* From */}
                            <div className="input-group">

                                <label>From</label>

                                <input
                                    type="text"
                                    placeholder="Departure city"
                                    value={from}
                                    onChange={(e) =>
                                        setFrom(e.target.value)
                                    }
                                    required
                                />

                            </div>


                            {/* To */}
                            <div className="input-group">

                                <label>To</label>

                                <input
                                    type="text"
                                    placeholder="Arrival city"
                                    value={to}
                                    onChange={(e) =>
                                        setTo(e.target.value)
                                    }
                                    required
                                />

                            </div>


                            {/* Departure */}
                            <div className="input-group">

                                <label>Departure</label>

                                <input
                                    type="date"
                                    value={departureDate}
                                    onChange={(e) =>
                                        setDepartureDate(e.target.value)
                                    }
                                    required
                                />

                            </div>


                            {/* Return */}
                            <div className="input-group">

                                <label>Return</label>

                                <input
                                    type="date"
                                    value={returnDate}
                                    onChange={(e) =>
                                        setReturnDate(e.target.value)
                                    }
                                />

                            </div>

                        </div>


                        <div className="search-row">

                            {/* Passengers */}
                            <div className="input-group">

                                <label>Passengers</label>

                                <input
                                    type="number"
                                    min="1"
                                    max="20"
                                    value={passengers}
                                    onChange={(e) =>
                                        setPassengers(e.target.value)
                                    }
                                />

                            </div>


                            {/* Cabin Class */}
                            <div className="input-group">

                                <label>Class</label>

                                <select
                                    value={cabinClass}
                                    onChange={(e) =>
                                        setCabinClass(e.target.value)
                                    }
                                >

                                    <option>Economy</option>
                                    <option>Premium Economy</option>
                                    <option>Business</option>
                                    <option>First Class</option>

                                </select>

                            </div>


                            <div className="search-button-container">

                                <button
                                    type="submit"
                                    className="search-btn"
                                >
                                    🔍 Search Flights
                                </button>

                            </div>

                        </div>

                    </form>

                </div>

            </section>


            {/* Features */}
            <section className="features">

                <h2>Why Choose FlightFinder?</h2>

                <div className="feature-grid">

                    <div className="feature-card">

                        <div className="feature-icon">
                            💰
                        </div>

                        <h3>Compare Prices</h3>

                        <p>
                            Compare prices from multiple sources
                            and find suitable flight options.
                        </p>

                    </div>


                    <div className="feature-card">

                        <div className="feature-icon">
                            ⚡
                        </div>

                        <h3>Fast Search</h3>

                        <p>
                            Search flights quickly using our
                            optimized flight search system.
                        </p>

                    </div>


                    <div className="feature-card">

                        <div className="feature-icon">
                            🔒
                        </div>

                        <h3>Secure Booking</h3>

                        <p>
                            Your account and booking information
                            are protected with secure authentication.
                        </p>

                    </div>

                </div>

            </section>


            {/* Popular Destinations */}
            <section className="destinations">

                <h2>Popular Destinations</h2>

                <div className="destination-grid">

                    <div className="destination-card">
                        <span>🇮🇳</span>
                        <h3>Chennai</h3>
                        <p>India</p>
                    </div>

                    <div className="destination-card">
                        <span>🇮🇳</span>
                        <h3>Mumbai</h3>
                        <p>India</p>
                    </div>

                    <div className="destination-card">
                        <span>🇮🇳</span>
                        <h3>Delhi</h3>
                        <p>India</p>
                    </div>

                    <div className="destination-card">
                        <span>🇦🇪</span>
                        <h3>Dubai</h3>
                        <p>United Arab Emirates</p>
                    </div>

                </div>

            </section>


            {/* Footer */}
            <footer>

                <p>
                    © 2026 FlightFinder. Flight Price Comparison & Booking Platform.
                </p>

            </footer>

        </div>
    );
}

export default Dashboard;