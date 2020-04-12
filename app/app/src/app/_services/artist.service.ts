import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/artist';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http: HttpClient) { }


  addCoworker(artistId: number, coworkerId: number) : Observable<void>{
    const requestURL = API_URL + `/addCoworker/${artistId}/${coworkerId}`
    return this.http.get<void>(requestURL);
  }

}
