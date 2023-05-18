import Classes from "./Appointment.module.scss";
import {Button, Form} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {solid} from "@fortawesome/fontawesome-svg-core/import.macro";
import {useEffect, useState} from "react";
import {getAllPatient} from "../../services/patient/patient";
import {Patient} from "../../model/patient/patient";
import {useNavigate} from "react-router-dom";
import {startAppointment} from "../../services/appointment/appointment";
import {Response} from "../../model/auth/auth";

const Appointment = () => {
    const [patients, setPatients] = useState<Patient[]>();
    const [selectedPatient, setSelectedPatient] = useState<string>();
    const navigate = useNavigate();

    useEffect(() => {
        (async () => {
            const data = await getAllPatient() as unknown as Patient[];
            setPatients(data);
            if (data.length > 0) {
                // @ts-ignore
                setSelectedPatient(data?.at(0).email);
            }
        })();
    }, [])

    const handleFirstStep = async () => {
        if (selectedPatient) {
            const success = await startAppointment(selectedPatient);
            if (success === Response.SUCCESS) {
                navigate(`/doktor/upitnici`);
            }
        }
    }

    return (
        <div className={Classes.paper}>
            <div className={Classes.header}>
                <FontAwesomeIcon className={Classes.icon} icon={solid('stethoscope')}/>
                <h1>Novi pregled</h1>
            </div>
            <Form>
                <Form.Group className={Classes.input}>
                    <Form.Label><h4>Izaberite pacijenta:</h4></Form.Label>
                    <Form.Select className={Classes.input_field} value={selectedPatient}
                                 onChange={(e) => setSelectedPatient(e.target.value)}>
                        {patients?.map((patient, index) =>
                            <option key={index} value={patient.email}>{patient.email}</option>
                        )}
                    </Form.Select>
                </Form.Group>
                <div className={Classes.buttonSubmit}>
                    <Button className={Classes.button} onClick={handleFirstStep}>Počni
                        pregled</Button>
                </div>
            </Form>
        </div>
    );

}
export default Appointment;


