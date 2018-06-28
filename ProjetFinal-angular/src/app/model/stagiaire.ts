import {Ordinateur} from './ordinateur';

export class Stagiaire {
  constructor(public id: number, public nom: string, public prenom: string,
              public coordonnees?: string, public rue?: string, public ville?: string, public codePostal?: string,
              public niveau?: string, public ordinateur?: Ordinateur, public username?: string, public password?: string) {

  }

}
