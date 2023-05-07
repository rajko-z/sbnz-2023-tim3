import Classes from "./Appointment.module.scss";
import {Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import Questionnaire from "../questionnaire/Questionnaire";
import {ADHDQuestions} from "../../assets/questions/ADHDQuestions";
import Modal from "../modal/Modal";
import {useState} from "react";
import {AlchajmerQuestions} from "../../assets/questions/AlchajmerQuestions";
import {EpilepsijaQuestions} from "../../assets/questions/EpilepsijaQuestions";
import {NesanicaQuestions} from "../../assets/questions/NesanicaQuestions";

const Appointment = () => {
    const [showADHD, setShowADHD] = useState(false);
    const [showNesanica, setShowNesanica] = useState(false);
    const [showAlchajmer, setShowAlchajmer] = useState(false);
    const [showEpilepcija, setShowEpilepcija] = useState(false);

    return (
        <div className={Classes.canvas}>
            <div className={Classes.header}>
                <FontAwesomeIcon className={Classes.icon} icon={solid('question')}/>
                <h3>Izaberite neki od upitnika:</h3>
            </div>
            <div className={Classes.buttons}>
                <Button className={Classes.button} onClick={() => setShowADHD(true)}>Upitnik za ADHD</Button>
                <Button className={Classes.button} onClick={() => setShowEpilepcija(true)}>Upitnik za
                    Epilepsiju</Button>
                <Button className={Classes.button} onClick={() => setShowNesanica(true)}>Upitnik za Nesanicu</Button>
                <Button className={Classes.button} onClick={() => setShowAlchajmer(true)}>Upitnik za Alchajmerovu
                    bolest</Button>
            </div>
            <Modal show={showADHD}>
                <Questionnaire questions={ADHDQuestions} disease={"ADHD"}/>
            </Modal>
            <Modal show={showNesanica}>
                <Questionnaire questions={NesanicaQuestions} disease={"Nesanicu"}/>
            </Modal>
            <Modal show={showAlchajmer}>
                <Questionnaire questions={AlchajmerQuestions} disease={"Alchajmer"}/>
            </Modal>
            <Modal show={showEpilepcija}>
                <Questionnaire questions={EpilepsijaQuestions} disease={"Epilepsiju"}/>
            </Modal>
        </div>
    );
}
export default Appointment;