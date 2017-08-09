import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-antropometria',
  templateUrl: './antropometria.component.html',
  styleUrls: ['./antropometria.component.css']
})
export class AntropometriaComponent implements OnInit {

  formularioDeAntropometria: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: Http
  ) { }

  ngOnInit() {
  }

}
