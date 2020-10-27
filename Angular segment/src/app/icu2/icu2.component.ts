import { Component, OnInit } from '@angular/core';
import{Bed} from '../bed';
import{BedServiceService} from '../bed-service.service';


@Component({
  selector: 'app-icu2',
  templateUrl: './icu2.component.html',
  styleUrls: ['./icu2.component.css']
})
export class Icu2Component implements OnInit {

  beds : Bed[];
  constructor(private bedservice: BedServiceService) { }

  ngOnInit(): void {
    this.getBeds();
  }
  getBeds() : void {
    this.bedservice.getBeds().subscribe((data: Bed[]) =>{
      console.log(data);
      this.beds = data;
    });
  }

  myimage:string = "assets/img/bed-logo.png";
}
