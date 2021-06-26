import { Preduzece } from "./Preduzece";

export interface Sektor {
    id?: number;
    naziv: string;
    oznaka: string;
    preduzece: Preduzece;
};