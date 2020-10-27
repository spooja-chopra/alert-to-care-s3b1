import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bed } from './bed';


@Injectable({
  providedIn: 'root'
})
export class BedServiceService {

  private baseUrl = "http://localhost:8081/beds";

  constructor(private http:HttpClient) { 

  }

  getBeds():  Observable<Bed[]>{
    return this.http.get<Bed[]>(`${this.baseUrl}`);
  }

  saveBed(bed : Bed) : Observable<Bed> {
    return this.http.post<Bed>(this.baseUrl, bed);
  }

  deleteBed(bedId) : Observable<Bed>{
    return this.http.delete<Bed>(`${this.baseUrl}` +"/"+ bedId);
  }
}

