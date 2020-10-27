import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bed } from '../bed';
import { BedServiceService } from '../bed-service.service';

@Component({
  selector: 'app-bed',
  templateUrl: './bed.component.html',
  styleUrls: ['./bed.component.css']
})
export class BedComponent implements OnInit {

  bed : Bed;

  constructor(private service:BedServiceService, private router:Router) { }

  ngOnInit(): void {
    this.bed = new Bed(null,null,true,null);
  }

  saveBed():void{
    console.log(this.bed);
    this.service.saveBed(this.bed).subscribe(Bed => this.bed = Bed);
    console.log(this.bed.bedSerialNumber + " saved successfully");
    this.router.navigate(["/view-beds"]);
  }

}
