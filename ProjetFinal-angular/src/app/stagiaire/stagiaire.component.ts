import {Component, HostListener, OnInit} from '@angular/core';
import {StagiaireRestService} from '../services/stagiaire.rest.service';
import {OrdinateurRestService} from '../services/ordinateur-rest.service';
import {Stagiaire} from '../model/stagiaire';
import {Ordinateur} from '../model/ordinateur';


@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent implements OnInit {

  private _stagiaires: Stagiaire[];
  private _ordinateurs: Ordinateur[];
  public formulaireShow: Boolean = false;


  public formStagiaire: Stagiaire = new Stagiaire( null, '',  '', '', '', '', '', null, null);


  constructor(private stagiaireRestService: StagiaireRestService, private ordinateurRestService: OrdinateurRestService) { }

  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }

  get ordinateurs(): Ordinateur[] {
    return this._ordinateurs;
  }

  public edit(stagiaire: Stagiaire) {
    this.formStagiaire = stagiaire;
    this.formulaireShow = true;
    console.log(JSON.stringify(this.formStagiaire));
  }

  public toggleEdit(){
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {
    console.log(JSON.stringify(this.formStagiaire));
    this.stagiaireRestService.save(this.formStagiaire).subscribe(resultat => {
    this.stagiaireRestService.findAll().subscribe(result => {
      this._stagiaires = result;
    }, error => {
      console.log(error);
    });
  });
    this.formStagiaire = new Stagiaire(null, '',  '', '', '', '', '', null, null);
  }

  public remove(stagiaire: Stagiaire) {
    this.stagiaireRestService.delete(stagiaire).subscribe(resultat =>{
      this.stagiaireRestService.findAll().subscribe(resultat => {
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

    this.ordinateurRestService.findAll().subscribe( resultat => {
      this._ordinateurs = resultat;
    }, error => {
      console.log(error);
    });
  }
  @HostListener('window:keydown', ['$event'])
  keyValidation(event: KeyboardEvent) {
    if (event.keyCode === 27) {
      console.log('Touche Esc appuyé!');
      this.formulaireShow = false;

    } else if (event.keyCode === 13) {
      console.log('Touche Entrée appuyé!');
      this.save();
    }
  }
}
