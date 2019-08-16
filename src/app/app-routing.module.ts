import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { LoginComponent } from './login/login.component';
import { UsernewbookingComponent } from './usernewbooking/usernewbooking.component';
import { SignupComponent} from './signup/signup.component';
import { UserpaymentComponent } from './userpayment/userpayment.component';
import { RideComponent } from './ride/ride.component';
import { DriverloginComponent } from './driverlogin/driverlogin.component';
import { UserprofileeditComponent } from './userprofile/userprofileedit/userprofileedit.component';
import { UserprofileviewComponent } from './userprofile/userprofileview/userprofileview.component';
 

const routes: Routes = [{path: 'userprofile', component: UserprofileComponent },
                        {path: 'login', component: LoginComponent },
                        {path: 'userbooking', component: UsernewbookingComponent }, 
                        {path: 'signup', component: SignupComponent },
                        {path: 'payment', component: UserpaymentComponent },
                        {path: 'ride', component: RideComponent },
                        {path: 'driverlogin', component: DriverloginComponent },
                        {path: 'profile', component: UserprofileviewComponent },
                        {path: 'editprofile', component: UserprofileeditComponent },
                        {path: '**',component: UsernewbookingComponent  }
                         ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
