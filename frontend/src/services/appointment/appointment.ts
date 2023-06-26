import {api} from "../../utils/api";
import {toast} from "react-toastify";
import {Response} from "../../model/auth/auth";

export const startAppointment = (patient: string) => {
    return api
        .post(`/pregledi/zapocni/${patient}`)
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
export const startEEGAppointment = () => {
    return api
        .put('/pregledi/zapocni-eeg')
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

export const finishEEGAppointment = () => {
    return api
        .put('/pregledi/zavrsi-eeg')
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

export const getAllAppointments = (isDoctor: boolean) => {
    const path = isDoctor ? "/pregledi/doktor" : "/pregledi/pacijent";
    return api
        .get(path)
        .then((res) => res.data)
        .catch((err) => {
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
        });
}

export const getRezultatiPregleda = () => {
    return api
        .get("/pregledi/rezultati")
        .then((res) => res.data)
        .catch((err) => {
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
        });
}

export const sendAllergy = (allegry: string[]) => {
    return api
        .put("/pregledi/predlozi-lekove", {"alergije": allegry})
        .then((res) => res.data)
        .catch((err) => {
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
        });
}

export const finishAppointment = () => {
    return api
        .put("/pregledi/zavrsi-pregled")
        .then((res) => {
            toast.success(res.data.text, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
            return Response.SUCCESS;
        })
        .catch((err) => {
                toast.error(err.response.data.poruka, {
                    position: toast.POSITION.BOTTOM_RIGHT,
                    autoClose: 1500,
                });
            });
        }
