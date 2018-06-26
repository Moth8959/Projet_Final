import {Component, HostListener, OnInit} from '@angular/core';
import {MatiereRestService} from '../services/matiere-rest.service';
import {Matiere} from '../model/matiere';


@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent implements OnInit {

  private _matieres: Matiere[];
  public formulaireShow: Boolean = false;


  public formMatiere: Matiere = new Matiere( null, '',  null);


  constructor(private matiereRestService: MatiereRestService) { }

  get matieres(): Matiere[] {
    return this._matieres;
  }

  public edit(matiere: Matiere) {
    this.formMatiere = matiere;
    this.formulaireShow = true;
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.matiereRestService.save(this.formMatiere).subscribe(resultat => {
      this.matiereRestService.findAll().subscribe(result => {
        this._matieres = result;
      }, error => {
        console.log(error);
      });
    });
    this.formMatiere = new Matiere(null, '', null);
  }

  public remove(matiere: Matiere) {
    this.matiereRestService.delete(matiere).subscribe(resultat => {
      this.matiereRestService.findAll().subscribe(resultat2 => {
        this._matieres = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.matiereRestService.findAll().subscribe( resultat => {
      this._matieres = resultat;
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
