import {Routes} from '@angular/router';
import {StagiaireComponent} from '../stagiaire/stagiaire.component';
import {StagiaireDetailComponent} from '../stagiaire/stagiaire.detail.component';

export const routesStagiaire: Routes = [
  {path: 'stagiaire' , component: StagiaireComponent},
  {path: 'stagiaire/:id' , component: StagiaireDetailComponent},
];
