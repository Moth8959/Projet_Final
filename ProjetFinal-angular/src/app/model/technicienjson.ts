import {Technicien} from './technicien';

export class Technicienjson {
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

  constructor(technicien: Technicien){
    this.id = technicien.id;
    this.nom = technicien.nom;
    this.prenom = technicien.prenom;
    this.coordonnees = technicien.coordonnees;
    this.rue = technicien.rue;
    this.ville = technicien.ville;
    this.username = technicien.username;
    this.password = technicien.password;
    this.accesAdministrateur = technicien.accesAdministrateur;
    this.accesFormateur = technicien.accesFormateur;
    this.accesStagiaire = technicien.accesStagiaire;
    this.accesTechnicien = technicien.accesTechnicien;
  }
}
