import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function SignIn() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message, setMessage] = useState("");

    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch(
                "http://localhost:8080/api/auth/login",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        email: email,
                        password: password
                    })
                }
            );

            const data = await response.text();

            if (response.ok) {

                // JWT token save
                localStorage.setItem("token", data);

                setMessage("Login successful!");

                // Later we can navigate to home page
                setTimeout(() => {
                navigate("/dashboard");
                },500);

            } else {
                setMessage(data);
            }

        } catch (error) {
            setMessage("Unable to connect to server.");
        }
    };

    return (
        <div className="auth-container">

            <div className="auth-card">

                <h1>✈️ FlightFinder</h1>

                <h2>Welcome Back</h2>

                <p className="subtitle">
                    Sign in to continue your flight journey
                </p>

                <form onSubmit={handleLogin}>

                    <label>Email</label>

                    <input
                        type="email"
                        placeholder="Enter your email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />

                    <label>Password</label>

                    <input
                        type="password"
                        placeholder="Enter your password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />

                    <button type="submit">
                        Sign In
                    </button>

                </form>

                {message && (
                    <p className="message">
                        {message}
                    </p>
                )}

                <p className="switch-page">
                    Don't have an account?{" "}
                    <Link to="/signup">
                        Sign Up
                    </Link>
                </p>

            </div>

        </div>
    );
}

export default SignIn;