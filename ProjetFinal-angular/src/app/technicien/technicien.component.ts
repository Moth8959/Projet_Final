import { Component, OnInit } from '@angular/core';
import {TechnicienRestService} from '../services/technicien.rest.service';
import {Technicien} from '../model/technicien';
import { Observable} from 'rxjs';
import {HostListener} from '@angular/core';





@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.css']
})
export class TechnicienComponent implements OnInit {

  public _techniciens: Technicien[];
  public formTechnicien: Technicien = new Technicien(null, '', '', '', '', '', '', null, null, null, null, null, null);
  // public formTechnicien: Technicien = new Technicien(null, '', '', '', '', '', '', '', '', false, false, false, false);
  public formulaireShow: Boolean = false;



  constructor(private technicienRestService: TechnicienRestService) { }

  public edit(technicien: Technicien) {
    this.formTechnicien = technicien;
    this.formulaireShow = true;
  }

  public toggleEdit(){
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {
    console.log('save');
    this.technicienRestService.save(this.formTechnicien).subscribe( resultat => {
      console.log('premier subscribe : ' + resultat);
      this.technicienRestService.findAll().subscribe(result => {
        console.log('subscribe 2');
          this._techniciens = result;
        }, error => {
          console.log(error);
        }
      );}
    );
    this.formTechnicien = new Technicien(null, '', '', '', '', '', '', null, null, null, null, null, null);
    this.formulaireShow = false;
  }


  public remove(technicien: Technicien) {
    this.technicienRestService.delete(technicien).subscribe(result => {
      this.technicienRestService.findAll().subscribe(resultat => {
        this._techniciens = resultat;
      }, error => {
        console.log(error);
      });
    });
  }

  ngOnInit(): void {
    this.technicienRestService.findAll().subscribe( resultat => {
      this._techniciens = resultat;
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
