import { Component, OnInit } from '@angular/core';
import { userservice } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Userclass } from '../userclass';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent {


   userclass:Userclass;
  constructor (private userservice: userservice,private route: ActivatedRoute, private router: Router){
    this.userclass=userservice.currentUserValue;
  }

  booking():void
  {
    this.router.navigateByUrl('userbooking');
  }

}
