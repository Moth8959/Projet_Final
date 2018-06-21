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
  public formGestionnaire: Gestionnaire = new Gestionnaire( null, '',  '');
  public formulaireShow: Boolean = false;


  constructor(private gestionnaireRestService: GestionnaireRestService) { }


  get gestionnaires(): Gestionnaire[] {
    return this._gestionnaires;
  }

  public edit(gestionnaire: Gestionnaire) {
    this.formGestionnaire = gestionnaire;
    this.formulaireShow = true;
  }

  public save() {

    this.gestionnaireRestService.save(this.formGestionnaire).subscribe(resultat => {
      this.gestionnaireRestService.findAll().subscribe(result => {
        this._gestionnaires = result;
      }, error => {
        console.log(error);
      });
    });
    this.formulaireShow = false;
    this.formGestionnaire = new Gestionnaire(null, '', '');
  }

  public remove(gestionnaire: Gestionnaire) {
    this.gestionnaireRestService.delete(gestionnaire).subscribe(resultat =>{
      this.gestionnaireRestService.findAll().subscribe(resultat => {
        this._gestionnaires = resultat;
      }, error => {
        console.log(error);
      });
    });
  }

  ngOnInit() {
    this.gestionnaireRestService.findAll().subscribe( resultat => {
      this._gestionnaires = resultat;
    }, error => {
      console.log(error);
    });
  }
}
