import { Component, OnInit } from '@angular/core';
import { Uservehicleclass } from '../uservehicleclass';
import { userservice } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Userbookingclass } from '../userbookingclass';
import { LoginComponent } from '../login/login.component';
import { Userclass } from '../userclass';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { Userpaymentclass } from '../userpaymentclass';
 
@Component({
  selector: 'app-usernewbooking',
  templateUrl: './usernewbooking.component.html',
  styleUrls: ['./usernewbooking.component.css']
})
export class UsernewbookingComponent implements OnInit {
  location : string;
  dest : string;
  userclass : Userclass;
  showDetails = false;
  paymentDetails = false;
  registerForm: FormGroup;
  submitted = false;
  uservehicleclass : Uservehicleclass[];
  usernewBooking : Userbookingclass;
  vehicleInfo : Uservehicleclass;
  vevh : Uservehicleclass;
  fare : number;
  payment : Userpaymentclass;
  constructor (private formBuilder: FormBuilder,private userservice: userservice,private route: ActivatedRoute, private router: Router,
     private logincomponent: LoginComponent){
        this.userclass=userservice.currentUserValue;

  }
  
   

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
        cardno: ['',[Validators.required, Validators.minLength(3)]],
        cardname: ['', Validators.required],
        expdate: ['', Validators.required],
        cvv: ['', [Validators.required, Validators.minLength(3)]],
        
        
    });
  }
  startbooking() :void
  {
    
    this.userservice.getVehicleByLocation(this.location).subscribe((data : any) => 
    {
      this.uservehicleclass = data;
      this.showDetails = !this.showDetails ;
      console.log(this.uservehicleclass);});
     }
     get f() { return this.registerForm.controls; }
  onSubmit() {
    this.submitted = true;
    console.log('registration')
    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
  
    // display form values on success
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
    console.log('Payment Done');
    this.router.navigate(['/ride']);
}
selectvechicle(vehicle : Uservehicleclass) :void
  {
      console.log(vehicle);
      this.vehicleInfo = vehicle;
      console.log(this.userclass);
      this.fare = 63;
      this.userservice.calcfare(vehicle.vtype,this.location,this.dest).subscribe((data : any) =>{
          this.fare = data;
          console.log(this.fare);
      });
      this.vevh = vehicle ; 
      this.showDetails = !this.showDetails ;
      this.paymentDetails = !this.paymentDetails;
     

    
   
 }
 book() : void
 {
    this.payment = 
    {
        'pid': 'P001',
         'type': 'cash',
         'status': 'notstarted'
    }
    this.usernewBooking =  
    {
     'bid': 'auto',
     'destination': this.dest,
     'reg_date': 'auto',
     'source': this.location,
     'status': 'waitingfordriver',
     'payment': {
         'pid': this.payment.pid,
         'type': this.payment.type,
         'status': this.payment.status
     },
     'user': 
     {
         'cid': this.userclass.cid,
         'uname': this.userclass.uname,
         'uemail': this.userclass.uemail,
         'upass': this.userclass.upass,
         'uphnum': this.userclass.uphnum,
         'ugender': this.userclass.ugender,
         'uidproof': this.userclass.uidproof,
         'ucusrating': this.userclass.ucusrating,
         'current_Address': this.userclass.current_Address,
         'emgcontact': this.userclass.emgcontact,
         'permanent_Address': this.userclass.permanent_Address
     },

     'vehicle': {
         'vno':this.vevh.vno,
         'vtype':  this.vevh.vtype,
         'vstatus': 'booked',
         'vseats':this.vevh.vseats,
         'driver': {
             'did': this.vevh.driver.did,
             'dname': this.vevh.driver.dname,
             'dphno': this.vevh.driver.dphno,
             'dpass': this.vevh.driver.dpass,
             'daddrno': this.vevh.driver.daddrno,
             'drating': this.vevh.driver.drating,
             'drides': this.vevh.driver.drides,
             'current_Address': this.vevh.driver.current_Address,
             'dsalary': this.vevh.driver.dsalary,
             'dlicence': this.vevh.driver.dlicence,
             'permanent_Address': this.vevh.driver.permanent_Address,
              'demail' : this.vevh.driver.demail
         },
         'fare': this.fare
     }
    
 }
 console.log('Booking Info');
 console.log(this.usernewBooking);
 this.userservice.addbooking(this.usernewBooking).subscribe((res : any)=>{
     const id= res;
    
 },(err: any)=>{

     console.log(err);});
 }
 
}
