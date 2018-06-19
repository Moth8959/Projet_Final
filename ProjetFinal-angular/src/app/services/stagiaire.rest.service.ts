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

  public findAll(): Observable <Stagiaire[]> {
    return this.http.get <Stagiaire[]>(this.url);
  }
}
