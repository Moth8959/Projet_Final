import {Component, HostListener, OnInit} from '@angular/core';
import {VideoprojecteurRestService} from '../services/videoprojecteur-rest.service';
import {Videoprojecteur} from '../model/videoprojecteur';


@Component({
  selector: 'app-videoprojecteur',
  templateUrl: './videoprojecteur.component.html',
  styleUrls: ['./videoprojecteur.component.css']
})
export class VideoprojecteurComponent implements OnInit {

  private _videoprojecteurs: Videoprojecteur[];
  public formulaireShow: Boolean = false;


  public formVideoprojecteur: Videoprojecteur = new Videoprojecteur( null, null, '', false, false);


  constructor(private videoprojecteurRestService: VideoprojecteurRestService) { }

  get videoprojecteurs(): Videoprojecteur[] {
    return this._videoprojecteurs;
  }

  public edit(videoprojecteur: Videoprojecteur) {
    this.formVideoprojecteur = videoprojecteur;
    this.formulaireShow = true;
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.videoprojecteurRestService.save(this.formVideoprojecteur).subscribe(resultat => {
      this.videoprojecteurRestService.findAll().subscribe(result => {
        this._videoprojecteurs = result;
      }, error => {
        console.log(error);
      });
    });
    this.formVideoprojecteur = new Videoprojecteur(null, null, '', false, false);
  }

  public remove(videoprojecteur: Videoprojecteur) {
    this.videoprojecteurRestService.delete(videoprojecteur).subscribe(resultat => {
      this.videoprojecteurRestService.findAll().subscribe(resultat2 => {
        this._videoprojecteurs = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.videoprojecteurRestService.findAll().subscribe( resultat => {
      this._videoprojecteurs = resultat;
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
