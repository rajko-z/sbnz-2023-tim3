import React from 'react';
import './App.css';
import PublicRoute from "./guards/PublicRoute";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import loadIcon from "./utils/loadIcon";
import {getRoleFromToken, getUsernameFromToken} from "./services/auth/jwtTokenUtils";
import LogInPage from "./pages/log-in-page/LogInPage";
import {path, userRole} from "./model/auth/roles";
import 'bootstrap/dist/css/bootstrap.min.css';
import PrivateRoute from "./guards/PrivateRoute";
import HomePagePatient from "./pages/home-page-patient/HomePagePatient";
import HomePageDoctor from "./pages/home-page-doctor/HomePageDoctor";

function App() {
    loadIcon();
    let redirectPath = '/';
    const role = getRoleFromToken();
    if (role) {
        redirectPath = path[role];
    }
    return (
        <BrowserRouter>
            <Routes>
                {/*<Route path="/"*/}
                {/*       element={<PublicRoute isAuthenticated={!!getUsernameFromToken()}*/}
                {/*                             redirectPath={redirectPath}*/}
                {/*                             component={HomePage}/>}/>*/}
                <Route path="/"
                       element={<PublicRoute isAuthenticated={!!getUsernameFromToken()}
                                             redirectPath={redirectPath}
                                             component={() => <LogInPage/>}/>}/>
                <Route path="/pacijent"
                       element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                              role={getRoleFromToken()}
                                              allowedRoles={[userRole.ROLE_PACIJENT]}
                                              redirectPath={redirectPath}
                                              component={HomePagePatient}/>}/>
                <Route path="/doktor"
                       element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                              role={getRoleFromToken()}
                                              allowedRoles={[userRole.ROLE_DOKTOR]}
                                              redirectPath={redirectPath}
                                              component={HomePageDoctor}/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
