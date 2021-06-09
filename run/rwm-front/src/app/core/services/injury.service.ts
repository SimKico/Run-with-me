import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Injury } from '../model/injury';

@Injectable({
  providedIn: 'root'
})
export class InjuryService {

  constructor(private httpClient: HttpClient) { }

addInjury(injury : Injury) : Observable<any>{
  console.log("addInjury");
  console.log(injury);
  return this.httpClient.post<any>('http://localhost:8080/injuries/add', {dateOfInjury: "2021-06-03T21:34:33.616Z", injuryType: 1});
}

  test(){
    console.log("test");
    return this.httpClient.get("http://localhost:8080/injuries/test");
  }

}
