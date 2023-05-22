import Classes from "./FirstStep.module.scss";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import {Button} from "react-bootstrap";
import Modal from "../modal/Modal";
import Questionnaire from "../questionnaire/Questionnaire";
import {ADHDQuestions} from "../../assets/questions/ADHDQuestions";
import {NesanicaQuestions} from "../../assets/questions/NesanicaQuestions";
import {Disease} from "../../constants/questionnaire/constants";
import {AlchajmerQuestions} from "../../assets/questions/AlchajmerQuestions";
import {EpilepsijaQuestions} from "../../assets/questions/EpilepsijaQuestions";
import {useQuestionnaires} from "../../hooks/useQuestionnaires";
import {useNavigate} from "react-router-dom";
import {startEEGAppointment} from "../../services/appointment/appointment";
import {Response} from "../../model/auth/auth";

const FirstStep = () => {
    const {
        showADHD,
        showAlchajmer,
        showEpilepsija,
        showNesanica,
        setADHD,
        setAlchajmer,
        setEpilepsija,
        setNesanica,
        disableADHD,
        disableEpilepsija,
        disableAlchajmer,
        disableNesanica
    } = useQuestionnaires();
    const navigate = useNavigate();

    const handleSecondStep = async () => {
        const success = await startEEGAppointment();
        if (success === Response.SUCCESS) {
            navigate(`/doktor/eeg`);
        }
    }

    return (
        <div className={Classes.canvas}>
            <div className={Classes.header}>
                <FontAwesomeIcon className={Classes.icon} icon={solid('question')}/>
                <h2>Izaberite neki od upitnika:</h2>
            </div>
            <div className={Classes.buttons}>
                <Button disabled={disableADHD} className={Classes.buttonItem} onClick={() => setADHD(true)}>
                    Upitnik za ADHD
                </Button>
                <Button disabled={disableEpilepsija} className={Classes.buttonItem} onClick={() => setEpilepsija(true)}>
                    Upitnik za Epilepsiju
                </Button>
                <Button disabled={disableNesanica} className={Classes.buttonItem} onClick={() => setNesanica(true)}>
                    Upitnik za Nesanicu
                </Button>
                <Button disabled={disableAlchajmer} className={Classes.buttonItem} onClick={() => setAlchajmer(true)}>
                    Upitnik za Alchajmerovu bolest
                </Button>
            </div>
            <Modal show={showADHD}>
                <Questionnaire questions={ADHDQuestions} disease={Disease.ADHD} setShowModal={setADHD}/>
            </Modal>
            <Modal show={showNesanica}>
                <Questionnaire questions={NesanicaQuestions} disease={Disease.NESANICA} setShowModal={setNesanica}/>
            </Modal>
            <Modal show={showAlchajmer}>
                <Questionnaire questions={AlchajmerQuestions} disease={Disease.ALCHAJMER} setShowModal={setAlchajmer}/>
            </Modal>
            <Modal show={showEpilepsija}>
                <Questionnaire questions={EpilepsijaQuestions} disease={Disease.EPILEPSIJA}
                               setShowModal={setEpilepsija}/>
            </Modal>
            <div className={Classes.buttonSubmit}>
                <Button type="submit" className={Classes.button} onClick={handleSecondStep}>
                    Počni EEG pregled
                </Button>
            </div>
        </div>
    );
}
export default FirstStep;