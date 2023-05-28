import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import ResultComponent from "../../components/result/ResultComponent";

const ResultPage = () => {

    return (
        <div className={Classes.background}>
            <MenuDoctor/>
            <ResultComponent/>
        </div>
    );
}
export default ResultPage;