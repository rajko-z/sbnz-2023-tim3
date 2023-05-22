import {SignalType} from "./signalType";

export interface Signal {
    amplituda: number;
    deoMozga: string; //treba DeoMozga
    frekvencija: number;
    stanjePacijenta: string; //treba StanjePacijenta
    timestamp: number;
    tip: SignalType;
}