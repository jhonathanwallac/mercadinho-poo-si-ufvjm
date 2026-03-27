package pooufvjm.projetomercadinho.Comparator;

import java.util.Comparator;
import pooufvjm.projetomercadinho.Cliente;


/**
 * Classe ClienteComparator é utilizada para comparar dois objetos da coleção de clientes.
 * Possui o método de Compare. 
 * 
 * O método compare, recebe 2 elementos de cliente, estes elementos, como o próprio nome da classe sugere,
 * serão comparados dentre seus atributos e retornado esta comparação.
 * 
 * A primeira comparação é sobre o nome dos clientees, caso elas sejam iguais, é para retornar seus 
 * sobrenomes, se for falso, retorna a comparação dos seus nomes.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Comparator.
 */
public class ClienteComparator implements Comparator<Cliente>{
    
    @Override
    /** 
     * Método para verificar se os nomes são iguais
     */
    public int compare(Cliente c1, Cliente c2){
        // Se forem iguais, retorna a comparação do sobrenome...
        if((c1.getNome().compareTo(c2.getNome())) == 0){
            return c1.getSobrenome().compareTo(c2.getSobrenome());
        }
        // Senão, dos próprios nomes.
        else{
            return c1.getNome().compareTo(c2.getSobrenome());
        }
    }
}
