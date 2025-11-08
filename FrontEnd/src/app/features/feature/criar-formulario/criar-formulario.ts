import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'; // Importa o Reactive Forms
import { CommonModule } from '@angular/common'; // Importa o CommonModule para *ngIf, etc.
import { CadastroState } from '../../state/cadastro.state';

@Component({
  selector: 'app-criar-formulario',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    ReactiveFormsModule // Adiciona aqui para poder usar formGroup, formControlName
  ],
  templateUrl: './criar-formulario.html',
  styleUrls: ['./criar-formulario.scss']
})
export class CriarFormularioComponent {
  addQuestao = false;
  private state = inject(CadastroState);
  adicionarQuestao(){
    this.addQuestao = true;
  }

  removerQuestao(){
    this.addQuestao = false;
  }


  enviar(){
    this.state.novaLista = true;
  }
}