import { Component, OnInit } from '@angular/core';
import {StagiaireRestService} from '../services/stagiaire.rest.service';
import {Stagiaire} from '../model/stagiaire';


@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent implements OnInit {

  private _stagiaires: Stagiaire[];

  public formStagiaire: Stagiaire = new Stagiaire( null, '',  '');

  constructor(private stagiaireRestService: StagiaireRestService) { }

  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }

  public edit(stagiaire: Stagiaire) {
    this.formStagiaire = stagiaire;
  }

  public save() {
    this.stagiaireRestService.save(this.formStagiaire);
    this.formStagiaire = new Stagiaire(null, '', '');
    this.stagiaireRestService.findAll().subscribe(resultat => {
      this.stagiaires = resultat;
    }, error => {
      console.log(error);
    });
  }

  public remove(stagiaire: Stagiaire) {
    this.stagiaireRestService.delete(stagiaire).subscribe(resultat =>{
      this.stagiaireRestService.findAll().subscribe(resultat=> {
        this._stagiaires = resultat;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.stagiaireRestService.findAll().subscribe( resultat => {
      this._stagiaires = resultat;
    }, error => {
      console.log(error);
    });
  }
}
