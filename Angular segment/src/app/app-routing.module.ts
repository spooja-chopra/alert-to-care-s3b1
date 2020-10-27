import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BedComponent } from './bed/bed.component';
import { IcuComponent } from './icu/icu.component';
import { Icu1Component } from './icu1/icu1.component';
import { Icu2Component } from './icu2/icu2.component';
import { ViewBedComponent } from './view-bed/view-bed.component';
import { VitalsComponent } from './vitals/vitals.component';

const routes: Routes = [
  {path:"", redirectTo:"icu",pathMatch:"full"},
  {path:"add-bed", component : BedComponent},
  {path:"view-beds", component : ViewBedComponent},
  {path:"icu", component : IcuComponent},
  {path:"icu/icu1", component : Icu1Component},
  {path:"icu/icu2", component : Icu2Component},
  {path:"vitals", component : VitalsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
