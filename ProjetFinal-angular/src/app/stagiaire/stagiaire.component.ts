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

  constructor(private stagiaireRestService: StagiaireRestService) { }

  ngOnInit() {
    this.stagiaireRestService.findAll().subscribe( resultat => {
      this._stagiaires = resultat;
    }, error => {
      console.log(error);
    });
  }
  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }
}
