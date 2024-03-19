import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {}
  private url="http://localhost:8081/api/user/login"
  login(userData: any): Observable<any> {
    return this.http.post(this.url, userData);
  }
}
