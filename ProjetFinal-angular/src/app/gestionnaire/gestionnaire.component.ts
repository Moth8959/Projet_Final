import { Component, OnInit } from '@angular/core';
import {GestionnaireRestService} from '../services/gestionnaire.rest.service';
import {Gestionnaire} from '../model/gestionnaire';


@Component({
  selector: 'app-gestionnaire',
  templateUrl: './gestionnaire.component.html',
  styleUrls: ['./gestionnaire.component.css']
})
export class GestionnaireComponent implements OnInit {

  private _gestionnaires: Gestionnaire[];

  constructor(private gestionnaireRestService: GestionnaireRestService) { }

  ngOnInit() {
    this.gestionnaireRestService.findAll().subscribe( resultat => {
      this._gestionnaires = resultat;
    }, error => {
      console.log(error);
    });
  }
  get gestionnaires(): Gestionnaire[] {
    return this._gestionnaires;
  }
}
