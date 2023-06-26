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
import {ToastContainer} from "react-toastify";
import QuestionnairesPage from "./pages/questionnaires-page/QuestionnairesPage";
import EEGPage from "./pages/eeg-page/EEGPage";
import 'react-toastify/dist/ReactToastify.css';
import RegistrationPage from "./pages/registration-page/RegistrationPage";
import AppointmentHistoryPage from "./pages/appointment-history-page/AppointmentHistoryPage";
import ResultPage from "./pages/result-page/ResultPage";
import DrugPage from "./pages/drug-page/DrugPage";

function App() {
    loadIcon();
    let redirectPath = '/';
    const role = getRoleFromToken();
    if (role) {
        redirectPath = path[role];
    }

    return (
        <>
            <BrowserRouter>
                <Routes>
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
                    <Route path="/doktor/upitnici"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={QuestionnairesPage}/>}/>
                    <Route path="/doktor/eeg"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={EEGPage}/>}/>
                    <Route path="/doktor/registracija"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={RegistrationPage}/>}/>
                    <Route path="/doktor/istorija-pregleda"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={() => <AppointmentHistoryPage isDoctor={true}/>}/>}/>
                    <Route path="/pacijent/istorija-pregleda"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_PACIJENT]}
                                                  redirectPath={redirectPath}
                                                  component={() => <AppointmentHistoryPage isDoctor={false}/>}/>}/>
                    <Route path="/doktor/rezultati"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={ResultPage}/>}/>
                    <Route path="/doktor/preporuceni-lekovi"
                           element={<PrivateRoute isAuthenticated={!!getUsernameFromToken()}
                                                  role={getRoleFromToken()}
                                                  allowedRoles={[userRole.ROLE_DOKTOR]}
                                                  redirectPath={redirectPath}
                                                  component={DrugPage}/>}/>
                </Routes>
            </BrowserRouter>
            <ToastContainer theme="dark"/>
        </>
    );
}

export default App;
