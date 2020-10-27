import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-icu',
  templateUrl: './icu.component.html',
  styleUrls: ['./icu.component.css']
})
export class IcuComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  myimage:string = "assets/img/icu-logo.png";
}
