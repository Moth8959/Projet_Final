import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Formateur} from '../model/formateur';
import {Formateurjson} from '../model/formateurjson';
import {Technicienjson} from '../model/technicienjson';


@Injectable({
  providedIn: 'root'
})
export class FormateurRestService {
  private form1: Formateurjson;
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
      this.form1 = new Formateurjson(formateur);
      return this.http
        .post(this.url+ '/', this.form1);
    } else {
      return this.http
        .put(this.url + '/' + formateur.id, formateur);
    }
  }

  public findAll(): Observable <Formateur[]> {
    return this.http.get <Formateur[]>(this.url);
  }
}
