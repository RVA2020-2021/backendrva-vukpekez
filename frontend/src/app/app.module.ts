import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ObrazovanjeComponent } from './components/obrazovanje/obrazovanje.component';
import { PreduzeceComponent } from './components/preduzece/preduzece.component';
import { RadnikComponent } from './components/radnik/radnik.component';
import { SektorComponent } from './components/sektor/sektor.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatExpansionModule} from "@angular/material/expansion";
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatInputModule} from '@angular/material/input';
import { ObrazovanjeDialogComponent } from './components/dialogs/obrazovanje-dialog/obrazovanje-dialog.component';
import { PreduzeceDialogComponent } from './components/dialogs/preduzece-dialog/preduzece-dialog.component';
import { RadnikDialogComponent } from './components/dialogs/radnik-dialog/radnik-dialog.component';
import { SektorDialogComponent } from './components/dialogs/sektor-dialog/sektor-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    ObrazovanjeComponent,
    PreduzeceComponent,
    RadnikComponent,
    SektorComponent,
    ObrazovanjeDialogComponent,
    PreduzeceDialogComponent,
    RadnikDialogComponent,
    SektorDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatExpansionModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    MatSelectModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
