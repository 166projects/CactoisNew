import { Component, OnInit } from '@angular/core';
import { userservice } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Userclass } from '../userclass';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title = 'user';
  userclass : Userclass;
  usersign : Userclass;
  uemail : string;
  pass : string;

  constructor (private userservice: userservice,private route: ActivatedRoute, private router: Router){
  }
  ngOnInit() {
  }
  login():void 
  {
    
     this.userservice.login(this.uemail,this.pass)
     .subscribe((data: any) => {
     this.userclass = data;
     console.log(this.userclass);});
     console.log();
     if(this.userclass.uemail===this.uemail)
              this.router.navigate(['/userprofile']);
}
getData():Userclass
{
  return this.userclass;
}
}
