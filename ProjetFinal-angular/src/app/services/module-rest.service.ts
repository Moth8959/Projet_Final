import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Module} from '../model/module';
import {HttpClient} from '@angular/common/http';
import {Modulejson} from '../model/modulejson';
import {Formateurjson} from '../model/formateurjson';


@Injectable({
  providedIn: 'root'
})
export class ModuleRestService {
  private mod1: Modulejson;
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
      this.mod1 = new Modulejson(module);
      console.log(this.mod1);
      console.log(this.mod1.formateur);
      console.log(this.mod1.matiere);
      console.log(this.mod1.salle);
      console.log(this.mod1.videoprojecteur);
      return this.http
        .post(this.url + '/', this.mod1);
    } else {
      return this.http
        .put(this.url + '/' + module.id, module);
    }
  }

  public findAll(): Observable <Module[]> {
    console.log('à l intérieur du findAll du module-rest.service');
    return this.http.get <Module[]>(this.url);
  }

}
