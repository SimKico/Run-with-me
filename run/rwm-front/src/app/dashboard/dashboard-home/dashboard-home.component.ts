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
import { InjuryService } from 'src/app/core/services/injury.service';
import { Injury } from 'src/app/core/model/injury';
import { Router } from '@angular/router';

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
    private router: Router,
    private titleService: Title,
    private logger: NGXLogger,
    private injuryService : InjuryService,
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
  
  addInjury(injury:string): void {
    console.log(this.injury);
    const date = new Date();
    console.log(date.toISOString());
    const username = localStorage.getItem("username");
    const selectedInjury = new Injury(username ,date.toISOString(), this.injury);
    console.log(selectedInjury);
   
    this.injuryService.addInjury(selectedInjury)
    .subscribe(
      results => {
        console.log("here");
        // this.router.navigate(['/addRace']);//to do - to program
        this.notificationService.openSnackBar('You can continue with preparation.');//mozda da prebaci na neki sajt sa povredama, ili da ubacim neke vjezbice u zavisnosti koja je povreda
      },
      error => {
        console.log("error");
        this.notificationService.openSnackBar(error.error);
      }
    );
  }

  test(){
    this.injuryService.test().subscribe(result => {console.log(result);});
  }
}
