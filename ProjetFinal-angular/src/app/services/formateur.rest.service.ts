import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Formateur} from '../model/formateur';

@Injectable({
  providedIn: 'root'
})
export class FormateurRestService {

  private url = 'http://localhost:8080/rest/formateur';

  constructor(private http: HttpClient) { }

  public findAll(): Observable <Formateur[]> {
    return this.http.get <Formateur[]>(this.url);
  }
}
