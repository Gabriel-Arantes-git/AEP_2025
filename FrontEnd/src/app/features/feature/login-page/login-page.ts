import { Component, computed, inject, signal } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule, NgClass } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators, FormsModule } from '@angular/forms';
import { DropdownOpcoesComponent } from '../../../shared/ui/dropdown-opcoes/dropdown-opcoes.component';
import { CadastroState } from '../../state/cadastro.state';

type Aba = 'login' | 'cadastro';
type TipoUsuario = 'aluno' | 'professor';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgClass, DropdownOpcoesComponent, FormsModule],
  templateUrl: './login-page.html',
  styleUrls: ['./login-page.scss'], 
})
export class LoginPage {
  private fb = inject(FormBuilder);
  private state = inject(CadastroState);
  input= [{descricao:"1º Ano A"},{descricao:"1º Ano B"},{descricao:"1º Ano C"},{descricao:"2º Ano A"},{descricao:"2º Ano B"},{descricao:"3º Ano A"}];
  aba = signal<Aba>('login');

  email: string = '';
  senha: string = '';

  get loginInvalido(){
    return this.state.credencialIncorreta;
  }
 

  cadastroForm = this.fb.group({
    tipoUsuario: this.fb.control<TipoUsuario>('aluno', { nonNullable: true }),
    nome: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    cpf: ['', [Validators.required]],
    senha: ['', [Validators.required, Validators.minLength(4)]],
  });

  isLogin = computed(() => this.aba() === 'login');
  isCadastro = computed(() => this.aba() === 'cadastro');

  isAluno = computed(() => this.cadastroForm.get('tipoUsuario')?.value === 'aluno');
  labelEmail = computed(() => (this.isAluno() ? 'Email (Educacional)' : 'Email (Educador)'));
  placeholderEmail = computed(() => (this.isAluno() ? 'nome.sobrenome@aluno.com' : 'nome.sobrenome@educador.com'));

  abrirLogin() { this.aba.set('login'); }
  abrirCadastro() { this.aba.set('cadastro'); }


  onSubmitLogin() {

    if(this.email != '' && this.senha != ''){
      
      this.state.login(this.email,this.senha);
    }

   
  }

  onSubmitCadastro() {
    
  }
}
