import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IcuComponent } from './icu/icu.component';
import { BedComponent } from './bed/bed.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ViewBedComponent } from './view-bed/view-bed.component';
import { Icu1Component } from './icu1/icu1.component';
import { Icu2Component } from './icu2/icu2.component';
import { VitalsComponent } from './vitals/vitals.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { PatientListComponent } from './patient-list/patient-list.component';

@NgModule({
  declarations: [
    AppComponent,
    IcuComponent,
    BedComponent,
    ViewBedComponent,
    Icu1Component,
    Icu2Component,
    VitalsComponent,
    CreatePatientComponent,
    PatientListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
