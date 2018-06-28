import {Component, HostListener, OnInit} from '@angular/core';
import {OrdinateurRestService} from '../services/ordinateur-rest.service';
import {Ordinateur} from '../model/ordinateur';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './ordinateur.component.html',
  styleUrls: ['./ordinateur.component.css']
})
export class OrdinateurComponent implements OnInit {

  private _ordinateurs: Ordinateur[];
  public formulaireShow: Boolean = false;


  public formOrdinateur: Ordinateur = new Ordinateur(0, 0, '', 0, 0, 0);


  constructor(private ordinateurRestService: OrdinateurRestService) { }

  get ordinateurs(): Ordinateur[] {
    return this._ordinateurs;
  }

  public edit(ordinateur: Ordinateur) {
    this.formOrdinateur = ordinateur;
    this.formulaireShow = true;
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.ordinateurRestService.save(this.formOrdinateur).subscribe(resultat => {
      this.ordinateurRestService.findAll().subscribe(result => {
        this._ordinateurs = result;
      }, error => {
        console.log(error);
      });
    });
    this.formOrdinateur = new Ordinateur(0, 0, '', 0, 0, 0);
  }

  public remove(ordinateur: Ordinateur) {
    this.ordinateurRestService.delete(ordinateur).subscribe(resultat => {
      this.ordinateurRestService.findAll().subscribe(resultat2 => {
        this._ordinateurs = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
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
