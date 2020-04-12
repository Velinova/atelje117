import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class MyCoworkersService {
  apiUrl: string = "http://localhost:8080/artist"
  constructor(
    private http: HttpClient
  ) {
  }

  getDatatable(id:number): Observable<any> {
   const requestUrl = `${this.apiUrl}/getCoworkers/${id}`;
   return this.http.get<any>(requestUrl);
  }

  deleteCoworker(ArtistId: number, CoworkerId: number): Observable<void>{
    const requestUrl = `${this.apiUrl}/deleteCoworker/${ArtistId}/${CoworkerId}`;
    return this.http.get<any>(requestUrl);

  }

  //getById(id: string): Observable<any> {
  //  const url = `${this.apiUrl}/${id}`;
  //  return this.http.get<any>(url);
  //}

  //create(model: any): Observable<any> {
  //  const url = `${this.apiUrl}`;
  //  return this.http.post<any>(url, model);
  //}

  //update(model: any): Observable<any> {
  //  const url = `${this.apiUrl}/update`;
  //  return this.http.post<any>(url, model);
  //}

  //delete(id: any): Observable<any> {
  //  const url = `${this.apiUrl}/delete`;
  //  return this.http.post<any>(url, model);
  //}
}
