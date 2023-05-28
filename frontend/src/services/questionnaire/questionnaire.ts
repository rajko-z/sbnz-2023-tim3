import {api} from "../../utils/api";
import {Answers} from "../../model/questionnaire/answers";
import {Disease} from "../../constants/questionnaire/constants";
import {typeDictionary} from "../../utils/types";
import {toast} from "react-toastify";
import {Response} from "../../model/auth/auth";

const url: typeDictionary = {
    [Disease.EPILEPSIJA]: '/upitnici/dodaj-epilepsija',
    [Disease.ADHD]: '/upitnici/dodaj-adhd',
    [Disease.ALCHAJMER]: '/upitnici/dodaj-alchajmer',
    [Disease.NESANICA]: '/upitnici/dodaj-nesanica'
}

export const sendQuestionnaire = (data: Answers, type: string) => {
    const path = url[type];
    return api
        .post(path, data)
        .then((res) => {
            toast.success(res.data.text, {
                position: toast.POSITION.BOTTOM_RIGHT,
                autoClose: 1500,
            });
            return Response.SUCCESS;
        })
        .catch((err) => {
            return Response.ERROR;
        });
}