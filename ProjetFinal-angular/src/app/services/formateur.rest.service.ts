import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Formateur} from '../model/formateur';

@Injectable({
  providedIn: 'root'
})
export class FormateurRestService {

  private formateurs: Array<Formateur>;

  private url = 'http://localhost:8080/formateur';

  constructor(private http: HttpClient) { }

  public findAll(): Observable <Formateur[]> {
    return this.http.get <Formateur[]>(this.url);
  }

  public findById(id: number): Observable<Formateur []> {
    return this.http.get <Formateur[]>(this.url+ id);
  }

  public save(formateur: Formateur) {
    // POST OU PUT
    if (formateur.id == null) {
      this.http
        .post(this.url, formateur)
        .subscribe(result => {
          this.findAll();
        });
    } else {
      this.http
        .put(this.url + formateur.id, formateur)
        .subscribe();
    }

  }


  public delete(formateur: Formateur) {
    this.http
      .delete(this.url + formateur.id)
      .subscribe();
  }

}
