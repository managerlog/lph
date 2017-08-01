import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-nivel-socioeconomico',
  templateUrl: './nivel-socioeconomico.component.html',
  styleUrls: ['./nivel-socioeconomico.component.css']
})
export class NivelSocioeconomicoComponent implements OnInit {

  formularioDeNivelSocioEconomico: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: Http) {}

  ngOnInit() {
    this.formularioDeNivelSocioEconomico = this.formBuilder.group({
      nivel: [null, Validators.required]
    });
  }

  onSubmit() {
    console.log(this.formularioDeNivelSocioEconomico.value);

    if (this.formularioDeNivelSocioEconomico.valid) {
      this.http
        .post(
          'http://192.168.0.28:8080/lph/rest/nivel/salvar/',
          this.formularioDeNivelSocioEconomico.value
        )
        .map(res => res)
        .subscribe(
          dados => {
            console.log(dados);

            // Reseta o formulário depois do response
            this.resetForm();
          },
          (error: any) => alert('erro')
        );
    } else {
      console.log('Formulário Inválido');
      this.verifyValidationForm(this.formularioDeNivelSocioEconomico);
    }
  }

  verifyValidationForm(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(campo => {
      console.log(campo);
      const controle = formGroup.get(campo);
      controle.markAsDirty();
      if (controle instanceof FormGroup) {
        this.verifyValidationForm(controle);
      }
    });
  }

  aplicarCssErro(campo: string) {
    return {
      'has-error': this.verifcarValidTouched(campo),
      'has-feedback': this.verifcarValidTouched(campo)
    };
  }

  verifcarValidTouched(campo: string) {
    return (
      !this.formularioDeNivelSocioEconomico.get(campo).valid &&
      (this.formularioDeNivelSocioEconomico.get(campo).touched ||
        this.formularioDeNivelSocioEconomico.get(campo).dirty)
    );
  }

  resetForm() {
    this.formularioDeNivelSocioEconomico.reset();
  }
}
