import { NivelSocioeconomicoComponent } from './nivel-socioeconomico.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { HttpModule } from '@angular/http';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    SharedModule,
    HttpModule
  ],
  declarations: [
    NivelSocioeconomicoComponent
  ]
})
export class NivelSocioeconomicoModule { }
