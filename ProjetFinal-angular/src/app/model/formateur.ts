export class Formateur {
  constructor(private _id: number, private _nom: string, private _prenom: string,
              private _coordonnees: string, private _rue: string, private _ville: string,
              private _codePostal: string, private _username: string, private _password: string,
              private _accesAdministrateur: boolean, private _accesFormateur: boolean,
              private _accesStagiaire: boolean, private _accesTechnicien: boolean) {
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get coordonnees(): string {
    return this._coordonnees;
  }

  set coordonnees(value: string) {
    this._coordonnees = value;
  }

  get rue(): string {
    return this._rue;
  }

  set rue(value: string) {
    this._rue = value;
  }

  get ville(): string {
    return this._ville;
  }

  set ville(value: string) {
    this._ville = value;
  }

  get codePostal(): string {
    return this._codePostal;
  }

  set codePostal(value: string) {
    this._codePostal = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get accesAdministrateur(): boolean {
    return this._accesAdministrateur;
  }

  set accesAdministrateur(value: boolean) {
    this._accesAdministrateur = value;
  }

  get accesFormateur(): boolean {
    return this._accesFormateur;
  }

  set accesFormateur(value: boolean) {
    this._accesFormateur = value;
  }

  get accesStagiaire(): boolean {
    return this._accesStagiaire;
  }

  set accesStagiaire(value: boolean) {
    this._accesStagiaire = value;
  }

  get accesTechnicien(): boolean {
    return this._accesTechnicien;
  }

  set accesTechnicien(value: boolean) {
    this._accesTechnicien = value;
  }
}
