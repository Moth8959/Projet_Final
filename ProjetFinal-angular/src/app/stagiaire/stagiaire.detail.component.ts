import { Component, OnInit } from '@angular/core';
import {Stagiaire} from '../model/stagiaire';
import {ActivatedRoute} from '@angular/router';
import {StagiaireRestService} from '../services/stagiaire.rest.service';
import {AdresseComponent} from '../Divers/adresse.component';

@Component({
  selector: 'app-stagiaire.detail',
  templateUrl: './stagiaire.detail.component.html',
  styleUrls: ['./stagiaire.detail.component.css']
})
export class StagiaireDetailComponent implements OnInit {


  public stagiaire: Stagiaire = new Stagiaire(0, '', '');

  constructor(private route: ActivatedRoute, private stagiaireRestService: StagiaireRestService) {
    this.route.params.subscribe(params => stagiaireRestService.findById(params['id'])
      .subscribe(resultat => {
        this.stagiaire = resultat;
      }, error => {
        console.log(error);
      }));
  }

  ngOnInit() {
  }

}






