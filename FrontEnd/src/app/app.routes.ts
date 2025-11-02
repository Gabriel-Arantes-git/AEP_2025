import { Routes } from '@angular/router';
import { HomePage } from './features/feature/home-page/home-page';
import { LoginPage } from './features/feature/login-page/login-page';

export const routes: Routes = [
    {
        path: '',
        component: HomePage
    },
    {
        path: 'login',
        component: LoginPage
    }
];
