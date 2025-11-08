import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'; // Para o formulário de resposta
import { CommonModule } from '@angular/common'; // Para *ngIf, *ngFor
import { CadastroState } from '../../state/cadastro.state';

@Component({
  selector: 'app-responder-formulario',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    ReactiveFormsModule // Adiciona para o (ngSubmit) e formControlName
  ],
  templateUrl: './responder-formulario.html',
  styleUrls: ['./responder-formulario.scss']
})
export class ResponderFormularioComponent {
  private state = inject(CadastroState);

  enviarMudanca(){
    this.state.questionario = !this.state.questionario;
  }
}