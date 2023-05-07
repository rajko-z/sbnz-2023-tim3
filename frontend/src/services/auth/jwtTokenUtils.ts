import jwtDecode from "jwt-decode";
import {Token} from "../../model/auth/auth";

export function getUsernameFromToken() {
    const user = sessionStorage.getItem("user");
    if (user) {
        const token = jwtDecode(user) as Token;
        return token.sub;
    }
    return null;
}

export function getRoleFromToken() {
    const user = sessionStorage.getItem("user");
    if (user) {
        const token = jwtDecode(user) as Token;
        return token.role.naziv;
    }
    return null;
}