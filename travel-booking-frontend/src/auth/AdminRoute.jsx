import { Navigate } from "react-router-dom";
import jwtDecode from "jwt-decode";

const AdminRoute = ({ children }) => {
  const token = localStorage.getItem("token");
  if (!token) return <Navigate to="/login" />;

  const decoded = jwtDecode(token);
  return decoded.role === "ROLE_ADMIN"
    ? children
    : <Navigate to="/profile" />;
};

export default AdminRoute;
