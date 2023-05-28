import Classes from "./AppointmentHistory.module.scss";
import {useEffect, useState} from "react";
import {Appointment} from "../../model/appointment/appointment";
import Accordion from "../accordion/Accordion";
import {getAllAppointments} from "../../services/appointment/appointment";

interface IAppointmentHistory {
    isDoctor: boolean;
}

const AppointmentHistory = ({isDoctor}: IAppointmentHistory) => {
    const [appointments, setAppointments] = useState<Appointment[]>([]);

    useEffect(() => {
        (async () => {
            const data = await getAllAppointments(isDoctor) as unknown as Appointment[];
            setAppointments(data);
        })();
    }, []);

    if (appointments?.length > 0) {
        return (
            <div className={Classes.table}>
                <ul className={Classes.responsiveTable}>
                    <li className={Classes.tableHeader}>
                        <p>Email pacijenta</p>
                        <p>Email doktora</p>
                        <p>Datum pregleda</p>
                        <p></p>
                    </li>
                    {appointments?.map((appointment) => <Accordion appointment={appointment} isDoctor={isDoctor}/>)}
                </ul>
            </div>
        );
    }
    return (
        <div className={Classes.table}>
            <h3>There are currently no appointments!</h3>
        </div>
    );
}

export default AppointmentHistory;