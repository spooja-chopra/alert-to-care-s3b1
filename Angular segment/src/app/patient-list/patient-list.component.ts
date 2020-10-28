
import { Component, OnInit } from '@angular/core';

import { Observable, throwError } from "rxjs";

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  private url = 'http://localhost:8081/api/v1/patients';
  items = [];
  router: any;

  
  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
    ngOnInit() {
      this.loadPatient()
    }
    // Get patient list
    loadPatient() {
  
      this.http.get(this.url).toPromise().then(data => {

        for(let key in data){
          //console.log(data[key])
          this.items.push(data[key]);
        }
        console.log(data);
      });
    }
    // Delete patient
    deletePatient(id: number) {
      if (window.confirm('Are you sure, you want to delete?')){
        return this.http.delete(this.url+'/'+ id).subscribe(data => {
          this.loadPatient()
        })
      }
      
        
      }
   
         updatePatient(id: number){
      this.router.navigate(['update', id]);
         }
    
      handleError(error) {
        let errorMessage = '';
        if(error.error instanceof ErrorEvent) {
          // Get client-side error
          errorMessage = error.error.message;
        } else {
          // Get server-side error
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
     }
  
}

