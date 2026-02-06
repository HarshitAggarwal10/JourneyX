import { useEffect, useState, useContext } from "react";
import api from "../api/api";
import { AuthContext } from "../auth/AuthContext";

export default function Profile() {
  const [user, setUser] = useState(null);
  const { logout } = useContext(AuthContext);

  useEffect(() => {
    api.get("/api/user/profile")
      .then(res => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>User Profile</h2>
      {user && (
        <>
          <p>Username: {user.username}</p>
          <p>Email: {user.email}</p>
          <p>Role: {user.role}</p>
        </>
      )}
      <button onClick={logout}>Logout</button>
    </div>
  );
}
