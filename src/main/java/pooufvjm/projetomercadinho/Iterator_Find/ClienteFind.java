package pooufvjm.projetomercadinho.Iterator_Find;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pooufvjm.projetomercadinho.Cliente;
import pooufvjm.projetomercadinho.Comparator.ClienteComparator;

/**
 * Classe ClienteFind é utilizada para buscar um cliente em especifico, ela faz isso 
 * percorrendo toda a lista de clientes, ordernada pelo nome, ela ordena a lista de clientes
 * utilizando a estrutura ClienteComparator, após isto, ela percorre a lista de clientes 
 * e retornando os clientes, cuja nome foram passados por parametros sejam iguais aos nomes da classe cliente.
 * 
 * Foram adicionados 2 métodos a esta classe, 2 métodos distintos mas que têem a mesma função.
 * 
 * O primeiro método É para buscar o cliente utilizando a estrutura While e o Iterator de maneira 
 * explicita, então ele cria uma váriavel do tipo iterator, e através desta variável, é feita todas 
 * as manipulações da coleção.
 * 
 * O segundo método, é utilizando a estrutura ForEach, sua principal vantagem é a não necessidade de 
 * utilizar o Iterator de maneira explicita, a própria estrutura itera sobre os elementos da coleção, 
 * tornando o código mais clean e de fácil compreenção.
 * 
 * Vale ressaltar que ambas abordagem solucionam o problema e executam a mesma função, cabe então ao
 * programador avaliar a situação e optar por uma ou outra!
 */
public class ClienteFind {
    // Método para Buscar cliente
    public Cliente clienteFind(String nome, List<Cliente> client){
        // Ordenar a coleção pelo nome, utilizando o ClienteComparator
        Collections.sort(client, new ClienteComparator());
        
        // Utilizando o Iterator para percorrer a lista de Clientes
        Iterator<Cliente> clienteIterator = new ClienteIterator(client);
        
        /* Laço utilizando o Iterator para percorrer a lista de clientes e retornar aquele
           cliente cujo nome é igual ao da coleção de clientes.*/
        while(clienteIterator.hasNext()){
            Cliente cliente = clienteIterator.next();
            if(cliente.getNome().compareTo(nome)== 0){
                return cliente;
            }
            else{
                return null;
            }
        }
        return null;
    } 
    
    public Cliente clienteFindForEach(String nome, List<Cliente> client){
        
        // Ordenar a coleção pelo nome, utilizando o ClienteComparator
        Collections.sort(client, new ClienteComparator());
        
        /*Laço foreach itera automaticamente sobre os elementos da coleção
          sem a necessidade de utilizar um iterator de maneira explicita
          tornando o código mais clean*/
        for(Cliente cliente: client){
            
            // Condição verifica se o nome do cliente é igual ao digitado
            if(cliente.getNome().equals(nome)){
                return cliente;
            }else{
                // Caso não seja igual, ele retorna null
                return null;
            }
        }
        // Caso não encontre cliente, retorne nulo
        return null;
    }
}
