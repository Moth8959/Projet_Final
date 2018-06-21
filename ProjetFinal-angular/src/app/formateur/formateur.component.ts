import { Component, OnInit } from '@angular/core';
import {FormateurRestService} from '../services/formateur.rest.service';
import {Formateur} from '../model/formateur';
import {Stagiaire} from "../model/stagiaire";

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  private _formateurs: Formateur[];
  public formFormateur: Formateur = new Formateur( null, '', '');

  constructor(private formateurRestService: FormateurRestService) { }

  get formateurs(): Formateur[] {
    return this._formateurs;
  }

  public edit(formateur: Formateur) {
    this.formFormateur = formateur;
  }

  public save() {
    this.formateurRestService.save(this.formFormateur).subscribe(resultat => {
      this.formateurRestService.findAll().subscribe(result => {
        this._formateurs = result;
      }, error => {
        console.log(error);
      });
    });

    this.formFormateur = new Formateur(null, '','' );
  }

  public remove(formateur: Formateur) {
    this.formateurRestService.delete(formateur).subscribe(resultat =>{
      this.formateurRestService.findAll().subscribe(resultat => {
        this._formateurs = resultat;
      }, error => {
        console.log(error);
      });
    });
  }

  ngOnInit() {
    this.formateurRestService.findAll().subscribe( resultat => {
      this._formateurs = resultat;
    }, error => {
      console.log(error);
    });
  }

}
