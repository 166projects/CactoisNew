import { Component, OnInit } from '@angular/core';
import { Userclass } from '../../userclass';
import { userservice } from '../../userservice.service';
import { ActivatedRoute, Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-userprofileview',
  templateUrl: './userprofileview.component.html',
  styleUrls: ['./userprofileview.component.css']
})
export class UserprofileviewComponent  {
  showDetails = false;
  userclass:Userclass;
  constructor (private userservice: userservice,private route: ActivatedRoute, private router: Router){
    this.userclass=userservice.currentUserValue;
  }
  toggleDetails(): void
  {
  this.showDetails = !this.showDetails ;
  }
  EditDetails() : void{
    this.router.navigate(['editprofile']);
  }
  DeleteDetails() : void 
  {
    this.userservice.deleteUser(this.userclass.cid);
  }
  Back() : void{
    this.router.navigate(['userprofile']);
  }
}
