import { useState } from "react";
import api from "../api/api";

export default function Flights() {
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [flights, setFlights] = useState([]);

  const searchFlights = async () => {
    const res = await api.get(
      `/api/flights/search?source=${source}&destination=${destination}`
    );
    setFlights(res.data);
  };

  return (
    <div>
      <h2>Search Flights</h2>

      <input placeholder="Source" onChange={e => setSource(e.target.value)} />
      <input placeholder="Destination" onChange={e => setDestination(e.target.value)} />
      <button onClick={searchFlights}>Search</button>

      <ul>
        {flights.map(f => (
          <li key={f.id}>
            {f.source} → {f.destination} | ₹{f.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
