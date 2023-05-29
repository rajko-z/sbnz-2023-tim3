import Classes from "../home-page-doctor/HomePageDoctor.module.scss";
import MenuDoctor from "../../components/menu-doctor/MenuDoctor";
import AllergyCheck from "../../components/allergy-check/AllergyCheck";
import DrugComponent from "../../components/drug/DrugComponent";
import {useEffect, useState} from "react";
import {finishAppointment, getRezultatiPregleda, sendAllergy} from "../../services/appointment/appointment";
import {AppointmentDTO, DrugDescription} from "../../model/appointment/appointment";
import {Button} from "react-bootstrap";
import {Response} from "../../model/auth/auth";
import {useNavigate} from "react-router-dom";

const EEGPage = () => {
    const [appointment, setAppointment] = useState<AppointmentDTO>();
    const [drugs, setDrugs] = useState<DrugDescription[]>();
    const [disable, setDisable] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        (async () => {
            const data = await getRezultatiPregleda() as unknown as AppointmentDTO;
            setAppointment(data);
        })();
    }, [disable]);

    const handleOnClickButton = async (selected: string[]) => {
        setDisable(true);
        const drugs = await sendAllergy(selected);
        setDrugs(drugs);
    }

    const handleOnFinish = async () => {
        const success = await finishAppointment();
        if(success === Response.SUCCESS){
            navigate("/doktor");
        }
    }

    return (
        <div className={Classes.background}>
            <MenuDoctor/>
            <div className={Classes.canvas}>
                <AllergyCheck components={appointment?.sastojci || []} handleOnClickButton={handleOnClickButton} disable={disable}/>
                <DrugComponent drugs={drugs || []}/>
                <div className={Classes.buttonSubmit}>
                    <Button type="submit" className={Classes.button} onClick={handleOnFinish}>
                        Zavrsi pregled
                    </Button>
                </div>
            </div>
        </div>
    );
}

export default EEGPage;