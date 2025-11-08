export interface Cadastro{
    id: number;
    username: string;
    password: string;
    cpf: string;
    email: string;
    tipoUsuario: {
        id: number,
        descricao: string
    };
    turma?: {
        id: number,
        serie: string,
        nivel_ensino: {
            id: number,
            descricao: string
        }
    };
}