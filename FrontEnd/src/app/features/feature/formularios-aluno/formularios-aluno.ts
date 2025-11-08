import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common'; // Para *ngIf, *ngFor, etc.

@Component({
  selector: 'app-formularios-aluno',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink // Para os links de navegação
  ],
  templateUrl: './formularios-aluno.html',
  styleUrls: ['./formularios-aluno.scss']
})
export class FormulariosAlunoComponent {

}