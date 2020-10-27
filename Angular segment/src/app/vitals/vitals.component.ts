import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { Vitals } from '../vitals';

@Component({
  selector: 'app-vitals',
  templateUrl: './vitals.component.html',
  styleUrls: ['./vitals.component.css']
})
export class VitalsComponent implements OnInit {

  vitals : Vitals;

  constructor() { }

  ngOnInit(): void {
    this.vitals = new Vitals(null,null,null);
  }

  // checkVitals(formData){
  //   console.log(formData);
  //   this.url = "http://localhost:8081/monitor"

  // }
  // this.http.post(this.url, {
  //   spo2 : FormData.spo2,
  //   respRate : FormData.respRate,
  //   bpm : FormData.bpm
  // }).toPromise().then(data : any) => {
  //   let flag = false;
  //   data.forEach((value, index) => {
  //     var str = value.errorMessage.split(" ");
  //     if(str[2] != "normal"){
  //       flag = true;
  //       window.alert("Alert the doctor :" + value.errorMessage);
  //     }
  //   });
  //   if(!flag){
  //     window.alert("All Vitals are normal");
  //   }
  // }

  checkVitals(vitals){
    if(vitals.bpm < 70)
    window.alert("BP too Low");
    if(vitals.bpm > 150)
    window.alert("BP too High");
    if(vitals.spo2 < 90)
    window.alert("spo2 too Low");
    if(vitals.respRate < 30)
    window.alert("respRate too Low");
    if(vitals.respRate > 90)
    window.alert("respRate too high");

    if((vitals.bpm<150 && vitals.bpm >70) && (vitals.spo2>90) && (vitals.respRate<90 && vitals.respRate >30)){
      window.alert("Vitals are normal");
    }

  }
}
