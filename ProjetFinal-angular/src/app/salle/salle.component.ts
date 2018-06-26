import {Component, HostListener, OnInit} from '@angular/core';
import {SalleRestService} from '../services/salle-rest.service';
import {Salle} from '../model/salle';


@Component({
  selector: 'app-salle',
  templateUrl: './salle.component.html',
  styleUrls: ['./salle.component.css']
})
export class SalleComponent implements OnInit {

  private _salles: Salle[];
  public formulaireShow: Boolean = false;


  public formSalle: Salle = new Salle( null, null, '', null);


  constructor(private salleRestService: SalleRestService) { }

  get salles(): Salle[] {
    return this._salles;
  }

  public edit(salle: Salle) {
    this.formSalle = salle;
    this.formulaireShow = true;
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.salleRestService.save(this.formSalle).subscribe(resultat => {
      this.salleRestService.findAll().subscribe(result => {
        this._salles = result;
      }, error => {
        console.log(error);
      });
    });
    this.formSalle = new Salle(null, null, '', null);
  }

  public remove(salle: Salle) {
    this.salleRestService.delete(salle).subscribe(resultat => {
      this.salleRestService.findAll().subscribe(resultat2 => {
        this._salles = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.salleRestService.findAll().subscribe( resultat => {
      this._salles = resultat;
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
