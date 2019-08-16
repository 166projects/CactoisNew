import { Adminclass } from './adminclass';
import { Userpaymentclass } from './userpaymentclass';
import { Uservehicleclass } from './uservehicleclass';
import { Driverclass } from './driverclass';
import { Userclass } from './userclass';

export class Userbookingclass {
    bid : string;
    source: string;
    destination: string
    reg_date: string
    status: string;
    user : Userclass;
    payment: Userpaymentclass;
    vehicle : Uservehicleclass;

    
}
