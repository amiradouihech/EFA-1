import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registrationForm: FormGroup;
  c = false;

  constructor(private formBuilder: FormBuilder, private registrationService: RegistrationService) {
    this.registrationForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      role: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    this.c = true;
    if (this.registrationForm.valid) {
      this.registrationService.registerUser(this.registrationForm.value)
        .subscribe(
          (rep: any) => {
            if (rep.status) {
              console.log("User added");
              this.registrationForm.reset();
            } else {
              console.log('user already exists');
            }
          },
          (error) => {
            console.error("error", error);
          }
        );
    }
  }

  onReset() {
    this.c = false;
    this.registrationForm.reset();
  }
}
