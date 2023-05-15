import {userRole} from "../auth/roles";

export interface Patient {
    email: string;
    lozinka: string;
    ime: string;
    prezime: string;
    brojTelefona: string;
    datumRodjenja: Date;
    adresa: string;
    rola: userRole;
    datumPoslednjePromeneSifre: Date;

    //lista pregleda i rezultati pregleda
}