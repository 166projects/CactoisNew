import { Userclass } from './userclass';
import { Adminclass } from './adminclass';
import { Driverclass } from './driverclass';

export class Userhelpdeskclass {

    hid : String;
    id : number;
    complaint : String;
    driver  :Driverclass[];
    user : Userclass[];

   // driver: Driverclass;
}
