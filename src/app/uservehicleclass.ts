import { Userbookingclass } from './userbookingclass';
import { Driverclass } from './driverclass';

export class Uservehicleclass {
    vno : string;
    vtype : string;
    vstatus : string;
    vseats : number;
    fare : number;
    driver : Driverclass;
    //booking : Userbookingclass[];
}
