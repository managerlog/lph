import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-profissao',
  templateUrl: './profissao.component.html',
  styleUrls: ['./profissao.component.css']
})
export class ProfissaoComponent implements OnInit {

  formularioDeProfissao: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: Http
  ) { }

  ngOnInit() {

    this.formularioDeProfissao = this.formBuilder.group({

      nome: [null, Validators.required],
    });
  }

   onSubmit() {
    console.log(this.formularioDeProfissao.value);

    if (this.formularioDeProfissao.valid) {
      this.http
        .post(
        'http://192.168.0.28:8080/lph/rest/profissao/salvar/',
        this.formularioDeProfissao.value
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
      this.verifyValidationForm(this.formularioDeProfissao);
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
      !this.formularioDeProfissao.get(campo).valid &&
      (this.formularioDeProfissao.get(campo).touched || this.formularioDeProfissao.get(campo).dirty)
    );
  }

  resetForm() {
    this.formularioDeProfissao.reset();
  }

}
