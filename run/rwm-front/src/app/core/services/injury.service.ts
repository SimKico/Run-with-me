import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Injury } from '../model/injury';

@Injectable({
  providedIn: 'root'
})
export class InjuryService {

  constructor(private httpClient: HttpClient) { }

addInjury(injury : Injury) : Observable<Injury>{
  console.log("addInjury");
  console.log(injury);
  return this.httpClient.post<Injury>('http://localhost:8080/injuries/add', injury);
}

}
