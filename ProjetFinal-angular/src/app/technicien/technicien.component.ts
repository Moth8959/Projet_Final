import { Component, OnInit } from '@angular/core';
import {TechnicienRestService} from '../services/technicien.rest.service';
import {Technicien} from '../model/technicien';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.css']
})
export class TechnicienComponent implements OnInit {

  private _techniciens: Technicien[];

  constructor(private technicienRestService: TechnicienRestService) { }

  ngOnInit() {
    this.technicienRestService.findAll().subscribe( resultat => {
      this._techniciens = resultat;
    }, error => {
      console.log(error);
    });
  }
  get techniciens(): Technicien[] {
    return this._techniciens;
  }
}
