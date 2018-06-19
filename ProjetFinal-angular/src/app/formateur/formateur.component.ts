import { Component, OnInit } from '@angular/core';
import {FormateurRestService} from '../services/formateur.rest.service';
import {Formateur} from '../model/formateur';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  private _formateurs: Formateur[];

  constructor(private formateurRestService: FormateurRestService) { }

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
