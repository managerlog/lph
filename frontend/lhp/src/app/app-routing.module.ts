import { AntropometriaComponent } from './antropometria/antropometria.component';
import { NutricionistaComponent } from './nutricionista/nutricionista.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfissaoComponent } from './profissao/profissao.component';
import { NivelSocioeconomicoComponent } from './nivel-socioeconomico/nivel-socioeconomico.component';
import { PacienteComponent } from './paciente/paciente.component';

const routes: Routes = [
  { path: 'nutricionista', component: NutricionistaComponent },
  { path: 'profissao', component: ProfissaoComponent},
  { path: 'nivel-socioeconomico', component: NivelSocioeconomicoComponent},
  { path: 'paciente', component: PacienteComponent},
  { path: 'antropometria', component: AntropometriaComponent},
  { path: '', pathMatch: 'full', redirectTo: 'app' },
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
