import {Salle} from './salle';
import {Matiere} from './matiere';
import {Videoprojecteur} from './videoprojecteur';
import {Formateur} from './formateur';
import {Module} from './module';
import {routesSalle} from '../salle/routeSalle';


export class Modulejson {

  public id: number;
  public salle: Salle;
  public matiere: Matiere;
  public videoprojecteur: Videoprojecteur;
  public formateur: Formateur;

  constructor (module: Module) {
    this.id = module.id;
    this.salle = module.salle;
    this.matiere = module.matiere;
    this.videoprojecteur = module.videoprojecteur;
    this.formateur = module.formateur;


  }







}
