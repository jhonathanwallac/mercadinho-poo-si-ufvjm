package pooufvjm.projetomercadinho.Comparator;

import java.util.Comparator;
import pooufvjm.projetomercadinho.Venda;

/**
 * Classe VendaComparatorStatus é utilizada para comparar dois objetos da coleção de vendas.
 * Possui o método de Compare. 
 * 
 * O método compare, recebe 2 elementos de venda, estes elementos, como o próprio nome da classe sugere,
 * serão comparados dentre seus atributos e retornado esta comparação.
 * 
 * Este método irá retornar a comparação dos status de venda dos 2 objetos da coleção de vendas.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Comparator.
 */
public class VendaComparatorStatus implements Comparator<Venda> {
    
    @Override      
    /**
     * Método para comparar os status da venda entre 2 elementos e retornar seus respectivos status
     */
    public int compare(Venda v1, Venda v2){
        return v1.getStatusVenda().compareTo(v2.getStatusVenda());
    }
}
