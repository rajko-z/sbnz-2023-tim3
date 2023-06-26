import CircularProgressWithLabel from "../circular-progress/CircularProgressWithLabel";
import Classes from "./ResultComponent.module.scss";
import {useEffect, useState} from "react";
import {finishAppointment, getRezultatiPregleda} from "../../services/appointment/appointment";
import {AppointmentDTO} from "../../model/appointment/appointment";
import {Button} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {Response} from "../../model/auth/auth";

const ResultComponent = () => {
    const [appointment, setAppointment] = useState<AppointmentDTO>();
    const navigate = useNavigate();

    useEffect(() => {
        (async () => {
            const data = await getRezultatiPregleda() as unknown as AppointmentDTO;
            setAppointment(data);
        })();
    }, []);


    const handleOnDrug = () => {
        navigate("/doktor/preporuceni-lekovi");
    }

    const handleOnFinish = async () => {
        const success = await finishAppointment();
        if(success === Response.SUCCESS){
            navigate("/doktor");
        }
    }

    const renderPatientIsOk = () => {
        return (
            <div className={Classes.wrapper}>
                <h2 className={Classes.title}>Pacijent je zdrav!</h2>
                <svg className={Classes.checkmark} xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
                    <circle className={Classes.checkmark__circle} cx="26" cy="26" r="25" fill="none"/>
                    <path className={Classes.checkmark__check} fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8"/>
                </svg>
            </div>
        );
    }
    const renderPatientIsNotOk = () => {
        return (
            <div className={Classes.wrapper}>
                <h2 className={Classes.titleRed}>Pacijent nije zdrav!</h2>
                <svg className={Classes.checkmarkRed} xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
                    <circle className={Classes.checkmarkCircle} cx="26" cy="26" r="25" fill="none"/>
                    <path className={Classes.checkmarkCheck} fill="none" d="M14.1 14.1l23.8 23.8 m0,-23.8 l-23.8,23.8"/>
                </svg>
            </div>
        );
    }
    console.log(appointment)

    return (
        <div className={Classes.page}>
            {appointment?.tipBolesti ? renderPatientIsNotOk() : renderPatientIsOk()}
            <div className={Classes.canvas}>
                <CircularProgressWithLabel
                    value={appointment?.alchajmerProcenat ? appointment?.alchajmerProcenat * 100 : 0}
                    title={"Alchajmerova bolest"}/>
                <CircularProgressWithLabel value={appointment?.adhdProcenat ? appointment?.adhdProcenat * 100 : 0}
                                           title={"ADHD"}/>
                <CircularProgressWithLabel
                    value={appointment?.epilepsijaProcenat ? appointment?.epilepsijaProcenat * 100 : 0}
                    title={"Epilepsija"}/>
                <CircularProgressWithLabel
                    value={appointment?.nesanicaProcenat ? appointment?.nesanicaProcenat * 100 : 0} title={"Nesanica"}/>
            </div>
            {appointment?.tipBolesti ?
                (<div className={Classes.buttonSubmit}>
                    <Button type="submit" className={Classes.button} onClick={handleOnDrug}>
                        Preporuci lekove
                    </Button>
                </div>) :
                (<div className={Classes.buttonSubmit}>
                    <Button type="submit" className={Classes.button} onClick={handleOnFinish}>
                        Zavrsi pregled
                    </Button>
                </div>)
            }
        </div>
    );
}
export default ResultComponent;