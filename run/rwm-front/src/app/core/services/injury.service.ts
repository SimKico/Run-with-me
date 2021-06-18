import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Injury } from '../model/injury';

@Injectable({
  providedIn: 'root'
})
export class InjuryService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private httpClient: HttpClient) { }

addInjury(injury : Injury){
  console.log("addInjury");
  console.log(injury);
  return this.httpClient.post('http://localhost:8080/injuries/add',injury);
}

  test(){
    console.log("test");
    return this.httpClient.get("http://localhost:8080/injuries/test");
  }

}
