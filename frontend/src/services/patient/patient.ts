import {api} from "../../utils/api";
import {PatientDTO} from "../../model/patient/patientDTO";

export const getAllPatient = () => {
    return api
        .get("/pacijenti")
        .then((res) => res.data)
        .catch((err) => {
            console.log(err);
        });
}


export const addPatient = (data: PatientDTO) => {
    return api
        .post("/pacijenti", data)
        .then((res) => res.data)
        .catch((err) => {
            console.log(err);
        });
}