import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import EEGAppointment from "../../components/EEG-appointment/EEGAppointment";

const EEGPage = () => {
    return (
        <div className={Classes.background}>
            <MenuDoctor/>
            <EEGAppointment/>
        </div>
    );
}

export default EEGPage;