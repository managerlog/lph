import { Component, OnInit } from '@angular/core';
import { EstadoBr } from './../shared/models/estado-br';
import { DropdownService } from './../shared/services/dropdown.service';
import { Http } from '@angular/http';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators
} from '@angular/forms';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-nutricionista',
  templateUrl: './nutricionista.component.html',
  styleUrls: ['./nutricionista.component.css']
})
export class NutricionistaComponent implements OnInit {
  formulario: FormGroup;
  estado: EstadoBr[];

  constructor(
    private formBuilder: FormBuilder,
    private http: Http,
    private dropDownService: DropdownService
  ) { }

  ngOnInit() {

    this.dropDownService.getEstadosBr().subscribe(dados => {
      this.estado = dados;
      console.log(dados);
    });

    this.formulario = this.formBuilder.group({

      nome: [null, Validators.required],
      crn: [null, Validators.required],

      credenciais: this.formBuilder.group({
        email: [null, Validators.required],
        senha: [null, Validators.required],
      }),


      endereco: this.formBuilder.group({
        cep: [null, Validators.required],
        numero: [null, Validators.required],
        complemento: [null],
        logradouro: [null, Validators.required],
        bairro: [null, Validators.required],
        cidade: [null, Validators.required],
        uf: [null, Validators.required]
      })
    });
  }

  onSubmit() {
    console.log(this.formulario.value);

    if (this.formulario.valid) {
      this.http
        .post(
        'http://192.168.0.28:8080/lph/rest/nutricionistas/salvar/',
        this.formulario.value
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
      this.verifyValidationForm(this.formulario);
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

  resetForm() {
    this.formulario.reset();
  }

  verifcarValidTouched(campo: string) {
    return (
      !this.formulario.get(campo).valid &&
      (this.formulario.get(campo).touched || this.formulario.get(campo).dirty)
    );
  }

  aplicarCssErro(campo: string) {
    return {
      'has-error': this.verifcarValidTouched(campo),
      'has-feedback': this.verifcarValidTouched(campo)
    };
  }

  consultarCEP() {
    let cep = this.formulario.get('endereco.cep').value;
    // Nova variável "cep" somente com dígitos.
    cep = cep.replace(/\D/g, '');

    // Verifica se campo cep possui valor informado.
    if (cep != '') {
      // Expressão regular para validar o CEP.
      var validacep = /^[0-9]{8}$/;
    }

    // Valida o formato do CEP.
    if (validacep.test(cep)) {
      this.http
        .get(`//viacep.com.br/ws/${cep}/json`)
        .map(dados => dados.json())
        .subscribe(dados => this.popularDadosForm(dados));
    }
  }

  popularDadosForm(dados) {

    this.formulario.patchValue({
      endereco: {
        logradouro: dados.logradouro,
        // cep: dados.cep,
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        uf: dados.uf
      }
    });
    // console.log(formulario);
  }
}
