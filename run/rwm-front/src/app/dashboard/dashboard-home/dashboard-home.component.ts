import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'src/app/core/services/notification.service';
import { Title } from '@angular/platform-browser';
import { NGXLogger } from 'ngx-logger';
import { AuthenticationService } from 'src/app/core/services/auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-dashboard-home',
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.css']
})
export class DashboardHomeComponent implements OnInit {
  currentUser: any;
  injury : string = "NA";

  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private notificationService: NotificationService,
    private authService: AuthenticationService,
    private titleService: Title,
    private logger: NGXLogger,
    private http: HttpClient) {
  }

  ngOnInit() {
    this.currentUser = this.authService.getCurrentUser();
    this.titleService.setTitle('angular-material-template - Dashboard');
    this.logger.log('Dashboard loaded');

    // setTimeout(() => {
    //   this.notificationService.openSnackBar('Welcome!');
    // });
 
  }
  selected = new FormControl(this.injury);
  send(injury:string): Observable<any> {
    console.log(this.injury);
    return this.http.get('http://localhost:8080/injuries/get/{BROKEN_LEG}')
    .pipe(map((response) => {console.log("response")}));

  }
}
