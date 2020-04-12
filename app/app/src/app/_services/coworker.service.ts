import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/coworker';

@Injectable({
  providedIn: 'root'
})
export class CoworkerService {

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

  getArtists(id: number) : Observable<any>{
    return this.http.get<any>(API_URL + `/getColleagues/${id}`);
  }

  addGraniteOrder(model: any) : Observable<void>{
    const requestURL = API_URL + '/createGraniteOrder'
    return this.http.post<void>(requestURL, model);
  }
  getCoworkers(): Observable<any>{
    return this.http.get<any>(API_URL + `/get`);
  }
}
