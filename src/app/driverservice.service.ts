import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { Driverclass } from './driverclass';
import { catchError, tap, map } from 'rxjs/operators';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class DriverserviceService {
  constructor(private _http: HttpClient) { 
  }

  driverlogin(demail: string, dpass: string):Observable<Driverclass>{
    console.log('service called');  
    const lurl = `http://localhost:8085/SpringRest/drivers/driverlogin/${demail}/${dpass}`;
    return this._http.get<Driverclass>(lurl)
    .pipe(tap(_ => console.log(`logged in as=${demail}`)),
    catchError(this.handleError<Driverclass>(`get user id=${demail}`))
  );
}
private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

   
    console.error();
    (error); return of(result as T);
  };


}
}