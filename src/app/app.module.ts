import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { UserbookinghistoryComponent } from './userbookinghistory/userbookinghistory.component';
import { UsernewbookingComponent } from './usernewbooking/usernewbooking.component';
import { UserhelpdeskComponent } from './userhelpdesk/userhelpdesk.component';
import { UserprofileviewComponent } from  './userprofile/userprofileview/userprofileview.component';
import { UserprofileeditComponent } from './userprofile/userprofileedit/userprofileedit.component';
import { UserprofiledeleteComponent } from './userprofile/userprofiledelete/userprofiledelete.component';
import { UserbookinghistoryviewComponent } from './userbookinghistory/userbookinghistoryview/userbookinghistoryview.component';
import { UserhelpdeskaddcomplaintComponent } from './userhelpdesk/userhelpdeskaddcomplaint/userhelpdeskaddcomplaint.component';
import { UserhelpdeskviewcomplaintComponent } from './userhelpdesk/userhelpdeskviewcomplaint/userhelpdeskviewcomplaint.component';
import { userservice } from './userservice.service';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
import { FormsModule, FormGroup, Validators  } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UserpaymentComponent } from './userpayment/userpayment.component';
import { RideComponent } from './ride/ride.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DriverloginComponent } from './driverlogin/driverlogin.component';
import { DriverprofileComponent } from './driverprofile/driverprofile.component';
 

@NgModule({
  declarations: [
    AppComponent,
    UserprofileComponent,
    UserbookinghistoryComponent,
    UsernewbookingComponent,
    UserhelpdeskComponent,
    UserprofileviewComponent,
    UserprofileeditComponent,
    UserprofiledeleteComponent,
    UserbookinghistoryviewComponent,
    UserhelpdeskaddcomplaintComponent,
    UserhelpdeskviewcomplaintComponent,
    LoginComponent,
    SignupComponent,
    UserpaymentComponent,
    RideComponent,
    DriverloginComponent,
    DriverprofileComponent,
     
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
     
  ],
  providers: [userservice,LoginComponent,DriverloginComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
