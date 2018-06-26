import {Matiere} from './matiere';
import {Formateur} from './formateur';

import {Salle} from './salle';
import {Videoprojecteur} from './videoprojecteur';


export class Module {
  constructor(public id: number, public titre: string, public formateur: Formateur,
              public salle: Salle, public matiere: Matiere, public dtDebut: string,
              public dtFin: string, public videoprojecteur: Videoprojecteur) {

  }
}
