import { Injectable, signal } from "@angular/core";
import { Cadastro } from "../data-acess/entities/Cadastro";
import { CadastroService } from "../data-acess/services/login-service.service";

@Injectable({
  providedIn: "root"})
export class CadastroState {

    private _cadastro = signal<Cadastro | null>(null);

    credencialIncorreta = false;
    cadastro = this._cadastro.asReadonly();

    constructor(private cadastroService: CadastroService) {
    }

    login(email:string,senha:string){
        this.cadastroService.login(email,senha).subscribe({
            next: (cadastro) => {
                this._cadastro.set(cadastro);
                this.credencialIncorreta = false;
            },
            error: (err) => {
                console.error('Error loading users:', err);
                this.credencialIncorreta = true;
            }
        })
    }
}