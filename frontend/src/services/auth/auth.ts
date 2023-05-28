import {api} from "../../utils/api";
import {toast} from "react-toastify";
import {LoginRequest, Response} from "../../model/auth/auth";

export const logIn = (data: LoginRequest) => {
    return api
        .post("/auth/login", data)
        .then((res) => {
            const token = res.data.token;
            sessionStorage.setItem("user", token);
            return Response.SUCCESS;
        })
        .catch((err) => {
            toast.error(err.response.data, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
            return err.response.data.message;
        });
}