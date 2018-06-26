import {Component, HostListener, OnInit} from '@angular/core';
import {ModuleRestService} from '../services/module-rest.service';
import {Module} from '../model/module';


@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {

  private _modules: Module[];
  public formulaireShow: Boolean = false;


  public formModule: Module = new Module( null, '',  null, null, null, '', '', null);


  constructor(private moduleRestService: ModuleRestService) { }

  get modules(): Module[] {
    return this._modules;
  }

  public edit(module: Module) {
    this.formModule = module;
    this.formulaireShow = true;
  }

  public toggleEdit() {
    this.formulaireShow = !this.formulaireShow;
  }

  public save() {

    this.moduleRestService.save(this.formModule).subscribe(resultat => {
      this.moduleRestService.findAll().subscribe(result => {
        this._modules = result;
      }, error => {
        console.log(error);
      });
    });
    this.formModule = new Module( null, '',  null, null, null, '', '', null);
  }

  public remove(module: Module) {
    this.moduleRestService.delete(module).subscribe(resultat => {
      this.moduleRestService.findAll().subscribe(resultat2 => {
        this._modules = resultat2;
      }, error => {
        console.log(error);
      });
    });
  }
  ngOnInit() {
    this.moduleRestService.findAll().subscribe( resultat => {
      this._modules = resultat;
    }, error => {
      console.log(error);
    });
  }
  @HostListener('window:keydown', ['$event'])
  keyValidation(event: KeyboardEvent) {
    if (event.keyCode === 27) {
      console.log('Touche Esc appuyé!');
      this.formulaireShow = false;

    } else if (event.keyCode === 13) {
      console.log('Touche Entrée appuyé!');
      this.save();
    }
  }
}
