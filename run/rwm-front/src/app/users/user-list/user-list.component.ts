import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { NotificationService } from '../../core/services/notification.service';
import { NGXLogger } from 'ngx-logger';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';
import { RunnerService } from 'src/app/core/services/runner.service';
import { BasicRunnerData } from 'src/app/core/model/basicRunnerData';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  private years: number;
  private weight: number;
  private height: number;
  form: FormGroup;
  loading: boolean;
  gender : string = "FEMALE";
  selected = new FormControl(this.gender);

  constructor(
    private router: Router,
    private logger: NGXLogger,
    private notificationService: NotificationService,
    private titleService: Title,
    private runnerService : RunnerService
  ) {}


  ngOnInit() {
    this.titleService.setTitle('Runner Basic Data');
    this.form = new FormGroup({
      years: new FormControl('24', [Validators.required, Validators.min(17),Validators.max(60)]),
      height:  new FormControl('172', [Validators.required, Validators.min(120),Validators.max(250)]),
      weight : new FormControl('65', [Validators.required, Validators.min(40),Validators.max(200)]),  
      });

  }

  enterData() {
    this.loading = true;
    const runnerData = new BasicRunnerData(this.form.get("years").value, this.form.get("height").value, this.form.get("weight").value, this.gender);
    console.log(runnerData);
    // runnerData.years = this.years;
    // runnerData.weight = this.weight;
    // runnerData.height =  this.height;
    // runnerData.gender = this.gender;

    this.runnerService.addRunnerData(runnerData)
      .subscribe(
        results => {
          console.log("here");
          localStorage.setItem("isEnteredBasicData", "true");
          this.router.navigate(['/cooper']);
          this.notificationService.openSnackBar('Your data are saved.');
        },
        error => {
          this.loading = false;
          this.notificationService.openSnackBar(error.error);
        }
      );
  }

  cancel() {
    console.log("cancel")
    // this.router.navigate(['/']);
  }
}
