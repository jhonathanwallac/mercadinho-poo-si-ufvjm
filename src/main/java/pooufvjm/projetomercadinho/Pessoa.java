package pooufvjm.projetomercadinho;

/**
 * A classe Pessoa representa uma pessoa no sistema, esta classe é herdada pelas classes Cliente e Colaborador, sendo a última herdada por Administrador.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Pessoa {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    
    /**
     * Contador estático que registra o número total de instâncias da classe Pessoa criadas.
     */
    private static int numPessoas = 0;

    /**
     * Construtor que inicializa uma Pessoa com informações detalhadas.
     *
     * @param nome      O nome da pessoa.
     * @param sobrenome O sobrenome da pessoa.
     * @param cpf       O CPF da pessoa.
     * @param email     O email da pessoa.
     */
    public Pessoa(String nome, String sobrenome, String cpf, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
    }

    /**
     * Construtor padrão que cria uma Pessoa sem informações iniciais.
     * Incrementa o contador de pessoas criadas.
     */
    public Pessoa() {
        numPessoas++;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome O nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o sobrenome da pessoa.
     *
     * @return O sobrenome da pessoa.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o sobrenome da pessoa.
     *
     * @param sobrenome O sobrenome da pessoa.
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * Obtém o CPF da pessoa.
     *
     * @return O CPF da pessoa.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cpf O CPF da pessoa.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém o email da pessoa.
     *
     * @return O email da pessoa.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da pessoa.
     *
     * @param email O email da pessoa.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o número de pessoas criadas.
     *
     * @return O número de pessoas criadas.
     */
    public static int getNumPessoas() {
        return numPessoas;
    }

    /**
     * Define o número de pessoas criadas.
     *
     * @param numPessoas O número de pessoas criadas.
     */
    public static void setNumPessoas(int numPessoas) {
        Pessoa.numPessoas = numPessoas;
    }

    /**
     * Converte a Pessoa em uma representação de string.
     *
     * @return Uma string contendo informações sobre a Pessoa.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        
        return "\n"
                + "Nome: " + getNome() + "\n"
                + "Sobrenome: " + getSobrenome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Email: " + getEmail();
    }
}
