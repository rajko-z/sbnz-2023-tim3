import {Patient} from "../patient/patient";

export interface Appointment {
    doktor: Patient;
    pacijent: Patient;
    izdatiLekovi: Drug[];
    adhdProcenat: number;
    alchajmerProcenat: number;
    nesanicaProcenat: number;
    epilepsijaProcenat: number;
    beleske: string;
    zakljucak: string;
    eegVremePocetka: string;
    eegVremeZavrsetka: Date;
    zavrsen: boolean;
    stanjeEEGPregleda: EEGState;
}


export enum EEGState {
    NIJE_ZAPOCET = "NIJE_ZAPOCET",
    U_TOKU = "U_TOKU",
    ZAVRSEN = "ZAVRSEN"
}

export interface Drug {
    opisLeka: DrugDescription;
    pregled: Appointment;
    opisDoze: string;
}

export interface DrugDescription {
    naziv: string;
    zaBlaguBolest: boolean;
    zaSrednjuBolest: boolean;
    zaTeskuBolest: boolean;
    dozvoljeniUzrasti: Uzrast[];
    sastojci: string[];
    tipBolesti: TipBolesti;
    opisDoze: string;
}

export enum Uzrast {
    DETE = "DETE",
    ADOLESCENT = "ADOLESCENT",
    ODRASTAO = "ODRASTAO"
}

export interface SastojakLeka {
    naziv: string
}

export enum TipBolesti {
    ADHD = "ADHD",
    ALCHAJMER = "ALCHAJMER",
    NESANICA = "NESANICA",
    EPILEPSIJA = "EPILEPSIJA"
}

export interface AppointmentDTO {
    adhdProcenat: number;
    alchajmerProcenat: number;
    nesanicaProcenat: number;
    epilepsijaProcenat: number;
    tipBolesti: TipBolesti |null;
    procenatPronadjeneBolesti: number;
    sastojci: string[];
}