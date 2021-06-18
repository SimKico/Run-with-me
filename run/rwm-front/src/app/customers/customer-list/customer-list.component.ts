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
    const raceDate = new Cooper(this.form.get("raceDate").value);
    console.log(raceDate);
    console.log(this.timeGoal);
    const raceData = new Race("2021-09-10T21:34:33.616Z", "Derventa", this.timeGoal);

    this.runnerService.enterRace(raceData)
      .subscribe(
        results => {
          console.log("here");
          this.router.navigate(['/newRace']);
          this.notificationService.openSnackBar('Your data is successfully saved.');
        },
        error => {
          this.loading = false;
          this.notificationService.openSnackBar(error.error);
        }
      );
  }
}
