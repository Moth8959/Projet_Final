import { Component, OnInit } from '@angular/core';
import {MatiereComponent} from "../../matiere/matiere.component";

@Component({
  selector: 'app-formateur-competences',
  templateUrl: './formateur-competences.component.html',
  styleUrls: ['./formateur-competences.component.css']
})
export class FormateurCompetencesComponent implements OnInit {

  public matiere: Matiere = new Matiere(0, '');




  constructor() { }

  ngOnInit() {
  }

}
