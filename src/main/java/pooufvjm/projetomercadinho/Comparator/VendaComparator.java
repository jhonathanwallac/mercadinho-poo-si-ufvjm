package pooufvjm.projetomercadinho.Comparator;

import java.util.Comparator;
import pooufvjm.projetomercadinho.Venda;


/**
 * Classe VendaComparator é utilizada para comparar dois objetos da coleção de vendas.
 * Possui o método de Compare. 
 * 
 * O método compare, recebe 2 elementos de venda, estes elementos, como o próprio nome da classe sugere,
 * serão comparados dentre seus atributos e retornado esta comparação.
 * 
 * A primeira comparação é sobre o cpf do comprador, caso eles sejam iguais, é para retornar o 
 * nome do comprador, se for falso, retorna a comparação do seu CPF.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Comparator.
 */
public class VendaComparator implements Comparator<Venda>{
    
    @Override
    /** 
     * Método para verificar se as categorias são iguais
     */
    public int compare(Venda v1, Venda v2){
      // Se forem iguais, retorna a comparação do nome do comprador...
        if((v1.getCpfComprador().compareTo(v2.getCpfComprador())) == 0){
            return v1.getNomeComprador().compareTo(v2.getNomeComprador());
        }
        else{
            // Senão, dos próprios CPFs.
            return v1.getCpfComprador().compareTo(v2.getCpfComprador());
        }
    }
}
