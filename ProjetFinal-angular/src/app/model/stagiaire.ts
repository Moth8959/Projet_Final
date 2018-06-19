export class Stagiaire {
  constructor(private _id: number, private _nom: string, private _prenom: string, private _niveau: string) {

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

  get niveau(): string {
    return this._niveau;
  }

  set niveau(value: string) {
    this._niveau = value;
  }
}
