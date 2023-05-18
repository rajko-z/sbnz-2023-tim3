import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import Registration from "../../components/forms/registration/Registration";

const RegistrationPage = () => {
    return(
        <div>
            <div className={Classes.background}>
                <MenuDoctor/>
                <Registration/>
            </div>
        </div>
    );
}
export default RegistrationPage;