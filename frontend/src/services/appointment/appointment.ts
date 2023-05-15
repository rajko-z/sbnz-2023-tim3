import {api} from "../../utils/api";
import {toast} from "react-toastify";

export const startAppointment = (patient: string) => {
    return api
        .post(`/pregledi/zapocni/${patient}`)
        .then((res) => {
            toast.success(res.data.text, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            })
        })
        .catch((err) => {
            console.log(err);
            toast.error(err.response.data.poruka, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
        });
}