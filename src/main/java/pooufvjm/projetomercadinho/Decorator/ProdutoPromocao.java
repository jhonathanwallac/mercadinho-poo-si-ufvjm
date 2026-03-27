package pooufvjm.projetomercadinho.Decorator;

import java.util.Date;

/**
 * Classe concreta do Decorator (Decorator Concreto), ela implementa os métodos asbtratos
 * da Classe Decorator, além de implementar os métodos abstratos do Decorator, adiciona
 * novos comportamentos, é capaz de alterar a estrutura da interface, porém sem alterar
 * a estrutura do componente concreto, pois ele é implementado a partir da classe
 * abstrata Decorator que implementa a interface.
 */
public class ProdutoPromocao extends ProdutoDecorator{
    // Atributo
    private float desconto;
    
    // Construtor
    public ProdutoPromocao(Produto produtoDecorado, float desconto){
        super(produtoDecorado);
        //this.produto = produto;
        this.desconto = desconto;
    }
    
    public float getDesconto(){
        return desconto;
    }
    
    public void setDesconto(float desconto){
        this.desconto = desconto;
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public int getIdProduto() {
        return super.getIdProduto();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getNome() {
        return super.getNome() + "(Promoção!!)";
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public Date getDataFabricacao() {
        return super.getDataFabricacao();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public Date getDataValidade() {
        return super.getDataValidade();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public float getPrecoCusto() {
        return super.getPrecoCusto();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public float getPreco() {
        return super.getPreco() * (1-desconto);
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public int getQuantidade() {
        return super.getQuantidade();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getCategoria() {
        return super.getCategoria();
    }
    
    // Método implementado a partir da classe interface, 
    // sobrescrevendo o método abstrato da Classe Interface
    @Override
    public String getFornecedor() {
        return super.getFornecedor();
    }
    
    //Método para retornar um objeto em forma de String
    @Override
    public String toString() {
        return 
                "Produto: " + super.getProdutoDecorado() + "\n"
                + "Preço Original: " + super.getPreco() + "\n"
                + "Porcentagem Desconto: " + getDesconto() + "\n" 
                + "Preço Descontado: " + getPreco();
    }

}
