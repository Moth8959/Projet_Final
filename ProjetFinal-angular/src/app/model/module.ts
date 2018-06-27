import {Matiere} from './matiere';
import {Formateur} from './formateur';

import {Salle} from './salle';
import {Videoprojecteur} from './videoprojecteur';


export class Module {
  constructor(public id: number,
              public salle: Salle, public matiere: Matiere, public videoprojecteur: Videoprojecteur, public formateur?: Formateur, public dtDebut?: string,
              public dtFin?: string) {

  }
}
