import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { HttpModule } from '@angular/http';
import { AgendaComponent } from './agenda.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    SharedModule,
    HttpModule
  ],
  declarations: [
    AgendaComponent
  ]
})
export class AgendaModule { }
