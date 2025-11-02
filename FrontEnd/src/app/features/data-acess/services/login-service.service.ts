import { HttpClient, HttpParams } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { environment } from "../../../environments/environment";
import { Cadastro } from "../entities/Cadastro";

@Injectable({
    providedIn:'root'
})
export class CadastroService{
    private http = inject(HttpClient);
    private api = environment.apiUrl;

    login(email: string, senha: string){
        let params = new HttpParams().set('email',email).set('password',senha);

        return this.http.get<Cadastro>(
            `${this.api}/auth/login`,{params});
    }
}