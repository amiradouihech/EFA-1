import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  c = false;
  loginError = '';

  constructor(private formBuilder: FormBuilder, private loginService: LoginService) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit() {
    this.c = true;
    if (this.loginForm.valid) {
      this.loginService.login(this.loginForm.value).subscribe(
        (rep: any) => {
          if (rep.status) {
            console.log("logged in successfully");
          } else {
            this.loginError = "email or password is invalid";
          }
        },
        (error) => {
          console.log("An error occurred:", error);
        }
      );
    }
  }
}
