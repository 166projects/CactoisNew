import { Component, OnInit } from '@angular/core';
import { Userclass } from '../../userclass';
import { userservice } from '../../userservice.service';
import { ActivatedRoute, Router } from '../../../../node_modules/@angular/router';
import { FormsModule} from '@angular/forms';
@Component({
  selector: 'app-userprofileedit',
  templateUrl: './userprofileedit.component.html',
  styleUrls: ['./userprofileedit.component.css']
})
export class UserprofileeditComponent   {

  userclass : Userclass;
  uname : string;
  upass : string;
  uphnum : number;
  uephnum : number;
  Current_Address : string;
  constructor (private userservice: userservice,private route: ActivatedRoute, private router: Router){
    this.userclass=userservice.currentUserValue;
  }
 edit() : void
 {
     this.userclass =
     {
        'cid':  this.userclass.cid,
        'uname': this.uname,
        'uemail': this.userclass.uemail,
        'upass': this.upass,
        'uphnum':  this.uphnum,
        'ugender': this.userclass.ugender,
        'uidproof': this.userclass.uidproof,
        'ucusrating': this.userclass.ucusrating,
        'permanent_Address': this.userclass.permanent_Address,
        'current_Address': this.Current_Address,
        'emgcontact': this.uephnum
     };
     console.log(this.userclass);
     this.userservice.updateUser(this.userclass);
 }
   

}
