import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // getPublicContent(): Observable<any> {
  //   return this.http.get(API_URL + '/all', { responseType: 'text' });
  // }
  //
  // getModeratorBoard(): Observable<any> {
  //   return this.http.get(API_URL + '/mod', { responseType: 'text' });
  // }
  //
  // getAdminBoard(): Observable<any> {
  //   return this.http.get(API_URL + '/admin', { responseType: 'text' });
  // }

  getUser(userId: number) : Observable<any>{
    return this.http.get<any>(API_URL + `/details/${userId}`);
  }
}
