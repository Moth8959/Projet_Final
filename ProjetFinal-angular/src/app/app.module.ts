import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { routesFormateur} from './formateur/routeFormateur';
import { routesStagiaire} from './stagiaire/routeStagiaire';
import { routesGestionnaire} from './gestionnaire/routeGestionnaire';
import { routesTechnicien} from './technicien/routeTechnicien';
import { routesCalendrier} from './calendrier/routeCalendrier';

import { FullCalendarModule } from 'ng-fullcalendar';

import { AppComponent } from './app.component';
import { ContactComponent } from './Divers/contact.component';
import { HomeComponent } from './home.component';
import { FormateurComponent } from './formateur/formateur.component';
import { FormateurRestService} from './services/formateur.rest.service';
import { MatiereComponent } from './matiere/matiere.component';
import { HttpClientModule} from '@angular/common/http';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { GestionnaireComponent } from './gestionnaire/gestionnaire.component';
import { TechnicienComponent } from './technicien/technicien.component';
import { StagiaireRestService} from './services/stagiaire.rest.service';
import { TechnicienRestService} from './services/technicien.rest.service';
import { GestionnaireRestService} from './services/gestionnaire.rest.service';
import { CalendrierComponent } from './calendrier/calendrier.component';
import { FormsModule} from '@angular/forms';
import { StagiaireDetailComponent} from './stagiaire/stagiaire.detail.component';
import { FormioAppConfig } from 'angular-formio';
import { FormioAuthService, FormioAuthConfig } from 'angular-formio/auth';
import { AuthConfig, AppConfig } from '../config';
import { AuthModule } from './auth/auth.module';


import { EventService } from './services/event.service';

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
    FormsModule,
    FullCalendarModule,
    HttpClientModule
  ],
  providers: [FormateurRestService, GestionnaireRestService, StagiaireRestService, TechnicienRestService, EventService,
    FormioAuthService,
    {provide: FormioAuthConfig, useValue: AuthConfig},
    {provide: FormioAppConfig, useValue: AppConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
