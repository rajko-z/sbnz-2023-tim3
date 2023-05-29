import {api} from "../../utils/api";
import {PatientDTO} from "../../model/patient/patientDTO";
import {toast} from "react-toastify";
import {Response} from "../../model/auth/auth";

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
        .then((res) => {
            toast.success(res.data.text, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            })
            return Response.SUCCESS;
        })
        .catch((err) => {
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
            return Response.ERROR;
        });
}