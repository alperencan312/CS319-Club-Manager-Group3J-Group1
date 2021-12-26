import Navbar from "./components/Navbar";
import Login from "./Pages/Login";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Dashboard from "./Pages/Dashboard";
import { useSelector, useDispatch } from "react-redux";
import { useState, useEffect } from "react";
import { setUniversitiesData } from ".//store/universitiesSlice";
import axios from 'axios';

function App() {
  const dispatch = useDispatch();
  const [openCalendarModal, setopenCalendarModal] = useState(false);

  const { loggedIn } = useSelector((state) => state.user);

  const fetchUniversitiesData = () => {
    axios.get("http://studentclubmanager2-env.eba-ixmx2avt.us-east-2.elasticbeanstalk.com/schools").then(res=>{console.log(res.data); dispatch(setUniversitiesData(res.data))});
  }

  
  useEffect(() => {
    fetchUniversitiesData();
    
  }, []);
  

  return (
    <BrowserRouter>
      <div className="App" style={{ overflow: "hidden" }}>
        <Routes>
          <Route
            path="/login"
            element={loggedIn ? <Navigate to="/" /> : <Login />}
          />
          <Route
            path="/*"
            element={
              <RequireAuth loggedIn={loggedIn}>
                <Navbar setOpenModal={setopenCalendarModal}/>
                <Dashboard openModal={openCalendarModal} setOpenModal={setopenCalendarModal}/>
              </RequireAuth>
            }
          />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

function RequireAuth({ children, loggedIn }) {


  if (!loggedIn) {
    // Redirect them to the /login page, but save the current location they were
    // trying to go to when they were redirected. This allows us to send them
    // along to that page after they login, which is a nicer user experience
    // than dropping them off on the home page.
    return <Navigate to="/login" />;
  }

  return children;
}
