
import {Gestionnaire} from './gestionnaire';
import {Stagiaire} from './stagiaire';
import {Module} from './module'


export class Formation {
  constructor(private id: number, private titre: string, private gestionnaire: Gestionnaire, private modules: Module[], private stagiaires?: Stagiaire[]){
  }
}
