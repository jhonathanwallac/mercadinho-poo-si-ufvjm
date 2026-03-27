package pooufvjm.projetomercadinho;

/**
 * A classe Administrador representa um colaborador com acesso a funções exclusivas no sistema.
 * Estende a classe Colaborador.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Administrador extends Colaborador {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    // Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador.
    
    /**
     * Construtor que inicializa um Administrador com as informações básicas.
     *
     * @param login    O login do administrador.
     * @param senha    A senha do administrador.
     * @param nome     O nome do administrador.
     * @param sobrenome O sobrenome do administrador.
     * @param cpf      O CPF do administrador.
     * @param email    O email do administrador.
     */
    public Administrador(String login, String senha, String nome, String sobrenome, String cpf, String email) {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super(login, senha, nome, sobrenome, cpf, email);
    }

    /**
     * Construtor padrão que cria um Administrador sem informações iniciais.
     */
    public Administrador() {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super();
    }

    /**
     * Converte o Administrador em uma representação de string.
     *
     * @return Uma string contendo informações sobre o Administrador.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        
        return "\n"
                + "Nome: " + getNome() + "\n"
                + "Sobrenome: " + getSobrenome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Login: " + getLogin() + "\n"
                + "Senha: " + getSenha();
    }
}
