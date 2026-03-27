package pooufvjm.projetomercadinho;

/**
 * A classe Colaborador representa um colaborador no sistema, estendendo a classe Pessoa.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Colaborador extends Pessoa {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    // Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador.
    private String login;
    private String senha;

    /**
     * Construtor padrão que cria um Colaborador sem informações iniciais.
     */
    public Colaborador() {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super();
    }

    /**
     * Construtor que inicializa um Colaborador com informações detalhadas.
     *
     * @param login    O login do colaborador.
     * @param senha    A senha do colaborador.
     * @param nome     O nome do colaborador.
     * @param sobrenome O sobrenome do colaborador.
     * @param cpf      O CPF do colaborador.
     * @param email    O email do colaborador.
     */
    public Colaborador(String login, String senha, String nome, String sobrenome, String cpf, String email) {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super(nome, sobrenome, cpf, email);
        this.login = login;
        this.senha = senha;
    }

    /**
     * Obtém o login do colaborador.
     *
     * @return O login do colaborador.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login do colaborador.
     *
     * @param login O login do colaborador.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Obtém a senha do colaborador.
     *
     * @return A senha do colaborador.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do colaborador.
     *
     * @param senha A senha do colaborador.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Converte o Colaborador em uma representação de string.
     *
     * @return Uma string contendo informações sobre o Colaborador.
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