import {Component, HostListener, OnInit} from '@angular/core';
import {StagiaireRestService} from '../services/stagiaire.rest.service';
import {Stagiaire} from '../model/stagiaire';


@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent implements OnInit {

  private _stagiaires: Stagiaire[];
  public formulaireShow: Boolean = false;


  public formStagiaire: Stagiaire = new Stagiaire( null, '',  '');


  constructor(private stagiaireRestService: StagiaireRestService) { }

  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }

  public edit(stagiaire: Stagiaire) {
    this.formStagiaire = stagiaire;
    this.formulaireShow = true;
  }

  public toggleEdit(){
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.stagiaireRestService.save(this.formStagiaire).subscribe(resultat => {
    this.stagiaireRestService.findAll().subscribe(result => {
      this._stagiaires = result;
    }, error => {
      console.log(error);
    });
  });
    this.formStagiaire = new Stagiaire(null, '','' );
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
