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
  checkBpm(bpm){
    if(this.vitals.bpm < 70)
    window.alert("BPM too Low");
    else if(this.vitals.bpm > 150)
    window.alert("BPM too High");
    else{
      window.alert("BPM is normal")
    }
  }

  checkSpo2(spo2){
    if(this.vitals.spo2 < 90)
    window.alert("spo2 too Low");
    else{
      window.alert("spo2 is normal")
    }
  }

  checkRespRate(respRate){
    if(this.vitals.respRate < 30)
    window.alert("respRate too Low");
    else if(this.vitals.respRate > 90)
    window.alert("respRate too high");
    else{
      window.alert("respRate is normal")
    }
  }

}
