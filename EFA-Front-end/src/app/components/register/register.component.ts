import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder,FormGroup,Validators,} from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { DropdownModule } from 'primeng/dropdown';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registrationForm: FormGroup;
  c = false;

  constructor(private formBuilder: FormBuilder) {
    this.registrationForm = this.formBuilder.group({
      nom: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      prenom: ['', [Validators.required, Validators.pattern(/^[a-zA-Z]+$/)]],
      role: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }





  onSubmit() {
    this.c = true;
    this.registerUser();
  }

  onReset() {
    this.c = false;
    this.registrationForm.reset();
  }

  registerUser() {
    if (this.registrationForm.valid) {
      console.log(this.registrationForm.value);
    }
  }
}
