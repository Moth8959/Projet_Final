import {Formateur} from './formateur';

export class Formateurjson {
  private id: number;
  private nom: string;
  private prenom: string;
  private coordonnees: string;
  private rue: string;
  private ville: string;
  private codePostal: string;
  private username: string;
  private password: string;
  private accesAdministrateur: boolean;
  private accesFormateur: boolean;
  private accesStagiaire: boolean;
  private accesTechnicien: boolean;

  constructor(formateur: Formateur){
    this.id = formateur.id;
    this.nom = formateur.nom;
    this.prenom = formateur.prenom;
    this.coordonnees = formateur.coordonnees;
    this.rue = formateur.rue;
    this.ville = formateur.ville;
    this.username = formateur.username;
    this.password = formateur.password;
    this.accesAdministrateur = formateur.accesAdministrateur;
    this.accesFormateur = formateur.accesFormateur;
    this.accesStagiaire = formateur.accesStagiaire;
    this.accesTechnicien = formateur.accesTechnicien;
  }
}
