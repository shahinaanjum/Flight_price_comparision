import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function SignUp() {

    const [userName, setUserName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [roll, setRoll] = useState("USER");

    const [message, setMessage] = useState("");

    const navigate = useNavigate();

    const handleRegister = async (e) => {

        e.preventDefault();

        try {

            const response = await fetch(
                "http://localhost:8080/api/auth/register",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        userName: userName,
                        email: email,
                        password: password,
                        roll: roll
                    })
                }
            );

            if (response.ok) {

                setMessage("Account created successfully!");

                setTimeout(() => {
                    navigate("/signin");
                }, 1000);

            } else {

                const data = await response.text();
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

                <h2>Create Account</h2>

                <p className="subtitle">
                    Create your account and start comparing flights
                </p>

                <form onSubmit={handleRegister}>

                    <label>Full Name</label>

                    <input
                        type="text"
                        placeholder="Enter your name"
                        value={userName}
                        onChange={(e) => setUserName(e.target.value)}
                        required
                    />

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
                        placeholder="Create a password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />

                    <input
                        type="hidden"
                        value={roll}
                    />

                    <button type="submit">
                        Create Account
                    </button>

                </form>

                {message && (
                    <p className="message">
                        {message}
                    </p>
                )}

                <p className="switch-page">
                    Already have an account?{" "}
                    <Link to="/signin">
                        Sign In
                    </Link>
                </p>

            </div>

        </div>
    );
}

export default SignUp;