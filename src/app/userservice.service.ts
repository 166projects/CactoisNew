import { Injectable } from '@angular/core';
import { Userhelpdeskclass } from './userhelpdeskclass';
import { Userbookingclass } from './userbookingclass';
import { Userclass } from './userclass';
import { of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Uservehicleclass } from './uservehicleclass';
import { Userpaymentclass } from './userpaymentclass';
import {BehaviorSubject,Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class userservice
{
   
  private currentUserSubject :  BehaviorSubject<Userclass>;

  public currentUser : Observable<Userclass>;

 
  constructor(private _http: HttpClient) { 
    this.currentUserSubject=new BehaviorSubject<Userclass>(JSON.parse(localStorage.getItem('currentUser')));

    this.currentUser=this.currentUserSubject.asObservable();
  }

  public get currentUserValue():Userclass{

    return this.currentUserSubject.value;

  }

  logout(){

    localStorage.removeItem('currentUser');
  
    this.currentUserSubject.next(null);
  
  }
  calcfare(type : string,src : string,dest : string):Observable<number>
  {
    console.log("fare");
    return this._http.get<number>(`http://localhost:8085/SpringRest/user/fare/${type}/${src}/${dest}`,httpOptions)
    .pipe(tap( _=> console.log('calculated fare')),
  catchError(this.handleError<number>('Invalid'))
);
  }

  getUsersById(cid:String):Observable<Userclass>{
    
    return this._http.post<Userclass>(`http://localhost:8089/SpringRest/user/userbyid/${cid}`, cid,
    httpOptions).pipe(
      tap( _=> console.log(`Fetched User id=${cid}`)),  
     catchError(this.handleError<Userclass>(`Get User By id=${cid}`))
    );
    }
  addCompplaint(helpdesk: Userhelpdeskclass):Observable<any>
   {
     return this._http.post<void>('http://localhost:8089/SpringRest/user/addcomplaint', helpdesk, 
    httpOptions).pipe(
      tap( _=> console.log(`added Userhelpdeskclass id=${helpdesk.hid}`)),
      catchError(this.handleError<Userhelpdeskclass>('Add Complaint'))
    );
   }
   
   addbooking(booking: Userbookingclass):Observable<Userbookingclass>
   {
     console.log("Service BOKING called");
     const url1= 'http://localhost:8085/SpringRest/user/addbooking';
     const url2= `${url1}`;
     console.log(booking)
    return this._http.post<Userbookingclass>(url1, booking,
     httpOptions).pipe(
      tap( _=> console.log(`added Userbookingclass id=${booking.bid}`)),  
     catchError(this.handleError<Userbookingclass>('Add booking'))
     );
    }

   updatebooking(booking: Userbookingclass):Observable<any>
   {
     return this._http.put<void>(`http://localhost:8089/SpringRest/user/updatebooking`,booking,
     httpOptions).pipe(tap( _=> console.log(`added Userbookingclass id=${booking.bid}`)), 
     catchError(this.handleError<Userbookingclass>('Update booking'))
     );
    }

   updateUser(user: Userclass):Observable<any>
   {console.log('updated service called');
   
    return this._http.put<void>(`http://localhost:8089/SpringRest/user/userupdate`,user, httpOptions)
    .pipe(tap( _=> console.log(`added Userclass id=${user.cid}`)),  
    catchError(this.handleError<Userbookingclass>('Update user'))
   );
   }

   deleteUser(cid:String): Observable<any>{
    return this._http.delete<void>(`http://localhost:8089/SpringRest/user/userdelete/${cid}`,
    httpOptions).pipe(
      tap( _=> console.log(`deleted Userclass id=${cid}`)),  
     catchError(this.handleError<Userbookingclass>('Delete User '))
    );
    }
  //   const lurl=`${url1}/${email}/${password}`;

  //   return this._http.get<User>(lurl)
  
  //   .pipe(tap(user => {
  
  //     localStorage.setItem('currentPassenger',JSON.stringify(user));
  
  //     this.currentUserSubject.next(user);
  
  //   return user;}),
  
  //   catchError(this.handleError<User>(`getProduct id=${email}`))
  
  // );
    login(uemail: string, upass: string):Observable<Userclass>{
      console.log('service called');  
      const lurl = `http://localhost:8085/SpringRest/user/userlogin/${uemail}/${upass}`;
      return this._http.get<Userclass>(lurl)
      .pipe(tap(userclass  =>{
  
             localStorage.setItem('currentPassenger',JSON.stringify(userclass));
        
             this.currentUserSubject.next(userclass);
        
           return Userclass;} ),
      catchError(this.handleError<Userclass>(`get user id=${uemail}`))
    );
  }

changepassword(cid:String,oldpass:String,newpass:String) : Observable<any>
{
  return this._http.put<void>
  (`http://localhost:8089/SpringRest/user/userchangepassword/${cid}/${oldpass}/${newpass}`,
  httpOptions).pipe(
    tap( _=> console.log(`Changed  Password id=${cid}`)),  
   catchError(this.handleError<Userbookingclass>('Change Password '))
  );
  }
  
  signup(user:Userclass) : Observable<Userclass>
  {
    console.log('service called');  
    return this._http.post<Userclass>('http://localhost:8089/SpringRest/user/usersignup', user,
    httpOptions).pipe(
      tap( _=> console.log(`User  Signed Up id=${user.cid}`)),  
     catchError(this.handleError<Userclass>('Sign Up '))
    );
    }
    
  
   
    
  //   getUsersByName(): Observable<Userclass[]> {
  //     return this._http.get<Userclass[]>(`http://localhost:8089/SpringRest/user/userbyname/{uname}`)
  //     .pipe(
  //     tap(product => console.log('Fetched Users')),
  //     catchError(this.handleError('get Users By Name', []))
  //     );
  // }


  getVehicleByLocation(current_location : String): Observable<Uservehicleclass[]> {
    return this._http.get<Uservehicleclass[]>(`http://localhost:8085/SpringRest/user/vehicleLoc/${current_location}`)
    .pipe(
    tap(product => console.log('Fetched Vehicles')),
    catchError(this.handleError('get Vehicles By Location', []))
    );
}

getVehicleByType(): Observable<Uservehicleclass[]> {
  return this._http.get<Uservehicleclass[]>(`http://localhost:8085/SpringRest/user/vehicleLoc/{current_location}`)
  .pipe(
  tap(product => console.log('Fetched Vehicles')),
  catchError(this.handleError('get Vehicles By Type', []))
  );
}

getAllVehicles(): Observable<Uservehicleclass[]> {
  return this._http.get<Uservehicleclass[]>('http://localhost:8085/SpringRest/user/allvehicles')
  .pipe(
  tap(product => console.log('Fetched Vehicles')),
  catchError(this.handleError('get All Vehicles', []))
  );
}

addPayment(payment: Userpaymentclass):Observable<any>
{
  return this._http.post<void>('http://localhost:8085/SpringRest/user/addPayment', payment, 
 httpOptions).pipe(
   tap( _=> console.log(`added Userpaymentclass id=${payment.pid}`)),
   catchError(this.handleError<Userpaymentclass>('Add payment'))
 );
}

updatepayment(payment: Userpaymentclass):Observable<any>
{
  return this._http.put<void>('http://localhost:8085/SpringRest/user/updatepayment', payment, 
 httpOptions).pipe(
   tap( _=> console.log(`added Userpaymentclass id=${payment.pid}`)),
   catchError(this.handleError<Userpaymentclass>('Update payment'))
 );
}

private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

   
    console.error();
    (error); return of(result as T);
  };
}

}
