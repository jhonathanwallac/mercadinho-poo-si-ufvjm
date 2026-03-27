package pooufvjm.projetomercadinho;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import pooufvjm.projetomercadinho.Comparator.ProdutoComparator;
import pooufvjm.projetomercadinho.Comparator.ProdutoComparatorCategoria;
import pooufvjm.projetomercadinho.Comparator.VendaComparator;
import pooufvjm.projetomercadinho.Comparator.VendaComparatorStatus;
import pooufvjm.projetomercadinho.Decorator.Produto;
import pooufvjm.projetomercadinho.Decorator.ProdutoPromocao;
import pooufvjm.projetomercadinho.Iterator_Find.ClienteFind;
import pooufvjm.projetomercadinho.Iterator_Find.ClienteIterator;


/**
 * A classe Mercadinho é a classe principal que contém o método main para iniciar o sistema do mercadinho.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Mercadinho {
    private static List<String> listaCaixas = List.of("Caixa 01", "Caixa 02", "Caixa 03", "Caixa 04", "Caixa 05");
    private static List<Administrador> listaAdministradoresCadastrados = new ArrayList<>();
    private static List<Colaborador> listaColaboradoresCadastrados = new ArrayList<>();
    private static List<Cliente> listaClientesCadastrados = new ArrayList<>();
    private static List<Produto> listaProdutosCadastrados = new ArrayList<>();
    private static List<Venda> listaVendasRealizadas = new ArrayList<>();
    private static List<Despesa> listaDespesasRegistradas = new ArrayList<>();
    
        private <T> void carregarLista(String arquivo, Type type, List<T> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Gson gson = new Gson();
            lista.addAll(gson.fromJson(br, type));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void carregarDados() {
        carregarLista("arquivosJson/administradoresEmJson.txt", new TypeToken<List<Administrador>>(){}.getType(), listaAdministradoresCadastrados);
        carregarLista("arquivosJson/colaboradoresEmJson.txt", new TypeToken<List<Colaborador>>(){}.getType(), listaColaboradoresCadastrados);
        carregarLista("arquivosJson/clientesEmJson.txt", new TypeToken<List<Cliente>>(){}.getType(), listaClientesCadastrados);
        carregarLista("arquivosJson/produtosEmJson.txt", new TypeToken<List<Produto>>(){}.getType(), listaProdutosCadastrados);
        carregarLista("arquivosJson/vendasEmJson.txt", new TypeToken<List<Venda>>(){}.getType(), listaVendasRealizadas);
        carregarLista("arquivosJson/despesasEmJson.txt", new TypeToken<List<Despesa>>(){}.getType(), listaDespesasRegistradas);
    }
    
    
    
    /**
     * O método main é o ponto de entrada para a execução do programa.Aqui é criada
     * uma instância do Sistema e chama-se o método de login onde,a partir deste,
     * é disponibilizada todas as outras funcionalidades do sistema.
     * @param args
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
        //--------------------------------------------------------------------------------------------------------------------
        
        //QUESTÃO PADRÃO DE PROJETO
        
        // Manipulacao de Data Fabricacao
        String datafab = "07/11/2023";
        Date dataFabrica = sistema.parseDate(datafab);
        
        // Manipulacao de Data Validade
        String dataval = "24/02/2024";
        Date dataValidad = sistema.parseDate(dataval);
        
        // PRRODUTO DESCONTO
        Produto prod = new Produto(123, "Arroz", dataFabrica, 
                dataValidad, 38, 40, 37, "Alimenticio", 
                "Prato Fino");
        
        // Imprimindo o Produto Padrão
        System.out.println("------------------------------ PRODUTO PADRAO ----------------------- \n");
        System.out.println(prod + "\n");
        
        // PRODUTO DESCONTO
        ProdutoPromocao prodpromocao = new ProdutoPromocao(prod, (float) 0.1);

        // Imprimindo o Produto Desconto
       System.out.println("------------------------------ PRODUTO DESCONTO ----------------------- \n");
       System.out.println(prodpromocao + "\n");
       // */
        
       //--------------------------------------------------------------------------------------------------------------------
       
        
        /*Utilitários para a realização dos testes:
        -- Exemplo de administrador --
        login: jhonathan;
        senha: jhots123;
        cpf: 98765432100;
        
        -- Exemplo de colaborador --
        login: pedro;
        senha: pedrao123;
        cpf: 12312312300;
        
        -- Exemplo de cliente --
        cpf: 12345678900;
        
        -- Exemplo de produto --
        id: 123456;
        id: 654321;
        id: 415263;
        
        -- Exemplo de venda --
        id: 1;
        
        -- Exemplo de despesa --
        id: 1;
        id: 2;
        id: 3;
        id: 4;
        */
        
        
        /* Questão 1: Implementação da classe com base no diagrama de classes criado. */
        
        // Resposta: Todas as classes foram implementadas com base no diagrama de classes.
        // Elas se encontram nos pacotes: pooufvjm.projetoMercadinho, pooufvjm.projetoMercadinho.Comparator,
        // pooufvjm.projetoMercadinho.Decorator, pooufvjm.projetoMercadinho.Iterator_Find.
        
        
        
        /* Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador. */
        
        // Resposta: Segue abaixo o método login, o qual consta o uso do sistema tanto por
        // colaboradores quanto por administrador.
        sistema.login();
        
        
        
        /* Questão 3: Sobrescrever o método toString() de todas as classes implementadas. */
        
        // Resposta: Segue abaixo todos os métodos de listagem, pois ao executar estes métodos,
        // é possivel visualizar o método toString() sobrescrito das classes implementadas.
        sistema.listarClientes();
        sistema.listarColaboradorOuAdministrador();
        sistema.listarProdutos();
        sistema.listarVendas();
        sistema.listarDespesas();
        
        
        
        /* Questão 4: Utilizar a palavra-chave super para implementar os construtores das subclasses. */
        
        // Resposta: A classe Pessoa possui as classes filhas Colaborador e Cliente. Além disso, Colaborador
        // possui a classe filha Administrador. Sendo assim, segue abaixo os métodos de cadastro tanto de Cliente,
        // quanto de Administrador, pois tais métodos fazem o uso destes construtores.
        // Para mais detalhes sobre a implementação, acesse as respectivas classes.
        sistema.adicionarCliente();
        sistema.adicionarColaboradorOuAdministrador();
        
        
        
        /* Questão 5: O sistema deverá armazenar de forma estática os 5 caixas do mercadinho. */
        
        // Resposta: Segue abaixo o método emitirRelatorioDiario() que faz o uso dos caixas estáticos.
        // Para mais detalhes sobre a implementação, acesse a classe Sistema.
        sistema.emitirRelatorioDiario();
        
        
        
        /* Questão 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos. */
        
        // Resposta: Segue abaixo os métodos de cadastro, edição e remoção de colaboradores no sistema.
        sistema.adicionarColaboradorOuAdministrador();
        sistema.editarColaboradorOuAdministrador();
        sistema.removerColaboradorOuAdministrador();
        
        
        
        /* Questão 7: Cadastrar, alterar ou excluir clientes. */
        
        // Resposta: Segue abaixo os métodos de cadastro, edição e remoção de clientes no sistema.
        sistema.adicionarCliente();
        sistema.editarClientes();
        sistema.removerClientes();
        
        
        
        /* Questão 8: Verificar e imprimir dados das vendas e dos clientes. */
        
        // Resposta: Segue abaixo o método listarVendas() e listarClientes() que permitem verificar
        // e imprimir os dados das vendas e dos clientes.
        sistema.listarVendas();
        sistema.listarClientes();
        
        
        
        /* Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema. */
        
        // Resposta: Segue abaixo os métodos de adicionarProduto(), editarProduto(), removerProduto(),
        // adicionarCliente(), editarCliente(), removerCliente(), que mostram que tanto os produtos
        // quanto os clientes, estão sendo salvos de forma dinâmica no sistema.
        sistema.adicionarProduto();
        sistema.editarProduto();
        sistema.removerProduto();
        sistema.adicionarCliente();
        sistema.editarClientes();
        sistema.removerClientes();
        
        
        
        /* Questão 10: Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo 
        junto com a informação do cliente que fez a compra. */
        
        // Resposta: Segue abaixo o método realizarVendaProdutos(), o qual é responsável por gerar
        // um extrato que é impresso e salvo junto com a informação do cliente que fez a compra.
        sistema.realizarVendaProdutos();
        
        
        
        /* Questão 11: Criar duas variáveis de classe (static) que irão armazenar quantas instâncias
        foram criadas dos tipos Cliente dentro da classe Sistema usando duas soluções diferentes.*/
        
        // Resposta: Para conferir a resposta para esta questão, por favor, acesse a classe Cliente,
        // os detalhes de implementação estão localizados nesta classe.
        
        
        
        /* Questão 11.a): Uma delas utilizando o enfoque de encapsulamento de acordo com a engenharia 
        de software (atributo private static e métodos get e set).*/
        
        // Resposta: Para conferir a resposta para esta questão, por favor, acesse a classe Cliente,
        // os detalhes de implementação estão localizados nesta classe.
        
        
        
        /* Questão 11.b): Na segunda estratégia, implementar usando o controle de acesso do tipo protect.*/
        
        // Resposta: Para conferir a resposta para esta questão, por favor, acesse a classe Cliente,
        // os detalhes de implementação estão localizados nesta classe.
        
        
        
        /* Questão 11.c): Explique quais são as vantagens e desvantagens de cada uma das duas estratégias. */
        
        // Resposta: Para conferir a resposta para esta questão, por favor, acesse a classe Cliente,
        // os detalhes de implementação estão localizados nesta classe.
        
        
        
        /* Questão 12: Criar um método de classe para classe Sistema que deverá retornar quantas instâncias 
        foram criadas dos tipos Cliente e Produtos. */
        
        // Resposta: Segue abaixo o método de classe instanciasClientesProdutos() o qual retorna quantas
        // instâncias foram criadas dos tipos Cliente e Produtos.
        sistema.instanciasClientesProdutos();
        
        
        
        /* Questão 13: Implementar a interface Comparator para as classes Produto e Venda e fazer comparações por diferentes atributos. */
        
        // Resposta:
        // Comparator Produto atributo Nome
        Produto prod1 = new Produto(124, "Feijão", dataFabrica, 
                dataValidad, 27, 50, 29, "Alimenticio",
                "GMinas");

        ProdutoComparator prodC = new ProdutoComparator();
        int produtoComparacao1 = prodC.compare(prod1, prod);
        int produtoComparacao2 = prodC.compare(prod1, prod1);

        // Printando a Comparação:
        System.out.println("Comparação Produtos Nomes diferentes: " + produtoComparacao1);
        System.out.println("Comparação Produtos Nomes iguais: " + produtoComparacao2);

        // Comparator Produto Atributo Categoria

        ProdutoComparatorCategoria prodCC = new ProdutoComparatorCategoria();
        int produtoComparacao3 = prodCC.compare(prod1, prod);
        int produtoComparacao4 = prodCC.compare(prod1, prod1);

        // Printando a Comparação:
        System.out.println("Comparação Produtos Categorias Diferentes: " + produtoComparacao3);
        System.out.println("Comparação Produtos Categorias Iguais: " + produtoComparacao4);

        // Comparator Venda atributo Nome
        Venda vend = new Venda(12, dataFabrica, "Finalizada", listaProdutosCadastrados, 465.89, "1234567", "Pedro", "1");
        Venda vend1 = new Venda(12, dataFabrica, "Incompleta", listaProdutosCadastrados, 465.89, "12345678", "Joao", "2");


        VendaComparator vendC = new VendaComparator();
        int vendaComparacao1 = vendC.compare(vend, vend);
        int vendaComparacao2 = vendC.compare(vend, vend1);

        // Printando a Comparação:
        System.out.println("Comparação Venda CPF iguais: " + vendaComparacao1);
        System.out.println("Comparação Venda CPF Diferentes: " + vendaComparacao2);

        // Comparator Venda Atributo Categoria

        VendaComparatorStatus vendCS = new VendaComparatorStatus();
        int vendaComparacao3 = vendCS.compare(vend, vend);
        int vendaComparacao4 = vendCS.compare(vend, vend1);

        // Printando a Comparação:
        System.out.println("Comparação Venda Status iguais: " + vendaComparacao3);
        System.out.println("Comparação Venda Status Diferentes: " + vendaComparacao4);
        
        
        
        /* Questão 14: Salve e recupere todas as informações dos Clientes, Produtos, Vendas, Colaboradores
        e Estoque em um arquivo de texto. Utilizem classes já prontas na internet que trabalhem com o formato json.
        Ao manipular um arquivo utilize os conceitos aprendidos em aula para alocar e desalocar recursos com segurança. */
        
        // Resposta: Segue abaixo todos os métodos clientes, produtos, vendas e colaboradores de adição, com o intuito de
        // demonstrar o salvamento dessas informações e, também de listagem, para demonstrar a recuperação dessas informações.
        sistema.adicionarCliente();
        sistema.adicionarProduto();
        sistema.realizarVendaProdutos();
        sistema.adicionarColaboradorOuAdministrador();
        sistema.listarClientes();
        sistema.listarProdutos();
        sistema.listarVendas();
        sistema.listarColaboradorOuAdministrador();
        
        
        
        /* Questão 15: Instanciar um iterator para a arraylist de pessoas/usuario/cliente (qual estiver usando).
        Fazer testes no main em percorrer o arraylist com chamadas usando o código: 
        while(iterator.hasnext())
        { 
        imprimir(iterator.next());
        }
        - Explicar como isso está acontecendo.
        - Qual relação do código acima com o foreach em java?
        - Testar o foreach. */
        
        //Resposta:
        ClienteIterator ci = new ClienteIterator(listaClientesCadastrados);
        while(ci.hasNext()){
            Cliente cl = ci.next();
            System.out.print(cl);
        }
        
        /** Laço foreach itera automaticamente sobre os elementos da coleção
            sem a necessidade de utilizar um iterator de maneira explicita
            Tornando o código mais clean */
        
        for(Cliente cl : listaClientesCadastrados){
            System.out.print(cl);
        }
        
        
        
        /* Questão 16: Apresentar no main testes do comparator implementado.
        Utilizar e apresentar no main a aplicação do método sort da classe collections
        passando o comparator criado para ordenar a lista de pessoas/usuario/cliente
        (qual estiver usando) com dois parâmetros diferentes. Ou seja, rodar duas vezes. */
        
        // Resposta:
        Collections.sort(listaProdutosCadastrados, new ProdutoComparator());
        System.out.println(listaProdutosCadastrados);
        Collections.sort(listaProdutosCadastrados, new ProdutoComparatorCategoria());
        System.out.println(listaProdutosCadastrados);
        
        
        
        /* Questão 17: Criar o método find para clientes utilizando o interator e comparator.
        Apresentar testes do método implementado. */
        
        // Resposta:
        String nome = "Pedro";
        ClienteFind clF = new ClienteFind();
        Cliente findCliente1 = clF.clienteFind(nome, listaClientesCadastrados);
        Cliente findCliente2 = clF.clienteFindForEach(nome, listaClientesCadastrados);
        
        System.out.println("Busca pelo While utilizando Iterator: " + findCliente1);
        System.out.println("Busca pelo ForEach: " + findCliente2);
        
        
        
        
        
        
        /*MÉTODOS QUE DEMONSTRAM TODAS AS FUNCIONALIDADES PRESENTES NO SISTEMA: */
        sistema.login();
        
        sistema.adicionarCliente();
        sistema.editarClientes();
        sistema.listarClientes();
        sistema.removerClientes();

        sistema.adicionarProduto();
        sistema.editarProduto();
        sistema.listarProdutos();
        sistema.removerProduto();

        sistema.realizarVendaProdutos();
        sistema.listarVendas();
        sistema.cancelarVenda();

        sistema.adicionarColaboradorOuAdministrador();
        sistema.editarColaboradorOuAdministrador();
        sistema.listarColaboradorOuAdministrador();
        sistema.removerColaboradorOuAdministrador();

        sistema.registrarDespesa();
        sistema.listarDespesas();
        sistema.excluirDespesa();

        sistema.emitirRelatorioVendas();

        sistema.gerarBalanco();

        sistema.sairSistema();

        
    }
}