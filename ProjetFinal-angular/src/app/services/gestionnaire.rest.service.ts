import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Gestionnaire} from '../model/gestionnaire';

@Injectable({
  providedIn: 'root'
})
export class GestionnaireRestService {

  private url = 'http://localhost:8080/gestion';

  constructor(private http: HttpClient) { }

  public findAll(): Observable <Gestionnaire[]> {
    return this.http.get <Gestionnaire[]>(this.url);
  }

  public delete(gestionnaire: Gestionnaire): Observable<any> {
    return this.http
      .delete(this.url + '/' + gestionnaire.id);


  }

  public findById(id: number): Observable<Gestionnaire> {
    return this.http.get <Gestionnaire>(this.url + '/' + id);
  }

  public save(gestionnaire: Gestionnaire): Observable<any> {
    // POST OU PUT
    if (gestionnaire.id == null) {
      return this.http
        .post(this.url+ '/', gestionnaire);
    } else {
      return this.http
        .put(this.url + '/' + gestionnaire.id, gestionnaire);
    }
  }
}







