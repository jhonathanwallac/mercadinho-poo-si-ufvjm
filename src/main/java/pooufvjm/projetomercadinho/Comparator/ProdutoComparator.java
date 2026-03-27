package pooufvjm.projetomercadinho.Comparator;

import java.util.Comparator;
import pooufvjm.projetomercadinho.Decorator.Produto;


/**
 * Classe ProdutoComparator é utilizada para comparar dois objetos da coleção de produtos.
 * Possui o método de Compare. 
 * 
 * O método compare, recebe 2 elementos de produto, estes elementos, como o próprio nome da classe sugere,
 * serão comparados dentre seus atributos e retornado esta comparação.
 * 
 * A primeira comparação é sobre o nome dos produtos, caso eles sejam iguais, é para retornar seus 
 * fornecedores, se for falso, retorna a comparação dos seus nomes.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Comparator.
 */
public class ProdutoComparator implements Comparator<Produto> {
    
    @Override
    /** 
     * Método para verificar se os nomes são iguais
     */
    public int compare(Produto p1, Produto p2){
        // Se forem iguais, retorna a comparação do fornecedor...
        if((p1.getNome().compareTo(p2.getNome())) == 0){
            return p1.getFornecedor().compareTo(p2.getFornecedor());
        }
        // Senão, dos próprios nomes.
        else{
            return p1.getNome().compareTo(p2.getNome());
        }
    }
}
