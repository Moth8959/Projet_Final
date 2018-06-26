import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule} from '@angular/forms';
import { FullCalendarModule } from 'ng-fullcalendar';
import { AuthModule } from './auth/auth.module';

import { routesFormateur} from './formateur/routeFormateur';
import { routesStagiaire} from './stagiaire/routeStagiaire';
import { routesGestionnaire} from './gestionnaire/routeGestionnaire';
import { routesTechnicien} from './technicien/routeTechnicien';
import { routesCalendrier} from './calendrier/routeCalendrier';
import { routesSalle} from './salle/routeSalle';
import { routesVideoprojecteur} from './videoprojecteur/routeVideoprojecteur';
import { routesOrdinateur} from './ordinateur/routeOrdinateur';
import { routesFormation} from './formation/routeFormation';
import { routesMatiere} from './matiere/routeMatiere';
import { routesModule} from './module/routeModule';



import { AppComponent } from './app.component';
import { ContactComponent } from './Divers/contact.component';
import { HomeComponent } from './home.component';
import { FormateurComponent } from './formateur/formateur.component';
import { MatiereComponent } from './matiere/matiere.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { GestionnaireComponent } from './gestionnaire/gestionnaire.component';
import { TechnicienComponent } from './technicien/technicien.component';
import { SalleComponent } from './salle/salle.component';
import { OrdinateurComponent } from './ordinateur/ordinateur.component';
import { VideoprojecteurComponent } from './videoprojecteur/videoprojecteur.component';
import { CalendrierComponent } from './calendrier/calendrier.component';
import { StagiaireDetailComponent} from './stagiaire/stagiaire.detail.component';

import { FormateurRestService} from './services/formateur.rest.service';
import { StagiaireRestService} from './services/stagiaire.rest.service';
import { TechnicienRestService} from './services/technicien.rest.service';
import { GestionnaireRestService} from './services/gestionnaire.rest.service';
import { MatiereRestService} from './services/matiere-rest.service';
import { SalleRestService} from './services/salle-rest.service';
import { VideoprojecteurRestService} from './services/videoprojecteur-rest.service';
import { EventService } from './services/event.service';

import { FormioAppConfig } from 'angular-formio';
import { FormioAuthService, FormioAuthConfig } from 'angular-formio/auth';
import { AuthConfig, AppConfig } from '../config';
import { FormationComponent } from './formation/formation.component';
import { ModuleComponent } from './module/module.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'contact', component: ContactComponent },
  { path: 'auth', loadChildren: () => AuthModule}

];

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    HomeComponent,
    FormateurComponent,
    MatiereComponent,
    StagiaireComponent,
    GestionnaireComponent,
    TechnicienComponent,
    CalendrierComponent,
    StagiaireDetailComponent,
    SalleComponent,
    OrdinateurComponent,
    VideoprojecteurComponent,
    FormationComponent,
    ModuleComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule.forRoot(routes),
    RouterModule.forRoot(routesFormateur),
    RouterModule.forRoot(routesGestionnaire),
    RouterModule.forRoot(routesStagiaire),
    RouterModule.forRoot(routesTechnicien),
    RouterModule.forRoot(routesCalendrier),
    RouterModule.forRoot(routesSalle),
    RouterModule.forRoot(routesOrdinateur),
    RouterModule.forRoot(routesVideoprojecteur),
    RouterModule.forRoot(routesFormation),
    RouterModule.forRoot(routesMatiere),
    RouterModule.forRoot(routesModule),

    FormsModule,
    FullCalendarModule,
    HttpClientModule
  ],
  providers: [FormateurRestService, GestionnaireRestService, StagiaireRestService, TechnicienRestService, EventService,
    FormioAuthService, MatiereRestService, SalleRestService, VideoprojecteurRestService,
    {provide: FormioAuthConfig, useValue: AuthConfig},
    {provide: FormioAppConfig, useValue: AppConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
