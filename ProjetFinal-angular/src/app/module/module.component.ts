import {Component, HostListener, OnInit} from '@angular/core';
import {ModuleRestService} from '../services/module-rest.service';
import {Module} from '../model/module';
import {VideoprojecteurRestService} from '../services/videoprojecteur-rest.service';
import {Videoprojecteur} from '../model/videoprojecteur';
import {MatiereRestService} from '../services/matiere-rest.service';
import {Matiere} from '../model/matiere';
import {Salle} from '../model/salle';
import {SalleRestService} from '../services/salle-rest.service';
import {Formateur} from '../model/formateur';
import {FormateurRestService} from '../services/formateur.rest.service';


@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {

  private _modules: Module[];
  private _matieres: Matiere[];
  private _formateurs: Formateur[];
  private _salles: Salle[];
  private _videoprojecteurs: Videoprojecteur[];
  public formulaireShow: Boolean = false;


  public formModule: Module = new Module( null,  null, null, null, undefined, '', '');


  constructor(private moduleRestService: ModuleRestService, private salleRestService: SalleRestService, private matiereRestService: MatiereRestService, private videoprojecteurRestService: VideoprojecteurRestService,
              private formateurRestService: FormateurRestService ) { }

  get modules(): Module[] {
    return this._modules;
  }

  get videoprojecteurs(): Videoprojecteur[] {
    return this._videoprojecteurs;
  }

  get matieres(): Matiere[] {
    return this._matieres;
  }

  get formateurs(): Formateur[] {
    return this._formateurs;
  }

  get salles(): Salle[] {
    return this._salles;
  }

  public edit(module: Module) {
    this.formModule = module;
    this.formulaireShow = true;
    console.log('méthode edit() entrée ' + JSON.stringify(this.formModule));
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {
    console.log(JSON.stringify(this.formModule.videoprojecteur));
    this.moduleRestService.save(this.formModule).subscribe(resultat => {
      this.moduleRestService.findAll().subscribe(result => {
        this._modules = result;
      }, error => {
        console.log(error);
      });
    });
    this.formModule = new Module( null,  null, null, null,  undefined , '', '');
  }

  public remove(module: Module) {
    this.moduleRestService.delete(module).subscribe(resultat => {
      this.moduleRestService.findAll().subscribe(resultat2 => {
        this._modules = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.moduleRestService.findAll().subscribe( resultat => {
      this._modules = resultat;
    }, error => {
      console.log(error);
    });

    this.formateurRestService.findAll().subscribe( resultat => {
      this._formateurs = resultat;
    }, error => {
      console.log(error);
    });

    this.salleRestService.findAll().subscribe( resultat => {
      this._salles = resultat;
    }, error => {
      console.log(error);
    });

    this.videoprojecteurRestService.findAll().subscribe( resultat => {
      this._videoprojecteurs = resultat;
    }, error => {
      console.log(error);
    });

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
