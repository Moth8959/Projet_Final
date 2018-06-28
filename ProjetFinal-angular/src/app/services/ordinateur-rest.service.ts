import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Ordinateur} from '../model/ordinateur';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class OrdinateurRestService {

  private url = 'http://localhost:8080/ordinateur';

  constructor(private http: HttpClient) { }

  public delete(ordinateur: Ordinateur): Observable<any> {
    return this.http
      .delete(this.url + '/' + ordinateur.code);


  }

  public findByCode(code: string): Observable<Ordinateur> {
    return this.http.get <Ordinateur>(this.url + '/' + code);
  }

  public save(ordinateur: Ordinateur): Observable<any> {
    // POST OU PUT
    if (ordinateur.code == null) {
      return this.http
        .post(this.url + '/', ordinateur);
    } else {
      return this.http
        .put(this.url + '/' + ordinateur.code, ordinateur);
    }
  }

  public findAll(): Observable <Ordinateur[]> {
    return this.http.get <Ordinateur[]>(this.url);
  }

}
