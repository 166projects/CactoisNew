import { Component } from '@angular/core';
import { userservice } from './userservice.service';
import { Userclass } from './userclass';
import { Router, ActivatedRoute } from '../../node_modules/@angular/router';
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'user';
  userclass : Userclass;
  usersign : Userclass;
  uemail : string;
  upass : string;
  

  constructor (private userservice: userservice,private route: ActivatedRoute, private router: Router){
  }
   
// sign():void
// {
//  this.usersign = {
//     'cid': "U1",
//     'uname': "venkat",
//     'uemail': "venkatA0@gmail.com",
//     'upass': "Mphasiss",
//     'uphnum': 987456123,
//     'ugender': "m",
//     'uidproof': "111122223333",
//     'ucusrating': 5,
//     'current_Address': "No.4,Mahadevpura,Bangalore",
//     'emgcontact': 123456789,
//     'Permanent_Address': "No.21,Mascot 90, Bangalore",
     
// }
//   this.userservice.signup(this.usersign);
  
// }
  }