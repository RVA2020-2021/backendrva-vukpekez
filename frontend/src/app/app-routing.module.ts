import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ObrazovanjeComponent} from "./components/obrazovanje/obrazovanje.component";
import {PreduzeceComponent} from "./components/preduzece/preduzece.component";
import {SektorComponent} from "./components/sektor/sektor.component";

const routes: Routes = [
  { path: 'obrazovanje', component: ObrazovanjeComponent},
  { path: 'preduzece', component: PreduzeceComponent },
  { path: 'sektor', component: SektorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
