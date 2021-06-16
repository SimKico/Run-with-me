import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { BasicRunnerData } from '../model/basicRunnerData';

@Injectable({
  providedIn: 'root'
})
export class RunnerService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient,
    @Inject('LOCALSTORAGE') private localStorage: Storage) {
  }

  addRunnerData(basicRunnerData: BasicRunnerData) {
    return this.http.post(`${environment.baseUrl}/${environment.runnerData}`, basicRunnerData, { headers: this.headers, responseType: 'json' })
      .pipe(map((response) => {
        console.log(response);
      }));
  }
}




