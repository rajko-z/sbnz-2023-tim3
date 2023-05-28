import React, {useState} from "react";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import Classes from "./Accordion.module.scss";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Appointment} from "../../model/appointment/appointment";
import {Patient} from "../../model/patient/patient";

interface IAccordion {
    appointment: Appointment;
    isDoctor: boolean
}

const Accordion = ({appointment, isDoctor}: IAccordion) => {
    console.log(appointment)
    const [show, setShow] = useState(false);
    const icon = show ? solid('chevron-up') : solid('chevron-down');


    const userInformation = (user: Patient) => {
        return (
            <div className={Classes.information}>
                <p>Email: {user.email}</p>
                <p>Ime: {user.ime}</p>
                <p>Prezime: {user.prezime}</p>
                <p>Broj godina: {user.brojGodina}</p>
                <p>Broj telefona: {user.brojTelefona}</p>
            </div>
        );
    }

    const appointmentInformation = () => {
        return (
            <div className={Classes.information}>
                <p>ADHD procenat: {appointment.adhdProcenat}</p>
                <p>Epilepsija procenat: {appointment.epilepsijaProcenat}</p>
                <p>Alchajmer procenat: {appointment.alchajmerProcenat}</p>
                <p>Nesanica procenat: {appointment.nesanicaProcenat}</p>
            </div>
        );
    }

    return (
        <div className={Classes.accordion}>
            <div className={Classes.tableRow}>
                <p>{appointment.pacijent.email}</p>
                <p>{appointment.doktor.email}</p>
                <p>{appointment.eegVremePocetka}</p>
                <p onClick={() => setShow(!show)} className={Classes.showData}><FontAwesomeIcon icon={icon}/></p>
            </div>
            <div className={show ? Classes.show : Classes.hidden}>
                <h4>Informacije o {isDoctor ? "pacijentu " : "doktoru "}</h4>
                {isDoctor ? userInformation(appointment.pacijent) : userInformation(appointment.doktor)}
                <h4>Informacije o pregledu</h4>
                {appointmentInformation()}
                <h4>Preporučeni lekovi</h4>
                {appointment.izdatiLekovi.length === 0 ? "Za izabrani pregled ne postoje preporučeni lekovi..." :
                    appointment.izdatiLekovi?.map((lek) => {
                        return (
                          <p>{lek.opisLeka.naziv}</p>
                        );
                    })}
            </div>
        </div>
    );
}
export default Accordion;