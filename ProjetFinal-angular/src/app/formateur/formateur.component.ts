import { Component, OnInit } from '@angular/core';
import {FormateurRestService} from '../services/formateur.rest.service';
import {Formateur} from '../model/formateur';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  public _formateurs: Formateur[];
  public formFormateur: Formateur = new Formateur( null, '', '');

  constructor(private formateurRestService: FormateurRestService) { }

  public edit(formateur: Formateur) {
    this.formFormateur = formateur;
  }

  public save() {
    this.formateurRestService.save(this.formFormateur);
    this.formFormateur = new Formateur(null, '', '');
    this.formateurRestService.findAll().subscribe(resultat => {
      this._formateurs = resultat;
    }, error => {
      console.log(error);
    });
  }

  public remove(formateur: Formateur) {
    this.formateurRestService.delete(formateur);
    this.formateurRestService.findAll().subscribe(resultat => {
      this._formateurs = resultat;
    }, error => {
      console.log(error);
    });
  }

  ngOnInit() {
    this.formateurRestService.findAll().subscribe( resultat => {
      this._formateurs = resultat;
    }, error => {
      console.log(error);
    });
  }
  get formateurs(): Formateur[] {
    return this._formateurs;
  }
}
