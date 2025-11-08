import { Injectable, signal } from "@angular/core";
import { Cadastro } from "../data-acess/entities/Cadastro";
import { CadastroService } from "../data-acess/services/login-service.service";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root"})
export class CadastroState {

    private _cadastro = signal<Cadastro | null>(null);

    credencialIncorreta = false;
    cadastro = this._cadastro.asReadonly();
    questionario = false;
    novaLista = false;
    constructor(private cadastroService: CadastroService, private router: Router) {
    }

    login(email:string,senha:string){
        this.cadastroService.login(email,senha).subscribe({
            next: (cadastro) => {
                console.log(cadastro);
                this._cadastro.set(cadastro);
                this.credencialIncorreta = false;
                if(cadastro.tipoUsuario.descricao == "Aluno") this.router.navigateByUrl('/aluno/dashboard');
                if(cadastro.tipoUsuario.descricao == "Professor") this.router.navigateByUrl('/professor/dashboard');
            },
            error: (err) => {
                this.credencialIncorreta = true;
                console.error(err)
            }
        })
    }
}