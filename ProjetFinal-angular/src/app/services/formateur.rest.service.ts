import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Formateur} from '../model/formateur';
import {Stagiaire} from "../model/stagiaire";

@Injectable({
  providedIn: 'root'
})
export class FormateurRestService {

  private url = 'http://localhost:8080/formateur';

  constructor(private http: HttpClient) { }

  public delete(formateur: Formateur): Observable<any> {
    return this.http
      .delete(this.url + '/' + formateur.id);
  }

  public findById(id: number): Observable<Formateur> {
    return this.http.get <Formateur>(this.url + '/' + id);
  }

  public save(formateur: Formateur): Observable<any> {
    // POST OU PUT
    if (formateur.id == null) {
      return this.http
        .post(this.url+ '/', formateur);
    } else {
      return this.http
        .put(this.url + '/' + formateur.id, formateur);
    }
  }

  public findAll(): Observable <Stagiaire[]> {
    return this.http.get <Formateur[]>(this.url);
  }
}
