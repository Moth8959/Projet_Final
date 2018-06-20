import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {routesFormateur} from './formateur/routeFormateur';
import {routesStagiaire} from './stagiaire/routeStagiaire';
import {routesGestionnaire} from './gestionnaire/routeGestionnaire';
import {routesTechnicien} from './technicien/routeTechnicien';

import { AppComponent } from './app.component';
import { ContactComponent } from './Divers/contact.component';
import { HomeComponent } from './home.component';
import { FormateurComponent } from './formateur/formateur.component';
import {FormateurRestService} from './services/formateur.rest.service';
import { MatiereComponent } from './matiere/matiere.component';
import {HttpClientModule} from '@angular/common/http';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { GestionnaireComponent } from './gestionnaire/gestionnaire.component';
import { TechnicienComponent } from './technicien/technicien.component';
import {StagiaireRestService} from './services/stagiaire.rest.service';
import {TechnicienRestService} from './services/technicien.rest.service';
import {GestionnaireRestService} from './services/gestionnaire.rest.service';
import { CalendarComponent } from './calendar/calendar.component';



const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'contact', component: ContactComponent }
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
    CalendarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    RouterModule.forRoot(routesFormateur),
    RouterModule.forRoot(routesGestionnaire),
    RouterModule.forRoot(routesStagiaire),
    RouterModule.forRoot(routesTechnicien),
    HttpClientModule
  ],
  providers: [FormateurRestService, GestionnaireRestService, StagiaireRestService, TechnicienRestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
