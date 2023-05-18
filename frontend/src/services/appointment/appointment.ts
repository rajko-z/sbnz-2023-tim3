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
            console.log(err);
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
            return Response.ERROR;
        });
}