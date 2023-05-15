import {api} from "../../utils/api";

export const getAllPatient = () => {
    return api
        .get("/pacijenti")
        .then((res) => res.data)
        .catch((err) => {
            console.log(err);
            // return Response.ERROR;
        });
}