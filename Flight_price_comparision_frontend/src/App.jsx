import {
    BrowserRouter,
    Routes,
    Route,
    Navigate
} from "react-router-dom";

import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Dashboard from "./pages/Dashboard";

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

                {/* Unknown URL */}
                <Route
                    path="*"
                    element={<Navigate to="/signin" replace />}
                />

            </Routes>

        </BrowserRouter>
    );
}

export default App;