import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.css']
})
export class TemplateFormComponent implements OnInit {

  usuario: any = {
    nome: null,
    crn: null
  }

  onSubmit(form) {

    console.log(form);
    //form.value
    //console.log(this.usuario);

    this.htpp.post('https://httpbin.org/post', JSON.stringify(form.value))
    .map(res => res)
    .subscribe(dados => console.log(dados));
  }

  constructor(private htpp: Http) { }

  ngOnInit() {
  }

  verifcarValidTouched(campo) {
    return !campo.valid && campo.touched;
  }

  aplicarCssErro(campo) {
    return {
      'has-error': this.verifcarValidTouched(campo),
      'has-feedback': this.verifcarValidTouched(campo)
    }
  }

  consultarCEP(cep, form) {
    //Nova variável "cep" somente com dígitos.
    var cep = cep.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {
      //Expressão regular para validar o CEP.
      var validacep = /^[0-9]{8}$/;
    }

    //Valida o formato do CEP.
    if (validacep.test(cep)) {

      this.htpp.get(`//viacep.com.br/ws/${cep}/json`)
        .map(dados => dados.json())
        .subscribe(dados => this.popularDadosForm(dados, form));
    }
  }

  popularDadosForm(dados, formulario) {

    /*formulario.setValue({
      nome: formulario.value.nome,
      crn: formulario.value.crn,
      endereco: {
        logradouro: dados.logradouro,
        cep: dados.cep,
        numero: '',
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        uf: dados.uf
      }
    });*/

    formulario.form.patchValue({
      endereco: {
        logradouro: dados.logradouro,
        cep: dados.cep,
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        uf: dados.uf
      }
    });    
    
    //console.log(formulario);
  }
}
