import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Matiere} from '../model/matiere';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MatiereRestService {
  private mat1: Matiere;
  private url = 'http://localhost:8080/matiere';

  constructor(private http: HttpClient) { }

  public delete(matiere: Matiere): Observable<any> {
    return this.http
      .delete(this.url + '/' + matiere.id);


  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get <Matiere>(this.url + '/' + id);
  }

  public save(matiere: Matiere): Observable<any> {
    // POST OU PUT
    if (matiere.id == null) {
      return this.http
        .post(this.url + '/', matiere);
    } else {
      return this.http
        .put(this.url + '/' + matiere.id, matiere);
    }
  }

  public findAll(): Observable <Matiere[]> {
    return this.http.get <Matiere[]>(this.url);
  }

}
