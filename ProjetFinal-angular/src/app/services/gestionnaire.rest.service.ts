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
}
