package pooufvjm.projetomercadinho.Iterator_Find;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pooufvjm.projetomercadinho.Cliente;


/**
 * Classe ClienteIterator é utilizada para iterar sobre a coleção de clientes, possui métodos de next,
 * hasNext e Remove. Tudo isso para trabalhar com coleções.
 * 
 * O método next, vérifica se a coleção está vázia e retorna o próximo elemento da coleção;
 * O método hasNext verifica se a coleção possuí *algum elemento e retorna se possuí ou não, de maneira booleana;
 * O método Remove é utilizado para remover os elementos da coleção.
 * 
 * Vale ressaltar que todos estes métodos foram sobrescritos e implementados a partir da classe abstrata Iterator.
 */
public class ClienteIterator implements Iterator{
    private List<Cliente> cliente = new ArrayList<>();
    private int pos = 0;
    
    // Construtor Padrão
    public ClienteIterator(List<Cliente> cliente){
        this.cliente = cliente;
    }
    
    //Método hasNext verifica se existe próximo elemento elemento na coleção
    @Override
    public boolean hasNext() {
        if(pos>=cliente.size() || cliente.get(pos) == null)
        {
            return false;
        }
        else{
            return true;
        }
    }
    
    // Método next retorna o próximo elemento da coleção
    @Override
    public Cliente next() {
        Cliente cliente = this.cliente.get(pos);
        pos++;
        return cliente;
    }
    
    // Método Remove remove um elemento da coleção
    // Método precisa ser verificado e testado
    @Override
    public void remove() {
        Iterator.super.remove(); 
    }
}