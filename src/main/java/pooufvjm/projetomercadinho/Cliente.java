package pooufvjm.projetomercadinho;

/**
 * A classe Cliente representa um cliente no sistema, estendendo a classe Pessoa.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Cliente extends Pessoa{
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    private String apelido;
    private String endereco;
    private String telefone;
    
    /**
     * Atributo private static e métodos get e set implementados.
     */
    private static int instanciasCriadasMetodoUm = 0;
    // Questão 11: Criar duas variáveis de classe (static) que irão armazenar quantas instâncias foram criadas do tipo Cliente usando duas soluções diferentes.
    // Questão 11.a): Uma delas utilizando o enfoque de encapsulamento de acordo com a engenharia de software (atributo private static e métodos get e set).

    /**
     * Atributo com controle de acesso do tipo protect.
     */
    protected static int instanciasCriadasMetodoDois = 0;
    // Questão 11: Criar duas variáveis de classe (static) que irão armazenar quantas instâncias foram criadas do tipo Cliente usando duas soluções diferentes.
    // Questão 11.b): Na segunda estratégia, implementar usando o controle de acesso do tipo protect.
    
    /**
     * Construtor padrão que cria um Cliente sem informações iniciais.
     * Incrementa ambos os contadores de instâncias criados a partir das duas estratégias.
     */
    public Cliente() {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super();
        instanciasCriadasMetodoUm++;
        instanciasCriadasMetodoDois++;
    }
    
    /**
     * Construtor que inicializa um Cliente com informações detalhadas.
     * Incrementa o contador de instâncias criadas pelos dois métodos de controle.
     *
     * @param apelido   O apelido do cliente.
     * @param endereco  O endereço do cliente.
     * @param telefone  O telefone do cliente.
     * @param nome      O nome do cliente.
     * @param sobrenome O sobrenome do cliente.
     * @param cpf       O CPF do cliente.
     * @param email     O email do cliente.
     */
    public Cliente(String apelido, String endereco, String telefone, String nome, String sobrenome, String cpf, String email) {
        // Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses.
        super(nome, sobrenome, cpf, email);
        instanciasCriadasMetodoUm++;
        instanciasCriadasMetodoDois++;
        this.apelido = apelido;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    /**
     * Método utilizado para incrementar a partir do momento que uma instância é criada.
     * Solução 1: Atributo private static e métodos get e set.
     * Vantagens: Controle mais preciso do acesso à variável, segurança.
     * Desvantagens: Aumento de quantidade de código e de complexidade.
     */
    public static void incrementaInstanciasCriadasMetodoUm(){
        instanciasCriadasMetodoUm++;
    }
    // Questão 11.c): Explique quais são as vantagens e desvantagens de cada uma das duas estratégias.
    
    
    /**
     * Método utilizado para incrementar a partir do momento que uma instância é criada.
     * Atributo com controle de acesso do tipo protect.
     * Vantagens: Simplicidade de código e acesso direto em subclasses.
     * Desvantagens: Menos controle e menor flexibilidade.
     */
    protected static void incrementaInstanciasCriadasMetodoDois(){
        instanciasCriadasMetodoDois++;
    }
    // Questão 11.c): Explique quais são as vantagens e desvantagens de cada uma das duas estratégias.

/**
     * Obtém o apelido do cliente.
     *
     * @return O apelido do cliente.
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Define o apelido do cliente.
     *
     * @param apelido O apelido do cliente.
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * Obtém o endereço do cliente.
     *
     * @return O endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param endereco O endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o telefone do cliente.
     *
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param telefone O telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o número de instâncias criadas pelo Método 1.
     *
     * @return O número de instâncias criadas pelo Método 1.
     */
    public static int getInstanciasCriadasMetodoUm() {
        return instanciasCriadasMetodoUm;
    }
    // Questão 11.a): Uma delas utilizando o enfoque de encapsulamento de acordo com a engenharia de software (atributo private static e métodos get e set).

    /**
     * Define o número de instâncias criadas pelo Método 1.
     *
     * @param instanciasCriadasMetodoUm O número de instâncias criadas pelo Método 1.
     */
    public static void setInstanciasCriadasMetodoUm(int instanciasCriadasMetodoUm) {
        Cliente.instanciasCriadasMetodoUm = instanciasCriadasMetodoUm;
    }
    // Questão 11.a): Uma delas utilizando o enfoque de encapsulamento de acordo com a engenharia de software (atributo private static e métodos get e set).
    
    /**
     * Converte o Cliente em uma representação de string.
     *
     * @return Uma string contendo informações sobre o Cliente.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        return "\n"
                + "Nome: " + getNome() + "\n"
                + "Sobrenome: " + getSobrenome() + "\n"
                + "CPF (ID do cliente): " + getCpf() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Apelido: " + getApelido() + "\n"
                + "Endereco: " + getEndereco() + "\n"
                + "Telefone: " + getTelefone();
    }
}
