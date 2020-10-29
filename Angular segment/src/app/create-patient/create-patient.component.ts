import { Component, OnInit,Input } from '@angular/core';


import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {
  [x: string]: any;
  
 
  @Input() patientDetails = { name: '', age: '', phoneNumber: 0, bedId: 0 }

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
    });
  }

  addPatient(data: any) {
    console.log(data)
   this.http.post(this.url, {
      name: data.name,
      age: data.age,
      phoneNumber: data.phoneNumber,
      bed: {
        bedId: data.bedId
      }
    }).toPromise().then((data:any) => {
      
      this.loadPatient();
   
    }) }
  
    }
  

    
