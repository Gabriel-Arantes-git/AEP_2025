import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CadastroState } from '../../state/cadastro.state';
import { Cadastro } from '../../data-acess/entities/Cadastro';
import { PieGraphicComponent } from '../../../shared/ui/pie-graphic/pie-graphic.component';
import { BarGraphicComponent } from '../../../shared/ui/bar-graphic/bar-graphic.component';

@Component({
  selector: 'app-dashboard-aluno',
  standalone: true,
  imports: [CommonModule, RouterLink,PieGraphicComponent,BarGraphicComponent],
  templateUrl: './dashboard-aluno.html',
  styleUrls: ['./dashboard-aluno.scss']
})
export class DashboardAlunoComponent {
  private state = inject(CadastroState);

  aluno = this.state.cadastro();

  get nome(){
    return this.aluno?.username;
  }

  get turma(): string {
    return `${this.aluno?.turma?.nivel_ensino?.descricao ?? ''} ${this.aluno?.turma?.serie ?? ''}`.trim();
  }

  get situacaoQuestao(){
    return this.state.questionario;
  }

}