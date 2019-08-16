import { Component } from '@angular/core';
import { userservice } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Userclass } from '../userclass';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  uname : string;
  ugender : string;
  uemail : string;
  upass : string;
  uphnum : number;
  uidproof : string;
  current_Address :string ;
  permanent_Address : string;
  emgcontact : number;
  userclass : Userclass;
  usersign : Userclass;
  // uname : String;
  // isDisabled:boolean = false;

  constructor(private userservice: userservice,private route: ActivatedRoute, private router: Router) { }

  signup() : void{
    this.userclass =
    {
      'cid': 'auto' ,
      'uname': this.uname,
      'uemail':  this.uemail,
      'upass': this.upass,
      'uphnum':  this.uphnum,
      'ugender':  this.ugender,
      'uidproof':  this.uidproof,
      'ucusrating':  5,
      'permanent_Address':this.permanent_Address, 
      'current_Address':  this.current_Address,
     'emgcontact':  this.emgcontact
    }
     console.log(this.userclass);
this.userservice.signup(this.userclass).subscribe((data : any) => 
{
console.log('User Registered successfully!!');
this.router.navigateByUrl('/login');},(err: any)=>{

  console.log(err);
});
  }}

