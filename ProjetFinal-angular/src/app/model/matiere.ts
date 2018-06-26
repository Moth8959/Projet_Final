import {Formateur} from './formateur';
import {Module} from './module';

export class Matiere {


  constructor(public id: number, public titre: string, public niveau: string, public formateurs?: Formateur[], public modules?: Module[],
              public objectif?: string, public contenu?: string) {
  }


}
