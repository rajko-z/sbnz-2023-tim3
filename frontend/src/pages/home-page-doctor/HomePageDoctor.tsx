import Classes from "./HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import Appointment from "../../components/appointment/Appointment";

const HomePageDoctor = () => {
    return (
        <div className={Classes.background}>
            <MenuDoctor/>
            <Appointment/>
        </div>
    );
}

export default HomePageDoctor;