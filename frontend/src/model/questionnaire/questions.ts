export interface Questions {
    question: string;
    choices: string[];
}

export enum VremenskiOdgovor {
    NIKAD = "NIKAD",
    RETKO = "RETKO",
    PONEKAD = "PONEKAD",
    CESTO = "CESTO"
}

export enum TrajanjeOdgovor {
    KRATKO = "KRATKO",
    SREDNJE = "SREDNJE",
    DUGO = "DUGO"
}

export enum DaNeOdgovor {
    DA = "DA",
    NE = "NE"
}

export enum UcestalostOdgovor {
    NIKAD = "NIKAD",
    PET_GODINA = "PET_GODINA",
    GODINA = "GODINA",
    MESEC = "MESEC",
    NEDELJA = "NEDELJA"
}