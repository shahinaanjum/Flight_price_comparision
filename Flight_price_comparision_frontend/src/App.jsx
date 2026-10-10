import {
    BrowserRouter,
    Routes,
    Route,
    Navigate
} from "react-router-dom";

import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Dashboard from "./pages/Dashboard";
import FlightResults from "./pages/FlightResults";
import Booking from "./pages/Booking";
import BookingConfirmation from "./pages/BookingConfirmation";
import MyBookings from "./pages/MyBookings";

import "./App.css";

function App() {
    return (
        <BrowserRouter>

            <Routes>

                {/* Default page */}
                <Route
                    path="/"
                    element={<Navigate to="/signin" replace />}
                />

                {/* Sign In */}
                <Route
                    path="/signin"
                    element={<SignIn />}
                />

                {/* Sign Up */}
                <Route
                    path="/signup"
                    element={<SignUp />}
                />

                {/* Dashboard */}
                <Route
                    path="/dashboard"
                    element={<Dashboard />}
                />
                <Route
                    path="/flight-results"
                    element={<FlightResults />}
                />
                <Route
                    path="/booking"
                    element={<Booking />}
                />
                <Route
                    path="/booking-confirmation"
                    element={<BookingConfirmation />}
                />
        
                {/* Unknown URL */}
                
                <Route
                path="/my-bookings"
                element={<MyBookings />}
               />

                <Route
                    path="*"
                    element={<Navigate to="/signin" replace />}
                />


            </Routes>

        </BrowserRouter>
    );
}

export default App;