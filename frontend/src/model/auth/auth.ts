import {userRole} from "./roles";

export interface Token {
    sub: string;
    role: Role;
}

export interface Role {
    id: number;
    naziv: userRole;
}

export interface LoginRequest {
    email: string;
    lozinka: string;
}

export enum Response {
    ERROR = 'ERROR',
    SUCCESS = 'SUCCESS'
}