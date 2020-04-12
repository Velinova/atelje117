import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  form: any;
  isSuccessful: boolean;
  isSignUpFailed: boolean;
  errorMessage: string;

  constructor(private authService: AuthService) {
    this.form = {
      role: '0'
    };
    this.isSuccessful = false;
    this.isSignUpFailed = false;
    this.errorMessage = '';
  }

  ngOnInit() {
  }

  onSubmit() {
    this.authService.register(this.form).subscribe(
      data => {
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
