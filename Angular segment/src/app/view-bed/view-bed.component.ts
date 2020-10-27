import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Bed } from '../bed';
import { BedServiceService } from '../bed-service.service';
import{HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-bed',
  templateUrl: './view-bed.component.html',
  styleUrls: ['./view-bed.component.css']
})
export class ViewBedComponent implements OnInit {

  
  beds : Bed[];
  bed : Bed;
  constructor(private bedservice: BedServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getBeds();
  }
  getBeds() : void {
    this.bedservice.getBeds().subscribe((data: Bed[]) =>{
      console.log(data);
      this.beds = data;
    });
  }
  

    deleteBed(bedId : any) : void {
      if(confirm("Are you sure you wanna delete" + bedId + "?")){
        this.bedservice.deleteBed(bedId).subscribe(response => {
          alert(response.bedSerialNumber);
          this.bedservice.getBeds();
          this.router.navigate(["/view-beds"]);
        })
    }
}


}
