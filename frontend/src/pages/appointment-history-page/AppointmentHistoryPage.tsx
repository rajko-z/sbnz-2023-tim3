import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import MenuPatient from "../../components/menu-patient/MenuPatient";
import AppointmentHistory from "../../components/appointment-history/AppointmentHistory";

interface IAppointmentHistoryPage {
    isDoctor: boolean;
}

const AppointmentHistoryPage = ({isDoctor}: IAppointmentHistoryPage) => {
    return(
        <div className={Classes.background}>
            {isDoctor ? <MenuDoctor/> : <MenuPatient/>}
            <AppointmentHistory isDoctor={isDoctor}/>
        </div>
    )
}

export default AppointmentHistoryPage;