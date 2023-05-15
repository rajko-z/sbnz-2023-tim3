import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import FirstStep from "../../components/appointment/FirstStep";

const QuestionnairesPage = () => {
    return (
        <div className={Classes.background}>
            <MenuDoctor/>
            <FirstStep/>
        </div>
    );
}

export default QuestionnairesPage;