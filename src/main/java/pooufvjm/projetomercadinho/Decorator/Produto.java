package pooufvjm.projetomercadinho.Decorator;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * A classe Produto representa um item que pode ser comercializado no mercadinho.
 * 
 * Classe Concreta da Interface (Componente Concreto), ela implementa os métodos asbtratos
 * da Classe interface, implementando o produto de maneira concreta a interface, fornecida 
 * pela classe interface. No mercadinho, ela implementa os produtos em geral.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Produto implements ProdutoInterface {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    private int idProduto;
    private String nome;
    private Date dataFabricacao;
    private Date dataValidade;
    private float precoCusto;
    private float preco;
    private int quantidade;
    private String categoria;
    private String fornecedor;

    /**
     * Contador estático que registra o número total de instâncias da classe Produto criadas.
     */
    private static int instanciasCriadas = 0;

    /**
     * Construtor que inicializa um Produto com informações detalhadas.
     *
     * @param idProduto      O ID do produto.
     * @param nome           O nome do produto.
     * @param dataFabricacao A data de fabricação do produto.
     * @param dataValidade   A data de validade do produto.
     * @param precoCusto     O preço de custo do produto.
     * @param preco          O preço de venda do produto.
     * @param quantidade     A quantidade disponível do produto.
     * @param categoria      A categoria do produto.
     * @param fornecedor     O fornecedor do produto.
     */
    public Produto(int idProduto, String nome, Date dataFabricacao, Date dataValidade, float precoCusto, float preco, int quantidade, String categoria, String fornecedor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.precoCusto = precoCusto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        instanciasCriadas++;
    }

    /**
     * Construtor padrão que cria um Produto sem informações iniciais.
     * Incrementa o contador de instâncias criadas.
     */
    public Produto() {
        instanciasCriadas++;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém o ID do produto.
     *
     * @return O ID do produto.
     */
    @Override
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o ID do produto.
     *
     * @param idProduto O ID do produto.
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém a data de fabricação do produto.
     *
     * @return A data de fabricação do produto.
     */
    @Override
    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    /**
     * Define a data de fabricação do produto.
     *
     * @param dataFabricacao A data de fabricação do produto.
     */
    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém a data de validade do produto.
     *
     * @return A data de validade do produto.
     */
    @Override
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * Define a data de validade do produto.
     *
     * @param dataValidade A data de validade do produto.
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém o preço de custo do produto.
     *
     * @return O preço de custo do produto.
     */
    @Override
    public float getPrecoCusto() {
        return precoCusto;
    }

    /**
     * Define o preço de custo do produto.
     *
     * @param precoCusto O preço de custo do produto.
     */
    
    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém o preço de venda do produto.
     *
     * @return O preço de venda do produto.
     */
    @Override
    public float getPreco() {
        return preco;
    }

    /**
     * Define o preço de venda do produto.
     *
     * @param preco O preço de venda do produto.
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém a quantidade disponível do produto.
     *
     * @return A quantidade disponível do produto.
     */
    @Override
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade disponível do produto.
     *
     * @param quantidade A quantidade disponível do produto.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém a categoria do produto.
     *
     * @return A categoria do produto.
     */
    @Override
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria A categoria do produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método implementado a partir da classe interface, sobrescrevendo o método abstrato da Classe Interface    
     * 
     * Obtém o fornecedor do produto.
     * 
     * @return O fornecedor do produto.
     */
    @Override
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * Define o fornecedor do produto.
     *
     * @param fornecedor O fornecedor do produto.
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * Obtém o número total de instâncias da classe Produto criadas.
     *
     * @return O número total de instâncias da classe Produto criadas.
     */
    public static int getInstanciasCriadas() {
        return instanciasCriadas;
    }

    /**
     * Converte o Produto em uma representação de string.
     *
     * @return Uma string contendo informações sobre o Produto.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        
        DecimalFormat formatoDecimal = new DecimalFormat("#0.00");

        return "\n"
                + "\n"
                + "Id do produto: " + getIdProduto() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Data de fabricacao: " + getDataFabricacao() + "\n"
                + "Data de validade: " + getDataValidade() + "\n"
                + "Preco: " + formatoDecimal.format(getPreco()) + "\n"
                + "Categoria: " + getCategoria() + "\n"
                + "Fornecedor: " + getFornecedor();
    }
}
