import { Obrazovanje } from "./Obrazovanje";
import { Sektor } from "./Sektor";

export interface Radnik {
    id?: number;
    ime: string;
    prezime: string;
    brojLk: number;
    obrazovanje: Obrazovanje;
    sektor: Sektor;
};