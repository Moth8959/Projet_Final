import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Salle} from '../model/salle';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SalleRestService {
  private mat1: Salle;
  private url = 'http://localhost:8080/salle';

  constructor(private http: HttpClient) { }

  public delete(salle: Salle): Observable<any> {
    return this.http
      .delete(this.url + '/' + salle.code);


  }

  public findByCode(code: string): Observable<Salle> {
    return this.http.get <Salle>(this.url + '/' + code);
  }

  public save(salle: Salle): Observable<any> {
    // POST OU PUT
    if (salle.code == null) {
      return this.http
        .post(this.url + '/', salle);
    } else {
      return this.http
        .put(this.url + '/' + salle.code, salle);
    }
  }

  public findAll(): Observable <Salle[]> {
    return this.http.get <Salle[]>(this.url);
  }

}
