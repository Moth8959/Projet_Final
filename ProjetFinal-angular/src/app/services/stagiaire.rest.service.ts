import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Stagiaire} from '../model/stagiaire';

@Injectable({
  providedIn: 'root'
})
export class StagiaireRestService {

  private url = 'http://localhost:8080/stagiaire';

  constructor(private http: HttpClient) { }

  public delete(stagiaire: Stagiaire): Observable<any> {
   return this.http
      .delete(this.url + '/' + stagiaire.id);
  }

  public findById(id: number): Observable<Stagiaire> {
    return this.http.get <Stagiaire>(this.url + '/' + id);
  }

  public save(stagiaire: Stagiaire): Observable<any> {
    // POST OU PUT
    if (stagiaire.id == null) {
     return this.http
        .post(this.url+ '/', stagiaire);
    } else {
     return this.http
        .put(this.url + '/' + stagiaire.id, stagiaire);
    }
}

  public findAll(): Observable <Stagiaire[]> {
    return this.http.get <Stagiaire[]>(this.url);
  }
}
