import { Routes } from '@angular/router';
import { HomePage } from './features/feature/home-page/home-page';
import { LoginPage } from './features/feature/login-page/login-page';
import { DashboardProfessorComponent } from './features/feature/dashboard-professor/dashboard-professor';
import { DashboardAlunoComponent } from './features/feature/dashboard-aluno/dashboard-aluno';
import { MinhasTurmasComponent } from './features/feature/minhas-turmas/minhas-turmas';
import { CriarFormularioComponent } from './features/feature/criar-formulario/criar-formulario';
import { VisaoDadosTurmaComponent } from './features/feature/visao-dados-turma/visao-dados-turma';
import { FormulariosAlunoComponent } from './features/feature/formularios-aluno/formularios-aluno';
import { ResponderFormularioComponent } from './features/feature/responder-formulario/responder-formulario';


export const routes: Routes = [
    {
        path: '',
        component: HomePage
    },
    {
        path: 'login',
        component: LoginPage
    },
    // Rotas do Professor
    {
        path: 'professor/dashboard',
        component: DashboardProfessorComponent
    },
    {
        path: 'professor/turmas',
        component: MinhasTurmasComponent
    },
    {
        path: 'professor/criar-formulario',
        component: CriarFormularioComponent
    },
    {
        path: 'professor/visao-dados-turma',
        component: VisaoDadosTurmaComponent
    },

    // Rotas do Aluno
    {
        path: 'aluno/dashboard',
        component: DashboardAlunoComponent
    },
    {
        path: 'aluno/formularios',
        component: FormulariosAlunoComponent
    },
    // 2. Adicione a nova rota
    {
        path: 'aluno/responder-formulario',
        component: ResponderFormularioComponent
    }
];