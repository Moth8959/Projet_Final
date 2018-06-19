import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {routesFormateur} from './formateur/route';

import { AppComponent } from './app.component';
import { ContactComponent } from './Divers/contact.component';
import { HomeComponent } from './home.component';
import { FormateurComponent } from './formateur/formateur.component';
import {FormateurRestService} from './services/formateur.rest.service';
import { MatiereComponent } from './matiere/matiere.component';
import {HttpClientModule} from '@angular/common/http';


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
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    RouterModule.forRoot(routesFormateur),
    HttpClientModule
  ],
  providers: [FormateurRestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
