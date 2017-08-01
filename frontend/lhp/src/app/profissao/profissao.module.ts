import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { HttpModule } from '@angular/http';
import { ProfissaoComponent } from './profissao.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    SharedModule,
    HttpModule
  ],
  declarations: [
    ProfissaoComponent
  ]
})
export class ProfissaoModule { }
