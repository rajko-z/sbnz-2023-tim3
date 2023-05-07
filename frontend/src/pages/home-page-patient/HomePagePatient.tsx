import MenuPatient from "../../components/menu-patient/MenuPatient";
import Classes from "./HomePagePatient.module.scss";

const HomePagePatient = () => {
    return (
        <div className={Classes.background}>
            <MenuPatient/>
        </div>
    );
}

export default HomePagePatient;