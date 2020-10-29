
import { Component, OnInit } from '@angular/core';

import { Observable, throwError } from "rxjs";

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  private url = 'http://localhost:8081/patients';
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
    loadPatient() {
  
      this.http.get(this.url).toPromise().then(data => {

        for(let key in data){
          this.items.push(data[key]);
        }
        console.log(data);
      });
    }
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
          errorMessage = error.error.message;
        } else {
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
     }
  
}

