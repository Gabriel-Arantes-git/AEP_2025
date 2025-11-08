import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CadastroState } from '../../state/cadastro.state';
import { PieGraphicComponent } from '../../../shared/ui/pie-graphic/pie-graphic.component';

@Component({
  selector: 'app-dashboard-professor',
  standalone: true,
  imports: [CommonModule, RouterLink, PieGraphicComponent],
  templateUrl: './dashboard-professor.html',
  styleUrls: ['./dashboard-professor.scss']
})
export class DashboardProfessorComponent {
  private state = inject(CadastroState);

  professor = this.state.cadastro();

  get nome(){
    return this.professor?.username;
  }

  get novaLista(){

    return this.state.novaLista;
  }
}