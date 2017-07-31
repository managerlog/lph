import { NutricionistaComponent } from './nutricionista/nutricionista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'nutricionista', component: NutricionistaComponent },
  { path: '', pathMatch: 'full', redirectTo: 'index' },
  {
    path: '',
    children: []
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
