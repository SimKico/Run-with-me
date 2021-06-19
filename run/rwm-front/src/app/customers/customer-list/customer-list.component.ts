import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NGXLogger } from 'ngx-logger';
import { Title } from '@angular/platform-browser';

import { NotificationService } from '../../core/services/notification.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cooper } from 'src/app/core/model/cooper';
import { RunnerService } from 'src/app/core/services/runner.service';
import { race } from 'rxjs';
import { Race } from 'src/app/core/model/race';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
  { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
  { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
  { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
  { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
  { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
  { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
  { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
  { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
  { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
];

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
   form: FormGroup;
   loading: boolean;
   timeGoal : String;
   link : String;

  constructor(
    private router: Router,
    private logger: NGXLogger,
    private notificationService: NotificationService,
    private titleService: Title,
    private runnerService : RunnerService
  ) { }

  ngOnInit() {
    this.titleService.setTitle('Runner Basic Data');
    this.form = new FormGroup({
      raceDate: new FormControl('', [Validators.required]),
      // timeGoal: new FormControl('', [Validators.required])
      });
  }

  enterData() {
    this.loading = true;
    const raceDate = this.form.get("raceDate").value;
    const date = new Date(raceDate);
    const username = localStorage.getItem("username");
    const raceData = new Race(username, date.toISOString(), "Derventa", this.timeGoal);

    this.runnerService.enterRace(raceData)
      .subscribe(
        results => {
          console.log("here");
          this.loading = false;
          console.log(results);
          if(results === "nan") {this.notificationService.openSnackBar('We do not have special program for you.');}
          if(results === "STARTER_WEEK_8_TO_12"){this.link = 'https://www.hbffitness.com.au/app/uploads/2015/03/HBF11234-RFAR-8-week-Training-Guide-2015_21km-Advanced-Run.pdf';}//8advanced
          if(results === "ADVANCED_WEEK_8_TO_12"){this.link = 'https://www.personaltraineroxford.com/uploads/files/YOURFIRSTHALFMARATHONPLAN-1.pdf';}//8 starter
          if(results === "STARTER_WEEK_13_TO_16"){this.link = 'https://www.halhigdon.com/wp-content/uploads/2018/04/Novice-1-Half-Marathon-Printable.pdf';}//12 starter
          if(results === "ADVANCED_WEEK_13_TO_16"){this.link = 'https://www.halhigdon.com/wp-content/uploads/2018/04/Advanced-Half-Marathon-Printable.pdf';}//12 advenced
          
          if(results === "STARTER_WEEK_17_TO_24"){this.link = 'https://content.nike.com/content/dam/one-nike/en_lu/HO16/Running/NRC-trainingplans/PDFs/nike-run-club-marathon-en_LU.pdf';}//18 starter
          if(results === "ADVANCED_WEEK_17_TO_24"){this.link = 'https://melbournemarathon.com.au/wp-content/uploads/2019/07/APAC-Half-Marathon-Run-Guide-Beg-Int-2019-KM.pdf';}//18 advenced
          this.notificationService.openSnackBar('Your data is successfully saved.');
        },
        error => {
          this.loading = false;
          
          console.log("false");
          this.notificationService.openSnackBar(error.error);
        }
      );
  }
}
