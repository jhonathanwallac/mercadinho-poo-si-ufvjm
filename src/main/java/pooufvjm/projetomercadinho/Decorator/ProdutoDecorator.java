package pooufvjm.projetomercadinho.Decorator;

import java.util.Date;


/**
 * Classe abstrata da Interface (Decorator), ela implementa os métodos asbtratos
 * da Classe interface, além de implementar os métodos abstratos da interface,
 * ela decora a interface, permitindo fornecer uma base para a classe subsequente
 * que vai alteerar a estrutura da interface em tempo de execução.
 */
public abstract class ProdutoDecorator implements ProdutoInterface{
    // Atributo da classe
    private Produto produtoDecorado;
    
    // Construtor Padrão
    public ProdutoDecorator(Produto produtoDecorado){
        this.produtoDecorado = produtoDecorado;
    }
    
    public Produto getProdutoDecorado(){
        return produtoDecorado;
    }
    
    public void setProdutoDecorado(Produto produtoDecorado){
        this.produtoDecorado = produtoDecorado;
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public int getIdProduto() {
        return produtoDecorado.getIdProduto();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getNome() {
        return produtoDecorado.getNome();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public Date getDataFabricacao() {
        return produtoDecorado.getDataFabricacao();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public Date getDataValidade() {
        return produtoDecorado.getDataValidade();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public float getPrecoCusto() {
        return produtoDecorado.getPrecoCusto();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public float getPreco() {
        return produtoDecorado.getPreco();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public int getQuantidade() {
        return produtoDecorado.getQuantidade();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getCategoria() {
        return produtoDecorado.getCategoria();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getFornecedor() {
        return produtoDecorado.getFornecedor();
    }
}
