package pooufvjm.projetomercadinho.Comparator;

import java.util.Comparator;
import pooufvjm.projetomercadinho.Decorator.Produto;


/**
 * Classe ProdutoComparatorCategoria é utilizada para comparar dois objetos da coleção de produtos.
 * Possui o método de Compare. 
 * 
 * O método compare, recebe 2 elementos de produto, estes elementos, como o próprio nome da classe sugere,
 * serão comparados dentre seus atributos e retornado esta comparação.
 * 
 * A primeira comparação é sobre o nome dos produtos, caso eles sejam iguais, é para retornar seus 
 * nomes, se for falso, retorna a comparação das suas categorias.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Comparator.
 */
public class ProdutoComparatorCategoria implements Comparator<Produto>{
    
    @Override
    /** 
     * Método para verificar se as categorias são iguais
     */
    public int compare(Produto p1, Produto p2){
        // Se forem iguais, retorna a comparação do nome do produto...
        if((p1.getCategoria().compareTo(p2.getCategoria())) == 0){
            return p1.getNome().compareTo(p2.getNome());
        }
        else{
            // Senão, das próprias categorias.
            return p1.getCategoria().compareTo(p2.getCategoria());
        }
    }
}
