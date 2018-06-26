import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Module} from '../model/module';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ModuleRestService {
  private mat1: Module;
  private url = 'http://localhost:8080/module';

  constructor(private http: HttpClient) { }

  public delete(module: Module): Observable<any> {
    return this.http
      .delete(this.url + '/' + module.id);


  }

  public findById(id: number): Observable<Module> {
    return this.http.get <Module>(this.url + '/' + id);
  }

  public save(module: Module): Observable<any> {
    // POST OU PUT
    if (module.id == null) {
      return this.http
        .post(this.url + '/', module);
    } else {
      return this.http
        .put(this.url + '/' + module.id, module);
    }
  }

  public findAll(): Observable <Module[]> {
    return this.http.get <Module[]>(this.url);
  }

}
