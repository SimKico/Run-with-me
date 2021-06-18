import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { Cooper } from 'src/app/core/model/cooper';
import { NotificationService } from 'src/app/core/services/notification.service';
import { RunnerService } from 'src/app/core/services/runner.service';

@Component({
  selector: 'app-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css']
})
export class TypographyComponent implements OnInit {
 
  form: FormGroup;
  loading: boolean;

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
      distance: new FormControl('1200', [Validators.required, Validators.min(0),Validators.max(10000)])
      });
  }

  enterData() {
    this.loading = true;
    const cooper = new Cooper(this.form.get("distance").value);
    console.log(cooper);

    this.runnerService.enterCooper(cooper)
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
