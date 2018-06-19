import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Technicien} from '../model/technicien';

@Injectable({
  providedIn: 'root'
})
export class TechnicienRestService {

  private url = 'http://localhost:8080/technicien';

  constructor(private http: HttpClient) { }

  public findAll(): Observable <Technicien[]> {
    return this.http.get <Technicien[]>(this.url);
  }
}
