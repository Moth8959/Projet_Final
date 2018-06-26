import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Videoprojecteur} from '../model/videoprojecteur';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class VideoprojecteurRestService {

  private url = 'http://localhost:8080/videoprojecteur';

  constructor(private http: HttpClient) { }

  public delete(videoprojecteur: Videoprojecteur): Observable<any> {
    return this.http
      .delete(this.url + '/' + videoprojecteur.code);


  }

  public findByCode(code: string): Observable<Videoprojecteur> {
    return this.http.get <Videoprojecteur>(this.url + '/' + code);
  }

  public save(videoprojecteur: Videoprojecteur): Observable<any> {
    // POST OU PUT
    if (videoprojecteur.code == null) {
      return this.http
        .post(this.url + '/', videoprojecteur);
    } else {
      return this.http
        .put(this.url + '/' + videoprojecteur.code, videoprojecteur);
    }
  }

  public findAll(): Observable <Videoprojecteur[]> {
    return this.http.get <Videoprojecteur[]>(this.url);
  }

}
