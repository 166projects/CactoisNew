import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Driverclass } from '../driverclass';
import { DriverserviceService } from '../driverservice.service';


@Component({
  selector: 'app-driverlogin',
  templateUrl: './driverlogin.component.html',
  styleUrls: ['./driverlogin.component.css']
})
export class DriverloginComponent implements OnInit {

  driverclass : Driverclass;
  demail : string;
  dpass : string;

  constructor(private driverservice: DriverserviceService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  driverlogin():void 
  {
     this.driverservice.driverlogin(this.demail,this.dpass)
     .subscribe((data: any) => {
     this.driverclass = data;
     console.log(this.driverclass);});
     console.log();
     if(this.driverclass)
              this.router.navigate(['/userbooking']);
}
}
