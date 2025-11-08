import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-visao-dados-turma',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink // Para os links de navegação
  ],
  templateUrl: './visao-dados-turma.html',
  styleUrls: ['./visao-dados-turma.scss']
})
export class VisaoDadosTurmaComponent {

}