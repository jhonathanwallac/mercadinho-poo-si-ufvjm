package pooufvjm.projetomercadinho.Decorator;

 import java.util.Date;


/**
 * Classe Interface (Componente), ela fornece uma base dos métodos que deverão serem
 * utilizados pelas outras classes, utilizadas pelo padrão Decorator, como a classe
 * Produto(Componente Concreto), ProdutoDecorator(Decorator) e ProdutoPromocao(Decorator Concreto)
 */
public interface ProdutoInterface {

    /**
     * Métodos abstratos
     * @return 
     */
    public int getIdProduto();
    public String getNome();
    public Date getDataFabricacao();
    public Date getDataValidade();
    public float getPreco();
    public float getPrecoCusto();
    public int getQuantidade();
    public String getCategoria();
    public String getFornecedor();
    
}
