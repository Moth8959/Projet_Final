import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Technicien} from '../model/technicien';
import {Technicienjson} from '../model/technicienjson';

@Injectable({
  providedIn: 'root'
})
export class TechnicienRestService {
  private tech1: Technicienjson;
  private url = 'http://localhost:8080/technicien';

  constructor(private http: HttpClient) { }

  public findAll(): Observable <Technicien[]> {
    console.log('a l interieur du findAll du rest service');
    return this.http.get <Technicien[]>(this.url);
  }

  public findById(id: number): Observable<Technicien> {
    return this.http.get <Technicien>(this.url + '/' + id);
  }

  public save(technicien: Technicien): Observable<any> {
    // POST OU PUT
    if (technicien.id == null) {
      this.tech1 = new Technicienjson(technicien);
      return this.http
        .post<Technicien>(this.url + '/', this.tech1);
    } else {
      console.log(technicien);
      return this.http
        .put(this.url + '/' + technicien.id, technicien);
    }
  }

  public delete(technicien: Technicien): Observable<any> {
    return this.http
      .delete(this.url + '/' + technicien.id);
  }

}
