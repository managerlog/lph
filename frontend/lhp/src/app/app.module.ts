import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NutricionistaModule } from './nutricionista/nutricionista.module';
import { ProfissaoModule } from './profissao/profissao.module';
import { NivelSocioeconomicoModule } from './nivel-socioeconomico/nivel-socioeconomico.module';
import { PacienteModule } from './paciente/paciente.module';
import { AntropometriaModule } from './antropometria/antropometria.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    NutricionistaModule,
    ProfissaoModule,
    NivelSocioeconomicoModule,
    PacienteModule,
    AntropometriaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
