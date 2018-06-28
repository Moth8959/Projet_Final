import {Component, HostListener, OnInit} from '@angular/core';
import {FormateurRestService} from '../services/formateur.rest.service';
import {Formateur} from '../model/formateur';


@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {

  private _formateurs: Formateur[];
  public formFormateur: Formateur = new Formateur(null, '', '', '', '', '', '', null, null, null, null, null, null);
  public formulaireShow: Boolean = false;

  constructor(private formateurRestService: FormateurRestService) { }

  get formateurs(): Formateur[] {
    return this._formateurs;
  }

  public edit(formateur: Formateur) {
    this.formFormateur = formateur;
    this.formulaireShow = true;
  }

  public toggleEdit(){
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {
    this.formateurRestService.save(this.formFormateur).subscribe(resultat => {
      this.formateurRestService.findAll().subscribe(result => {
        this._formateurs = result;
      }, error => {
        console.log(error);
      });
    });

    this.formFormateur = new Formateur(null, '', '', '', '', '', '', null, null, null, null, null, null);
  }

  public remove(formateur: Formateur) {
    this.formateurRestService.delete(formateur).subscribe(resultat =>{
      this.formateurRestService.findAll().subscribe(resultat2 => {
        this._formateurs = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }

  ngOnInit() {
    this.formateurRestService.findAll().subscribe( resultat => {
      this._formateurs = resultat;
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
