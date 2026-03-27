package pooufvjm.projetomercadinho;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import pooufvjm.projetomercadinho.Decorator.Produto;

/**
 * A classe Sistema representa o sistema principal do mercadinho.
 * Esta classe é responsável por gerenciar funcionários, produtos, vendas, gerar relatórios, entre outras coisas.
 * São listadas todas as funcionalidades nesta classe, pois foi implementada a partir da devida abstração do projeto.
 * Algumas funções são exclusivas de Administradores, isto é tratado a partir do tipo de usuário que realiza o login do sistema.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Sistema {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    // Questão 5: O sistema deverá armazenar de forma estática os 5 caixas do mercadinho.
    private static List<String> listaCaixas = List.of("Caixa 01", "Caixa 02", "Caixa 03", "Caixa 04", "Caixa 05");
    private static List<Administrador> listaAdministradoresCadastrados = new ArrayList<>();
    private static List<Colaborador> listaColaboradoresCadastrados = new ArrayList<>();
    private static List<Cliente> listaClientesCadastrados = new ArrayList<>();
    private static List<Produto> listaProdutosCadastrados = new ArrayList<>();
    private static List<Venda> listaVendasRealizadas = new ArrayList<>();
    private static List<Despesa> listaDespesasRegistradas = new ArrayList<>();
    
    /**
     * Construtor da classe Sistema.
     * Inicializa o sistema carregando dados previamente salvos nos arquivos do tipo txt.
     */
    public Sistema() {
        carregarDados();
    }
    
    /**
     * Carrega os dados do sistema a partir dos arquivos no formato JSON.
     */
    private void carregarDados() {
        carregarLista("arquivosJson/administradoresEmJson.txt", new TypeToken<List<Administrador>>(){}.getType(), listaAdministradoresCadastrados);
        carregarLista("arquivosJson/colaboradoresEmJson.txt", new TypeToken<List<Colaborador>>(){}.getType(), listaColaboradoresCadastrados);
        carregarLista("arquivosJson/clientesEmJson.txt", new TypeToken<List<Cliente>>(){}.getType(), listaClientesCadastrados);
        carregarLista("arquivosJson/produtosEmJson.txt", new TypeToken<List<Produto>>(){}.getType(), listaProdutosCadastrados);
        carregarLista("arquivosJson/vendasEmJson.txt", new TypeToken<List<Venda>>(){}.getType(), listaVendasRealizadas);
        carregarLista("arquivosJson/despesasEmJson.txt", new TypeToken<List<Despesa>>(){}.getType(), listaDespesasRegistradas);
    }
    // Questão 14: Salve e recupere todas as informações dos Clientes, Produtos, Vendas, Colaboradores e Estoque em um arquivo de texto.
    
    /**
     * Método genérico criado com o intuito de carregar uma determinada lista a partir de um arquivo JSON.
     *
     * @param arquivo A identificação do arquivo JSON.
     * @param type O tipo de lista.
     * @param lista A lista a ser preenchida.
     * @param <T> O tipo de objeto na lista.
     */
    private <T> void carregarLista(String arquivo, Type type, List<T> lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Gson gson = new Gson();
            lista.addAll(gson.fromJson(br, type));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para retornar quantas instâncias foram criadas dos tipos "Cliente" e "Produto".
     */
    public static void instanciasClientesProdutos(){
        int instanciasClientes = Cliente.getInstanciasCriadasMetodoUm();
        int instanciasProdutos = Produto.getInstanciasCriadas();
        
        System.out.println("O sistema possui" + instanciasClientes + "cliente e " + instanciasProdutos + "produtos");
    }
    // Questão 12: Criar um método de classe para classe Sistema que deverá retornar quantas instâncias foram criadas dos tipos Cliente e Produtos.
    
    /**
     * Método login() é o método principal que inicia o sistema e solicita o login.
     * Este método permite que um usuário faça login no sistema, seja como administrador ou colaborador, fornecendo suas credenciais.
     * Após o login bem-sucedido, o usuário é redirecionado para o menu correspondente.
     */
    public void login(){
        // Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador.
        
        Scanner teclado = new Scanner(System.in);
        String login;
        String senha;
        String opcao;
        boolean credenciaisValidas = false;


        System.out.println("MERCADINHO DIAMANTINA - SEJA BEM VINDO!\n");
        System.out.println("FAÇA LOGIN\n"
                + "- Entre como administrador: Digite 1\n"
                + "- Entre como colaborador: Digite 2");
        System.out.println("Qual a sua opção? ");
        opcao = teclado.nextLine();

        switch(opcao){
            case "1":
                System.out.println("Você deseja fazer login como administrador...");
                System.out.printf("Informe seu login: ");
                login = teclado.nextLine();
                System.out.printf("Informe sua senha: ");
                senha = teclado.nextLine();

                for(Administrador adm : listaAdministradoresCadastrados){
                    if(adm.getLogin().equals(login) && adm.getSenha().equals(senha)){
                        credenciaisValidas = true;
                    }            
                }
                
                if(!credenciaisValidas){
                    System.out.println("Credenciais inválidas, tente novamente!");
                    login();
                }
                
                if(credenciaisValidas){
                    System.out.println("Login realizado com sucesso!");
                    menuAdministrador();
                    return;
                }
                
                break;

            case "2":
                System.out.println("Você deseja fazer login como colaborador...");
                System.out.printf("Informe seu login: ");
                login = teclado.nextLine();
                System.out.printf("Informe sua senha: ");
                senha = teclado.nextLine();

                for(Colaborador colaborador : listaColaboradoresCadastrados){
                    if(colaborador.getLogin().equals(login) && colaborador.getSenha().equals(senha)){
                        credenciaisValidas = true;
                    }            
                }

               if(!credenciaisValidas){
                    System.out.println("Credenciais inválidas, tente novamente!");
                    login();
               }

               if(credenciaisValidas){
                    System.out.println("Login realizado com sucesso!");
                    menuColaborador();
                    return;
               }
               
               break;

           default:
                System.out.println("Opção não disponível, escolha apenas os números 1 ou 2.");
                login();
        }
    }
    
    /**
    * O método menuColaborador() exibe o menu de funcionalidades disponíveis para o usuário logado do tipo colaborador.
    * O colaborador pode realizar ações como listar, adicionar, editar ou remover clientes, produtos e vendas.
    * Também pode realizar vendas, listar as vendas realizadas, cancelar vendas e sair do sistema.
    */    
    public void menuColaborador(){
        // Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador.
        
        Scanner teclado = new Scanner(System.in);
        String opcao;
        
        System.out.println("Você é um COLABORADOR!\n");
        System.out.println("""
                           <<<MENU>>>
                           1 - Listar clientes
                           2 - Adicionar cliente
                           3 - Editar cliente
                           4 - Remover cliente
                           5 - Listar produtos
                           6 - Adicionar produtos
                           7 - Editar produto
                           8 - Remover produto
                           9 - Realizar venda
                           10 - Listar vendas
                           11 - Cancelar venda
                           12 - SAIR DO SISTEMA
                           """);
        System.out.println("O que você deseja fazer? ");
        opcao = teclado.nextLine();
        
        switch (opcao) {
            case "1":
                listarClientes();
                break;
            case "2":
                adicionarCliente();
                break;                
            case "3":
                editarClientes();
                break;                
            case "4":
                removerClientes();
                break;
            case "5":
                listarProdutos();
                break;
            case "6":
                adicionarProduto();
                break;
            case "7":
                editarProduto();
                break;
            case "8":
                removerProduto();
                break;
            case "9":
                realizarVendaProdutos();
                break;
            case "10":
                listarVendas();
                break;
            case "11":
                cancelarVenda();
                break;
            case "12":
                sairSistema();
                break;

            default:
                System.out.println("Opção indisponível! Escolha um número de 1 a 12.");
                menuColaborador();
        }
    }
    
    /**
    * O método menuAdministrador() exibe o menu de funcionalidades disponíveis para um usuário do administrador no sistema do mercadinho.
    * O administrador pode realizar todas as ações que um colaborador pode realizar, acrescido de algumas funcionalidades como gerenciar os colaboradores, despesas e emitir relatórios.
    */
    public void menuAdministrador(){
        // Questão 2: O sistema será utilizado pelos colaboradores e pelo administrador.
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Você é um ADMINISTRADOR!\n");
        System.out.println("""
                           <<<MENU>>>
                           1 - Listar clientes
                           2 - Adicionar cliente
                           3 - Editar cliente
                           4 - Remover cliente
                           5 - Listar produtos
                           6 - Adicionar produtos
                           7 - Editar produto
                           8 - Remover produto
                           9 - Realizar venda
                           10 - Listar vendas
                           11 - Cancelar venda
                           12 - Listar colaboradores ou administradores
                           13 - Adicionar colaborador ou administrador
                           14 - Editar colaborador ou administrador
                           15 - Remover colaborador ou administrador
                           16 - Listar despesas
                           17 - Registrar despesas
                           18 - Excluir despesas
                           19 - Emitir relatório de vendas
                           20 - Gerar balanço mensal de receitas e despesas
                           21 - SAIR DO SISTEMA
                           """);
        System.out.println("O que você deseja fazer? ");
        String opcao = teclado.nextLine();
        
        switch (opcao) {
            case "1":
                listarClientes();
                break;
            case "2":
                adicionarCliente();
                break;                
            case "3":
                editarClientes();
                break;                
            case "4":
                removerClientes();
                break;
            case "5":
                listarProdutos();
                break;
            case "6":
                adicionarProduto();
                break;
            case "7":
                editarProduto();
                break;
            case "8":
                removerProduto();
                break;
            case "9":
                realizarVendaProdutos();
                break;
            case "10":
                listarVendas();
                break;
            case "11":
                cancelarVenda();
                break;
            case "12":
                listarColaboradorOuAdministrador();
                break;
            case "13":
                adicionarColaboradorOuAdministrador();
                break;
            case "14":
                editarColaboradorOuAdministrador();
                break;
            case "15":
                removerColaboradorOuAdministrador();
                break;
            case "16":
                listarDespesas();
                break;
            case "17":
                registrarDespesa();
                break;
            case "18":
                excluirDespesa();
                break;
            case "19":
                emitirRelatorioVendas();
                break;
            case "20":
                gerarBalanco();
                break;
            case "21":
                sairSistema();
                break;
            default:
                System.out.println("Opção indisponível! Escolha um número de 1 a 21.");
                menuColaborador();
        }
    }    
    
    /**
    * O método listarClientes() exibe no console a lista de clientes cadastrados no sistema.
    * Se não houver clientes cadastrados, uma mensagem informando a ausência será exibida.
    * Caso contrário, cada cliente será apresentado fazendo o uso do método toString().
    */
    public void listarClientes(){
        // Questão 8: Verificar e imprimir dados das vendas e dos clientes.
        
        if(listaClientesCadastrados.isEmpty()){
            System.out.println("Não há clientes cadastrados no sistema!");
        } else{
            System.out.println("Clientes cadastrados no sistema: ");
            for(Cliente clientes : listaClientesCadastrados){
                System.out.println(clientes.toString() + "\n"); 
            }
        }
        
        return;
    }
    
    /**
    * O método adicionarCliente() permite cadastrar um novo cliente no sistema.
    * Será solicitado ao usuário as devidas informações do cliente.
    * Após a entrada de dados, o método verifica se o cliente já está presente na lista de clientes cadastrados.
    * Se o cliente já existir, uma mensagem indicando a duplicidade é exibida.
    * Caso contrário, o novo cliente é adicionado à lista de clientes cadastrados e a lista é atualizada no arquivo JSON.
    */
    public void adicionarCliente(){
        // Questão 7: Cadastrar, alterar ou excluir clientes.
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);
        Cliente novoCliente = new Cliente();
        
        System.out.println("Cadastrando cliente: ");
        System.out.println("Insira o NOME do cliente: ");
        novoCliente.setNome(teclado.nextLine());
        System.out.println("Insira o SOBRENOME do cliente: ");
        novoCliente.setSobrenome(teclado.nextLine());
        System.out.println("Insira o CPF do cliente(Este será o ID do cliente): ");
        novoCliente.setCpf(teclado.nextLine());
        System.out.println("Insira o EMAIL do cliente: ");
        novoCliente.setEmail(teclado.nextLine());
        System.out.println("Insira o APELIDO do cliente: ");
        novoCliente.setApelido(teclado.nextLine());
        System.out.println("Insira o ENDEREÇO do cliente: ");
        novoCliente.setEndereco(teclado.nextLine());
        System.out.println("Insira o TELEFONE do cliente: ");
        novoCliente.setTelefone(teclado.nextLine());
        
        if(listaClientesCadastrados.contains(novoCliente)){
            System.out.println("O cliente que você deseja cadastrar já está presente no sistema!");
        } else {
            listaClientesCadastrados.add(novoCliente);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String objetosConvertidos = gson.toJson(listaClientesCadastrados);

        try (FileWriter writer = new FileWriter("arquivosJson/clientesEmJson.txt")) {
            writer.write(objetosConvertidos);
            writer.flush();
            writer.close();
            System.out.println("O cliente foi cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * O método editarClientes() permite editar as informações de um cliente existente no sistema.
     * É solicitado ao usuário inserir o CPF do cliente que deseja editar.
     * Se o cliente for encontrado, o sistema exibe as opções de dados que podem ser alterados.
     * O usuário escolhe a opção desejada e insere o novo valor.
     * Após a edição, o cliente é atualizado na lista de clientes cadastrados e a lista é devidamente salva no arquivo JSON.
     * Se o cliente não for encontrado, uma mensagem informando que o cliente não está no sistema é exibida.
     */
    public void editarClientes(){
        // Questão 7: Cadastrar, alterar ou excluir clientes.
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);
        if(listaClientesCadastrados.isEmpty()){
            System.out.println("Não é possível usar a função de editar pois não há clientes no sistema!");
        } else {
            System.out.println("Insira o CPF do cliente que deseja editar: ");
            String cpfCliente = teclado.nextLine();
            boolean clienteFoiEncontrado = false;

            for(Cliente cliente : listaClientesCadastrados){
                if(cliente.getCpf().equals(cpfCliente)){
                    System.out.println("O cliente foi encontrado no sistema, qual dado você deseja alterar?");
                    System.out.println("""
                                       1 - Nome
                                       2 - Sobrenome
                                       3 - Email
                                       4 - Apelido
                                       5 - Endereço
                                       6 - Telefone
                                       """);
                    
                    String opcao = teclado.nextLine();
                    
                    switch (opcao) {
                        case "1":
                            System.out.println("Novo NOME do cliente: ");
                            cliente.setNome(teclado.nextLine());
                            break;
                        case "2":
                            System.out.println("Novo SOBRENOME do cliente: ");
                            cliente.setSobrenome(teclado.nextLine());
                            break;
                        case "3":
                            System.out.println("Novo CPF do cliente(Este é o ID do cliente): ");
                            cliente.setCpf(teclado.nextLine());
                            break;   
                        case "4":
                            System.out.println("Novo EMAIL do cliente: ");
                            cliente.setEmail(teclado.nextLine());
                            break;
                        case "5":
                            System.out.println("Novo APELIDO do cliente: ");
                            cliente.setApelido(teclado.nextLine());
                            break;
                        case "6":
                            System.out.println("Novo ENDEREÇO do cliente: ");
                            cliente.setEndereco(teclado.nextLine());
                            break;
                        case "7":
                            System.out.println("Novo TELEFONE do cliente: ");
                            cliente.setTelefone(teclado.nextLine());
                            break;     
                        default:
                            System.out.println("Opção indisponível! Escolha um número de 1 a 7.");
                    }


                    clienteFoiEncontrado = true;
                    System.out.println("O cliente foi editado com sucesso!");
                    break;
                }
            }

            if(!clienteFoiEncontrado){
                System.out.println("Cliente não encontrado no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaClientesCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/clientesEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * O método removerClientes() permite remover um cliente existente no sistema.
    * Solicita-se ao usuário a inserção do CPF do cliente que deseja remover.
    * Se o cliente for encontrado, ele é removido da lista de clientes cadastrados.
    * Caso contrário, uma mensagem informando que o cliente não está no sistema é exibida.
    * Após a remoção, a lista é salva devidamente no arquivo JSON.
    */
    public void removerClientes() {
        // Questão 7: Cadastrar, alterar ou excluir clientes.
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);

        if(listaClientesCadastrados.isEmpty()){
            System.out.println("Não é possível usar a função de remover pois não há clientes no sistema!");
        } else {
            System.out.println("Insira o CPF do cliente que deseja remover: ");
            String cpfCliente = teclado.nextLine();
            boolean clienteFoiEncontrado = false;

            for (Cliente cliente : listaClientesCadastrados) {
                if (cliente.getCpf().equals(cpfCliente)) {
                    listaClientesCadastrados.remove(cliente);
                    clienteFoiEncontrado = true;
                    System.out.println("Cliente removido com sucesso!");
                    break;
                }
            }

            if (!clienteFoiEncontrado) {
                System.out.println("Cliente não encontrado no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaClientesCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/clientesEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
    * O método listarProdutos() exibe a lista de produtos cadastrados no sistema.
    * Se a lista estiver vazia, uma mensagem informando que não há produtos cadastrados é exibida.
    * Caso contrário, cada produto é impresso no console utilizando o método toString().
    */
    public void listarProdutos(){
        if(listaProdutosCadastrados.isEmpty()){
            System.out.println("Não há produtos cadastrados no sistema!");
        } else{
            System.out.println("Produtos cadastrados no sistema: ");
            for(Produto produto : listaProdutosCadastrados){
                System.out.println(produto.toString() + "\n"); 
            }
        }
    }
    
    /**
    * O método adicionarProduto() realiza o cadastro de um novo produto no sistema.
    * Solicita-se ao usuário as informações sobre o produto.
    * O método verifica se o ID do produto já existe no sistema e, caso exista, exibe uma mensagem informando.
    * Se o ID for único, o novo produto é adicionado à lista de produtos cadastrados e os dados são armazenados em um arquivo JSON.
    */
    public void adicionarProduto(){
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);
        Produto novoProduto = new Produto();
        
        System.out.println("Cadastrando produto: ");
        System.out.println("Insira o ID do produto: ");
        novoProduto.setIdProduto(teclado.nextInt());
        teclado.nextLine();
        System.out.println("Insira o NOME do produto: ");
        novoProduto.setNome(teclado.nextLine());
        System.out.println("Insira a DATA DE FABRICAÇÃO do produto no formato dd/MM/yyyy: ");
        String dataFabString = teclado.nextLine();
        Date dataFab = parseDate(dataFabString);
        novoProduto.setDataFabricacao(dataFab);
        System.out.println("Insira a DATA DE VALIDADE do produto no formato dd/MM/yyyy: ");
        String dataValString = teclado.nextLine();
        Date dataVal = parseDate(dataValString);
        novoProduto.setDataValidade(dataVal);
        System.out.println("Insira o PREÇO DE CUSTO do produto (Ex: 1.25): ");
        float precoCusto = Float.parseFloat(teclado.nextLine());
        novoProduto.setPrecoCusto(precoCusto);
        System.out.println("Insira o PREÇO do produto (Ex: 2.75): ");
        float preco = Float.parseFloat(teclado.nextLine());
        novoProduto.setPreco(preco);
        System.out.println("Insira a QUANTIDADE disponível deste produto: ");
        novoProduto.setQuantidade(teclado.nextInt());
        teclado.nextLine();
        System.out.println("Insira a CATEGORIA do produto: ");
        novoProduto.setCategoria(teclado.nextLine());
        System.out.println("Insira o FORNECEDOR do produto: ");
        novoProduto.setFornecedor(teclado.nextLine());
        
        boolean idJaExiste = false;

        for (Produto produtoExistente : listaProdutosCadastrados) {
            if (produtoExistente.getIdProduto() == novoProduto.getIdProduto()) {
                idJaExiste = true;
                break;
            }
        }

        if (idJaExiste) {
            System.out.println("O produto com esse ID já está presente no sistema!");
        } else {
            listaProdutosCadastrados.add(novoProduto);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String objetosConvertidos = gson.toJson(listaProdutosCadastrados);
        
        try (FileWriter writer = new FileWriter("arquivosJson/produtosEmJson.txt")) {
            writer.write(objetosConvertidos);
            writer.flush();
            writer.close();
            System.out.println("O produto foi cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * O método editarProduto() permite a edição de informações de um produto já existente no sistema.
     * O usuário fornece o ID do produto que deseja editar e, em seguida, escolhe qual informação do produto deseja alterar.
     * As alterações são salvas no sistema e atualizadas no arquivo JSON.
     * Caso o ID do produto não seja encontrado, é exibida uma mensagem informando que o produto não está cadastrado no sistema.
     */
    public void editarProduto(){
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);

        if(listaProdutosCadastrados.isEmpty()){
            System.out.println("Não é possível usar a função de editar pois não há produtos no sistema!");
        } else {
            System.out.println("Insira o ID do produto que deseja editar: ");
            int idProduto = teclado.nextInt();
            teclado.nextLine();
            boolean produtoFoiEncontrado = false;

            for(Produto produto : listaProdutosCadastrados){
                if(produto.getIdProduto() == idProduto){
                    System.out.println("O produto foi encontrado no sistema, qual dado você deseja alterar?");
                    System.out.println("""
                                       1 - ID
                                       2 - Nome
                                       3 - Data de fabricação
                                       4 - Data de validade
                                       5 - Preço de custo
                                       6 - Preço
                                       7 - Quantidade
                                       8 - Categoria
                                       9 - Fornecedor
                                       """);
                    String opcao = teclado.nextLine();
                    switch (opcao) {
                        case "1":
                            System.out.println("Novo ID do produto: ");
                            produto.setIdProduto(teclado.nextInt());
                            break;
                        case "2":
                            System.out.println("Novo NOME do produto: ");
                            produto.setNome(teclado.nextLine());
                            break;
                        case "3":
                            System.out.println("Nova DATA DE FABRICAÇÃO do produto: ");
                            String dataFabString = teclado.nextLine();
                            Date dataFab = parseDate(dataFabString);
                            produto.setDataFabricacao(dataFab);
                            break;                
                        case "4":
                            System.out.println("Nova DATA DE VALIDADE do produto: ");
                            String dataValString = teclado.nextLine();
                            Date dataVal = parseDate(dataValString);                            
                            produto.setDataValidade(dataVal);
                            break;
                        case "5":
                            System.out.println("Novo PREÇO DE CUSTO do produto (Ex: 2.75): ");
                            float precoCusto = Float.parseFloat(teclado.nextLine());
                            produto.setPrecoCusto(precoCusto);
                            
                            break;
                        case "6":
                            System.out.println("Novo PREÇO do produto (Ex: 2.75): ");
                            float preco = Float.parseFloat(teclado.nextLine());
                            produto.setPreco(preco);
                            break;
                        case "7":
                            System.out.println("Nova QUANTIDADE disponível do produto: ");
                            produto.setQuantidade(teclado.nextInt());
                            break;
                        case "8":
                            System.out.println("Nova CATEGORIA do produto: ");
                            produto.setCategoria(teclado.nextLine());
                            break;
                        case "9":
                            System.out.println("Nova FORNECEDOR do produto: ");
                            produto.setFornecedor(teclado.nextLine());
                            break;  
                        default:
                            System.out.println("Opção indisponível! Escolha um número de 1 a 9.");
                    }

                    produtoFoiEncontrado = true;
                    System.out.println("O produto foi editado com sucesso!");
                    break;
                }
            }

            if(!produtoFoiEncontrado){
                System.out.println("Produto não encontrado no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaProdutosCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/produtosEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * O método removerProduto() permite a remoção de um produto do sistema com base no seu ID.
     * O usuário fornece o ID do produto que deseja remover, e se o produto for encontrado, ele é removido da lista de produtos cadastrados.
     * Após a remoção, a lista é atualizada no arquivo JSON.
     * Caso o ID do produto não seja encontrado, é exibida uma mensagem informando que o produto não está no sistema.
     */    
    public void removerProduto(){
        // Questão 9: Os produtos e os clientes devem ser salvos de forma dinâmica no sistema.
        
        Scanner teclado = new Scanner(System.in);

        if(listaProdutosCadastrados.isEmpty()){
            System.out.println("Não é possível usar a função de remover pois não há produtos no sistema!");
        } else {
            System.out.println("Insira o ID do produto que deseja remover: ");
            int idProduto = teclado.nextInt();
            boolean produtoFoiEncontrado = false;

            for (Produto produto : listaProdutosCadastrados) {
                if (produto.getIdProduto() == idProduto) {
                    listaProdutosCadastrados.remove(produto);
                    produtoFoiEncontrado = true;
                    System.out.println("Produto removido com sucesso!");
                    break;
                }
            }

            if (!produtoFoiEncontrado) {
                System.out.println("Produto não encontrado no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaProdutosCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/produtosEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * O método listarVendas() exibe no console as vendas realizadas no sistema.
     * Se a lista de vendas estiver vazia, é exibida uma mensagem informando que não há vendas realizadas.
     * Caso contrário, cada venda é exibida no formato de string, utilizando o método toString() da classe Venda.
     */
    public void listarVendas(){
        // Questão 8: Verificar e imprimir dados das vendas e dos clientes.
        
        if(listaVendasRealizadas.isEmpty()){
            System.out.println("Não há vendas realizadas no sistema!");
        } else{
            System.out.println("Vendas realizadas no sistema: ");
            for(Venda venda : listaVendasRealizadas){
                System.out.println(venda.toString() + "\n"); 
            }
        }
    }
    
    /**
     * O método ealizarVendaProdutos() permite que o usuário registre uma venda de produtos no sistema.
     * Solicita-se a inserção do CPF do comprador, a data da venda, e os IDs dos produtos vendidos.
     * O processo de inserção de produtos continua até que o colaborador insira o ID 0 para finalizar a seleção de produtos.
     * A venda é associada a um caixa, recebe um ID e, por fim, é registrada na lista de vendas realizadas.
     * O extrato da venda é exibido no console após a realização da venda.
     * A lista de produtos cadastrados é devidamente atualizada, reduzindo a quantidade disponível dos produtos vendidos.
     * A lista de vendas realizadas é gravada em um arquivo JSON.
     */    
    public void realizarVendaProdutos() {
        // Questão 10: Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo junto com a informação do cliente que fez a compra.
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o CPF do comprador: ");
        String cpfComprador = teclado.nextLine();

        System.out.println("Digite a data da venda (dd/MM/yyyy): ");
        String dataInserida = teclado.nextLine();

        // Lista para armazenar produtos
        List<Produto> listaProdutosInseridosParaVenda = new ArrayList<>();

        // Loop para adicionar produtos à venda
        while (true) {
            try {
                System.out.println("Digite o ID do próximo produto a ser vendido ou digite 0 para finalizar: ");
                int idProduto = Integer.parseInt(teclado.nextLine());

                if (idProduto == 0) {
                    break;
                }

                // Procurar o produto na lista
                Produto produtoEncontrado = listaProdutosCadastrados.stream()
                        .filter(prod -> prod.getIdProduto() == idProduto)
                        .findFirst()
                        .orElse(null);

                if (produtoEncontrado != null) {
                    System.out.println("Produto encontrado! Adicionando à venda.");
                    listaProdutosInseridosParaVenda.add(produtoEncontrado);
                    for(Produto prod : listaProdutosCadastrados){
                        if(produtoEncontrado.getIdProduto() == prod.getIdProduto()){
                            prod.setQuantidade(prod.getQuantidade() - 1);
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            String objetosConvertidos = gson.toJson(listaProdutosCadastrados);

                            try (FileWriter writer = new FileWriter("arquivosJson/produtosEmJson.txt")) {
                                writer.write(objetosConvertidos);
                                writer.flush();
                                writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.println("O ID digitado não existe! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um ID válido.");
            }
        }

        // Criar objeto Venda e configurar detalhes
        Venda novaVenda = new Venda();
        novaVenda.setCpfComprador(cpfComprador);

        for (Cliente cliente : listaClientesCadastrados) {
            if (cliente.getCpf().equals(cpfComprador)) {
                novaVenda.setNomeComprador(cliente.getNome());
            }
        }

        try {
            Date dataVenda = new SimpleDateFormat("dd/MM/yyyy").parse(dataInserida);
            novaVenda.setDataVenda(dataVenda);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. A venda será registrada com a data atual.");
            novaVenda.setDataVenda(new Date());
        }

        while (true) {
            System.out.println("Selecione o caixa para a venda (Caixa 01, Caixa 02, Caixa 03, Caixa 04, Caixa 05): ");
            String caixaSelecionado = teclado.nextLine();

            // Verificar se o caixa selecionado é válido
            if (listaCaixas.contains(caixaSelecionado)) {
                novaVenda.setCodigoCaixa(caixaSelecionado);
                break;
            } else {
                System.out.println("Caixa inválido. Por favor, selecione um caixa válido.");
            }
        }

        while (true) {
            System.out.println("Atribua um número identificador para esta venda: ");
            int idNovaVenda = teclado.nextInt();
            teclado.nextLine();

            boolean idExistente = listaVendasRealizadas.stream().anyMatch(venda -> venda.getIdVenda() == idNovaVenda);

            if (!idExistente) {
                novaVenda.setIdVenda(idNovaVenda);
                break;
            } else {
                System.out.println("ID já existente. Por favor, escolha outro ID.");
            }
        }


        novaVenda.setStatusVenda("Finalizada");
        novaVenda.setItensVendidos(listaProdutosInseridosParaVenda);

        // Calcular o valor total da venda
        double totalVenda = listaProdutosInseridosParaVenda.stream().mapToDouble(Produto::getPreco).sum();

        novaVenda.setValorTotalVenda(totalVenda);

        // Outras configurações (ex: código do caixa)

        // Exibir detalhes da venda
        System.out.println("Venda finalizada!");
        System.out.println(novaVenda.toString());

        // Adicionar venda à lista de vendas realizadas
        listaVendasRealizadas.add(novaVenda);

        // Gravar a lista de vendas em um arquivo (Gson e FileWriter)
        // ... (código relacionado à gravação em arquivo)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String objetosConvertidos = gson.toJson(listaVendasRealizadas);

                    try (FileWriter writer = new FileWriter("arquivosJson/vendasEmJson.txt")) {
                        writer.write(objetosConvertidos);
                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

        System.out.println("A venda foi registrada com sucesso!");
    }
    
    /**
     * O método cancelarVenda() permite que um colaborador cancele uma venda realizada no sistema, restaurando as unidades dos produtos vendidos ao estoque.
     * Solicita-se ao usuário inserir o ID da venda que deseja cancelar.
     * Se a venda for encontrada, as unidades dos produtos vendidos são devolvidas ao estoque, a venda é removida da lista de vendas realizadas e as listas são atualizadas nos arquivos JSON correspondentes.
     */
    public void cancelarVenda() {
        Scanner teclado = new Scanner(System.in);

        if (listaVendasRealizadas.isEmpty()) {
            System.out.println("Não é possível usar a função de cancelar pois não há vendas no sistema!");
        } else {
            System.out.println("Insira o ID da venda que deseja remover: ");
            int idVenda = teclado.nextInt();
            boolean vendaFoiEncontrada = false;

            for (Venda venda : listaVendasRealizadas) {
                if (venda.getIdVenda() == idVenda) {
                    // Restaurar unidades ao estoque
                    for (Produto produto : venda.getItensVendidos()) {
                        for (Produto prod : listaProdutosCadastrados) {
                            if (produto.getIdProduto() == prod.getIdProduto()) {
                                prod.setQuantidade(prod.getQuantidade() + 1);
                            }
                        }
                    }
                    
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String objetosConvertidos = gson.toJson(listaProdutosCadastrados);

                    try (FileWriter writer = new FileWriter("arquivosJson/produtosEmJson.txt")) {
                        writer.write(objetosConvertidos);
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Remover a venda da lista
                    listaVendasRealizadas.remove(venda);

                    vendaFoiEncontrada = true;
                    System.out.println("Venda cancelada com sucesso!");
                    break;
                }
            }

            if (!vendaFoiEncontrada) {
                System.out.println("Venda não encontrada no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaVendasRealizadas);

            try (FileWriter writer = new FileWriter("arquivosJson/vendasEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * O método listarColaboradorOuAdministrador() permite que um administrador liste os colaboradores ou os administradores cadastrados no sistema, com base na escolha inserida.
     * Solicita-se ao usuário administrador inserir o número 1 para listar os colaboradores ou o número 2 para listar os administradores.
     * Se a escolha for 1, a lista de colaboradores é exibida.
     * Se a escolha for 2, a lista de administradores é exibida.
     * Caso não haja colaboradores ou administradores cadastrados, uma mensagem sobre isto é exibida.
     */    
    public void listarColaboradorOuAdministrador(){
        // Questão 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite 1 se você deseja listar os colaboradores ou digite 2 se você deseja listar os administradores: ");
        String escolha = teclado.nextLine();
        
        if(escolha.equals("1")){
            if(listaColaboradoresCadastrados.isEmpty()){
                System.out.println("Não há colaboradores cadastrados no sistema!");
            }else{
                System.out.println("Colaboradores cadastrados no sistema: ");
                for(Colaborador colaborador : listaColaboradoresCadastrados){
                    System.out.println(colaborador.toString() + "\n"); 
                }
            }
        }else if(escolha.equals("2")){
            if(listaAdministradoresCadastrados.isEmpty()){
                System.out.println("Não há administradores cadastrados no sistema!");
            }else{
                System.out.println("Administradores cadastrados no sistema: ");
                for(Administrador administrador : listaAdministradoresCadastrados){
                    System.out.println(administrador.toString() + "\n"); 
                }
            }
        }
    }
    
    /**
     * O método adicionarColaboradorOuAdministrador() permite que um administrador adicione um colaborador ou um administrador ao sistema, com base na escolha inserida.
     * O administrador é solicitado a inserir o número 1 para adicionar um colaborador ou o número 2 para adicionar um administrador.
     * Se a escolha for 1, um novo colaborador é cadastrado com suas devidas informações, o mesmo processo ocorre se a escolha for 2.
     * Caso o colaborador ou administrador já esteja presente no sistema, uma mensagem é exibida.
     * Os dados são armazenados em arquivos JSON após o cadastro.
     */   
    public void adicionarColaboradorOuAdministrador(){
        // Questão 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite 1 se você deseja adicionar um colaborador ou digite 2 se você deseja adicionar um administrador: ");
        String escolha = teclado.nextLine();
        
        if(escolha.equals("1")){
            Colaborador novoColaborador = new Colaborador();
        
            System.out.println("Cadastrando colaborador: ");
            System.out.println("Insira o NOME do colaborador: ");
            novoColaborador.setNome(teclado.nextLine());
            System.out.println("Insira o SOBRENOME do colaborador: ");
            novoColaborador.setSobrenome(teclado.nextLine());
            System.out.println("Insira o CPF do colaborador: ");
            novoColaborador.setCpf(teclado.nextLine());
            System.out.println("Insira o EMAIL do colaborador: ");
            novoColaborador.setEmail(teclado.nextLine());
            System.out.println("Insira o LOGIN do colaborador: ");
            novoColaborador.setLogin(teclado.nextLine());
            System.out.println("Insira o SENHA do colaborador: ");
            novoColaborador.setSenha(teclado.nextLine());

            if(listaColaboradoresCadastrados.contains(novoColaborador)){
                System.out.println("O colaborador que você deseja cadastrar já está presente no sistema!");
            } else {
                listaColaboradoresCadastrados.add(novoColaborador);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaColaboradoresCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/colaboradoresEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
                System.out.println("O colaborador foi cadastrado com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(escolha.equals("2")){
            Administrador novoAdministrador = new Administrador();
        
            System.out.println("Cadastrando administrador: ");
            System.out.println("Insira o NOME do administrador: ");
            novoAdministrador.setNome(teclado.nextLine());
            System.out.println("Insira o SOBRENOME do administrador: ");
            novoAdministrador.setSobrenome(teclado.nextLine());
            System.out.println("Insira o CPF do administrador: ");
            novoAdministrador.setCpf(teclado.nextLine());
            System.out.println("Insira o EMAIL do administrador: ");
            novoAdministrador.setEmail(teclado.nextLine());
            System.out.println("Insira o LOGIN do administrador: ");
            novoAdministrador.setLogin(teclado.nextLine());
            System.out.println("Insira o SENHA do administrador: ");
            novoAdministrador.setSenha(teclado.nextLine());

            if(listaAdministradoresCadastrados.contains(novoAdministrador)){
                System.out.println("O administrador que você deseja cadastrar já está presente no sistema!");
            } else {
                listaAdministradoresCadastrados.add(novoAdministrador);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaAdministradoresCadastrados);

            try (FileWriter writer = new FileWriter("arquivosJson/administradoresEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
                System.out.println("O administrador foi cadastrado com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    }
    
    /**
     * O método editarColaboradorOuAdministrador() permite que um administrador edite informações de um colaborador ou administrador com base na escolha inserida.
     * Solicita-se ao usuário administrador inserir o número 1 para editar um colaborador ou o número 2 para editar um administrador.
     * Se a escolha for 1, o administrador é solicitado a inserir o CPF do colaborador que deseja editar e, em seguida, escolher o campo a ser editado.
     * O mesmo processo ocorre se a escolha for 2.
     * Após a edição, os dados são atualizados no arquivo JSON correspondente.
     */    
    public void editarColaboradorOuAdministrador(){
        // Questão 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite 1 se você deseja editar um colaborador ou digite 2 se você deseja editar um administrador: ");
        String escolha = teclado.nextLine();
        
        if(escolha.equals("1")){
        
            if(listaColaboradoresCadastrados.isEmpty()){
                System.out.println("Não é possível usar a função de editar pois não há colaboradores no sistema!");
            } else {
                System.out.println("Insira o CPF do colaborador que deseja editar: ");
                String cpfColaborador = teclado.nextLine();
                boolean colaboradorFoiEncontrado = false;

                for(Colaborador colaborador : listaColaboradoresCadastrados){
                    if(colaborador.getCpf().equals(cpfColaborador)){
                        System.out.println("O colaborador foi encontrado no sistema, qual dado você deseja alterar?");
                        System.out.println("""
                                           1 - Nome
                                           2 - Sobrenome
                                           3 - Email
                                           4 - Login
                                           5 - Senha
                                           """);
                        
                        String opcao = teclado.nextLine();

                        switch (opcao) {
                            case "1":
                                System.out.println("Novo NOME do colaborador: ");
                                colaborador.setNome(teclado.nextLine());
                                break;
                            case "2":
                                System.out.println("Novo SOBRENOME do colaborador: ");
                                colaborador.setSobrenome(teclado.nextLine());
                                break;                
                            case "3":
                                System.out.println("Novo EMAIL do colaborador: ");
                                colaborador.setEmail(teclado.nextLine());
                                break;
                            case "4":
                                System.out.println("Novo LOGIN do colaborador: ");
                                colaborador.setLogin(teclado.nextLine());
                                break;
                            case "5":
                                System.out.println("Novo SENHA do colaborador: ");
                                colaborador.setSenha(teclado.nextLine());
                                break;  
                            default:
                                System.out.println("Opção indisponível! Escolha um número de 1 a 5.");
                        }


                        colaboradorFoiEncontrado = true;
                        System.out.println("O colaborador foi editado com sucesso!");
                        break;
                    }
                }

                if(!colaboradorFoiEncontrado){
                    System.out.println("Colaborador não encontrado no sistema.");
                }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String objetosConvertidos = gson.toJson(listaColaboradoresCadastrados);

                try (FileWriter writer = new FileWriter("arquivosJson/colaboradoresEmJson.txt")) {
                    writer.write(objetosConvertidos);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if(escolha.equals("2")){
          
            if(listaAdministradoresCadastrados.isEmpty()){
                System.out.println("Não é possível usar a função de editar pois não há administradores no sistema!");
            } else {
                System.out.println("Insira o CPF do administrador que deseja editar: ");
                String cpfAdministrador = teclado.nextLine();
                boolean administradorFoiEncontrado = false;

                for(Administrador administrador : listaAdministradoresCadastrados){
                    if(administrador.getCpf().equals(cpfAdministrador)){
                        System.out.println("O administrador foi encontrado no sistema, qual dado você deseja alterar?");
                        System.out.println("""
                                           1 - Nome
                                           2 - Sobrenome
                                           3 - Email
                                           4 - Login
                                           5 - Senha
                                           """);
                        String opcao = teclado.nextLine();

                        switch (opcao) {
                            case "1":
                                System.out.println("Novo NOME do administrador: ");
                                administrador.setNome(teclado.nextLine());
                                break;
                            case "2":
                                System.out.println("Novo SOBRENOME do administrador: ");
                                administrador.setSobrenome(teclado.nextLine());
                                break;                
                            case "3":
                                System.out.println("Novo EMAIL do administrador: ");
                                administrador.setEmail(teclado.nextLine());
                                break;
                            case "4":
                                System.out.println("Novo LOGIN do administrador: ");
                                administrador.setLogin(teclado.nextLine());
                                break;
                            case "5":
                                System.out.println("Novo SENHA do administrador: ");
                                administrador.setSenha(teclado.nextLine());
                                break;  
                            default:
                                System.out.println("Opção indisponível! Escolha um número de 1 a 5.");
                        }


                        administradorFoiEncontrado = true;
                        System.out.println("O administrador foi editado com sucesso!");
                        break;
                    }
                }

                if(!administradorFoiEncontrado){
                    System.out.println("Administrador não encontrado no sistema.");
                }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String objetosConvertidos = gson.toJson(listaAdministradoresCadastrados);

                try (FileWriter writer = new FileWriter("arquivosJson/administradoresEmJson.txt")) {
                    writer.write(objetosConvertidos);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  
        }
    }
    
    /**
     * O método removerColaboradorOuAdministrador() permite que um administrador remova um colaborador ou administrador com base na escolha inserida.
     * O administrador é solicitado a inserir o número 1 para remover um colaborador ou o número 2 para remover um administrador.
     * Se a escolha for 1, o administrador é solicitado a inserir o CPF do colaborador que deseja remover e, em seguida, o colaborador é removido da lista.
     * Se a escolha for 2, o processo é o mesmo, mas para um administrador.
     * Após a remoção, os dados são atualizados no arquivo JSON correspondente.
     */
    public void removerColaboradorOuAdministrador(){
        // Questão 6: Deve ser possível cadastrar os colaboradores no sistema, alterar ou editar seus atributos;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite 1 se você deseja remover um colaborador ou digite 2 se você deseja remover um administrador: ");
        String escolha = teclado.nextLine();
        
        if(escolha.equals("1")){

            if(listaColaboradoresCadastrados.isEmpty()){
                System.out.println("Não é possível usar a função de remover pois não há colaboradores no sistema!");
            } else {
                System.out.println("Insira o CPF do colaborador que deseja remover: ");
                String cpfColaborador = teclado.nextLine();
                boolean colaboradorFoiEncontrado = false;

                for (Colaborador colaborador : listaColaboradoresCadastrados) {
                    if (colaborador.getCpf().equals(cpfColaborador)) {
                        listaColaboradoresCadastrados.remove(colaborador);
                        colaboradorFoiEncontrado = true;
                        System.out.println("Colaborador removido com sucesso!");
                        break;
                    }
                }

                if (!colaboradorFoiEncontrado) {
                    System.out.println("Colaborador não encontrado no sistema.");
                }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String objetosConvertidos = gson.toJson(listaColaboradoresCadastrados);

                try (FileWriter writer = new FileWriter("arquivosJson/colaboradoresEmJson.txt")) {
                    writer.write(objetosConvertidos);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if(escolha.equals("2")){
            
            if(listaAdministradoresCadastrados.isEmpty()){
                System.out.println("Não é possível usar a função de remover pois não há administradores no sistema!");
            } else {
                System.out.println("Insira o CPF do administrador que deseja remover: ");
                String cpfAdministrador = teclado.nextLine();
                boolean administradorFoiEncontrado = false;

                for (Administrador administrador : listaAdministradoresCadastrados) {
                    if (administrador.getCpf().equals(cpfAdministrador)) {
                        listaAdministradoresCadastrados.remove(administrador);
                        administradorFoiEncontrado = true;
                        System.out.println("Administrador removido com sucesso!");
                        break;
                    }
                }

                if (!administradorFoiEncontrado) {
                    System.out.println("Administrador não encontrado no sistema.");
                }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String objetosConvertidos = gson.toJson(listaAdministradoresCadastrados);

                try (FileWriter writer = new FileWriter("arquivosJson/administradoresEmJson.txt")) {
                    writer.write(objetosConvertidos);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * O método listarDespesas() exibe todas as despesas cadastradas no sistema.
     * Se não houver despesas, uma mensagem indicando a ausência de despesas no sistema é exibida.
     */
    public void listarDespesas(){
        if(listaDespesasRegistradas.isEmpty()){
            System.out.println("Não há despesas cadastradas no sistema!");
        } else{
            System.out.println("Despesas cadastradas no sistema: ");
            for(Despesa despesa : listaDespesasRegistradas){
                System.out.println(despesa.toString() + "\n"); 
            }
        }
    }
    
    /**
     * O método registrarDespesa() permite ao usuário registrar uma nova despesa no sistema.
     * Solicita-se ao usuário as informações necessárias para o registro da despesa no sistema.
     * A despesa registrada é adicionada à lista de despesas do sistema.
     * Caso o ID já exista, o método exibe uma mensagem informando sobre esta duplicidade.
     * Por fim, as despesas registradas são armazenadas em um arquivo JSON.
     */    
    public void registrarDespesa(){
        Scanner teclado = new Scanner(System.in);
        Despesa novaDespesa = new Despesa();
        
        System.out.println("Registrando despesa: ");
        System.out.println("Insira o ID da despesa: ");
        novaDespesa.setIdDespesa(teclado.nextInt());
        teclado.nextLine();
        System.out.println("Insira o NOME da despesa: ");
        novaDespesa.setNomeDespesa(teclado.nextLine());
        System.out.println("Insira o VALOR da despesa (Ex: 34.50): ");
        float valor = Float.parseFloat(teclado.nextLine());
        novaDespesa.setValorDespesa(valor);        
        System.out.println("Insira a DATA da despesa no formato dd/MM/yyyy: ");
        String dataDespString = teclado.nextLine();
        Date dataDesp = parseDate(dataDespString);
        novaDespesa.setDataDespesa(dataDesp);
        
        
        boolean idJaExiste = false;

        for (Despesa despesaExistente : listaDespesasRegistradas) {
            if (despesaExistente.getIdDespesa()== novaDespesa.getIdDespesa()) {
                idJaExiste = true;
                break;
            }
        }

        if (idJaExiste) {
            System.out.println("A despesa com esse ID já está presente no sistema!");
        } else {
            listaDespesasRegistradas.add(novaDespesa);
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String objetosConvertidos = gson.toJson(listaDespesasRegistradas);

        try (FileWriter writer = new FileWriter("arquivosJson/despesasEmJson.txt")) {
            writer.write(objetosConvertidos);
            writer.flush();
            writer.close();
            System.out.println("A despesa foi registrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * O método excluirDespesa() permite ao usuário remover uma despesa do sistema.
     * Solicita-se ao usuário o ID da despesa que deseja remover e realiza a remoção, se encontrada.
     * Se a despesa não é encontrada, é exibida uma mensagem ao usuário no console.
     * As despesas atualizadas são armazenadas em um arquivo JSON.
     */    
    public void excluirDespesa(){
        Scanner teclado = new Scanner(System.in);

        if(listaDespesasRegistradas.isEmpty()){
            System.out.println("Não é possível usar a função de remover pois não há despesas no sistema!");
        } else {
            System.out.println("Insira o ID da despesa que deseja remover: ");
            int idDespesa = teclado.nextInt();
            boolean despesaFoiEncontrada = false;

            for (Despesa despesa : listaDespesasRegistradas) {
                if (despesa.getIdDespesa()== idDespesa) {
                    listaDespesasRegistradas.remove(despesa);
                    despesaFoiEncontrada = true;
                    System.out.println("Despesa removida com sucesso!");
                    break;
                }
            }

            if (!despesaFoiEncontrada) {
                System.out.println("Despesa não encontrada no sistema.");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String objetosConvertidos = gson.toJson(listaDespesasRegistradas);

            try (FileWriter writer = new FileWriter("arquivosJson/despesasEmJson.txt")) {
                writer.write(objetosConvertidos);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * O método emitirRelatorioVendas() apenas permite ao usuário escolher entre emitir um relatório diário ou mensal de vendas.
     * Chama os métodos específicos de relatório, diário ou mensal, de acordo com a escolha do usuário.
     */    
    public void emitirRelatorioVendas(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite 1 se voce deseja emitir um relatório diário ou digite 2 se você deseja emitir um relatório mensal: ");
        String escolha = teclado.nextLine();
        
        if(escolha.equals("1")){
            emitirRelatorioDiario();
        } else if(escolha.equals("2")){
            emitirRelatorioMensal();
        }

    }
    
    /**
     * O método emitirRelatorioDiario() exibe um relatório diário de vendas com base na data escolhida pelo usuário.
     * O relatório inclui o número de vendas realizadas e o valor total de vendas para cada caixa na data especificada.
     * Caso não haja vendas na data escolhida, uma mensagem apropriada é exibida.
     */   
    public void emitirRelatorioDiario() {
        Scanner teclado = new Scanner(System.in);

        // Solicitar ao usuário que insira a data para o relatório diário
        System.out.println("Digite a data para o relatório diário (dd/MM/yyyy): ");
        String dataRelatorio = teclado.nextLine();

        // Converter a string da data para um objeto Date
        Date dataEscolhida = null;
        try {
            dataEscolhida = new SimpleDateFormat("dd/MM/yyyy").parse(dataRelatorio);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Abortando a geração do relatório.");
            return;
        }

        // Inicializar variáveis para contagem do total de vendas e valores por caixa
        Map<String, Integer> vendasPorCaixa = new HashMap<>();
        Map<String, Double> valoresPorCaixa = new HashMap<>();

        // Iterar sobre as vendas realizadas na data escolhida
        for (Venda venda : listaVendasRealizadas) {
            // Truncar a parte da hora, minutos e segundos da data da venda
            Date dataVendaSemHora = truncateHora(venda.getDataVenda());

            // Verificar se a venda ocorreu na data escolhida
            if (dataVendaSemHora.equals(dataEscolhida)) {
                // Atualizar valores por caixa
                String caixa = venda.getCodigoCaixa();
                double valorVenda = venda.getValorTotalVenda();

                vendasPorCaixa.put(caixa, vendasPorCaixa.getOrDefault(caixa, 0) + 1);
                valoresPorCaixa.put(caixa, valoresPorCaixa.getOrDefault(caixa, 0.0) + valorVenda);
            }
        }

        // Verificar se houve vendas na data escolhida
        if (vendasPorCaixa.isEmpty()) {
            System.out.println("Não houve vendas na data escolhida. Por favor, escolha outra data.");
            return;
        }

        // Exibir o relatório por caixa
        System.out.println("Relatório Diário - " + new SimpleDateFormat("dd/MM/yyyy").format(dataEscolhida));
        DecimalFormat df = new DecimalFormat("#.##");

        for (String caixa : listaCaixas) {
            int vendasRealizadas = vendasPorCaixa.getOrDefault(caixa, 0);
            double valorTotalCaixa = valoresPorCaixa.getOrDefault(caixa, 0.0);

            System.out.println(caixa + ": Vendas realizadas: " + vendasRealizadas + "; Valor total das vendas: " + df.format(valorTotalCaixa));
        }
    }
    
    /**
     * O método emitirRelatorioMensal() exibe um relatório mensal de vendas com base no mês e ano escolhidos pelo usuário.
     * O relatório inclui o número de vendas realizadas e o valor total de vendas para cada caixa no mês e ano especificados.
     * Caso não haja vendas no mês e ano escolhidos, uma mensagem apropriada é exibida.
     */    
    public void emitirRelatorioMensal() {
        Scanner teclado = new Scanner(System.in);

        // Solicitar ao usuário que insira o mês e ano para o relatório mensal
        System.out.println("Digite o mês (MM) e o ano (yyyy) para o relatório mensal: ");
        String mesAnoRelatorio = teclado.nextLine();

        // Converter a string do mês e ano para um objeto Date
        Date mesAnoEscolhido = null;
        try {
            mesAnoEscolhido = new SimpleDateFormat("MM/yyyy").parse(mesAnoRelatorio);
        } catch (ParseException e) {
            System.out.println("Formato de mês e ano inválido. Abortando a geração do relatório.");
            return;
        }

        // Inicializar variáveis para contagem do total de vendas e valores por caixa
        Map<String, Integer> vendasPorCaixa = new HashMap<>();
        Map<String, Double> valoresPorCaixa = new HashMap<>();

        // Iterar sobre as vendas realizadas no mês e ano escolhidos
        for (Venda venda : listaVendasRealizadas) {
            // Truncar a parte do dia, hora, minutos e segundos da data da venda
            Date dataVendaSemDia = truncateDia(venda.getDataVenda());

            // Verificar se a venda ocorreu no mês e ano escolhidos
            if (isMesAnoIgual(dataVendaSemDia, mesAnoEscolhido)) {
                // Atualizar valores por caixa
                String caixa = venda.getCodigoCaixa();
                double valorVenda = venda.getValorTotalVenda();

                vendasPorCaixa.put(caixa, vendasPorCaixa.getOrDefault(caixa, 0) + 1);
                valoresPorCaixa.put(caixa, valoresPorCaixa.getOrDefault(caixa, 0.0) + valorVenda);
            }
        }

        // Verificar se houve vendas no mês e ano escolhidos
        if (vendasPorCaixa.isEmpty()) {
            System.out.println("Não houve vendas no mês e ano escolhidos. Por favor, escolha outra data.");
            return;
        }

        // Exibir o relatório por caixa
        System.out.println("Relatório Mensal - " + new SimpleDateFormat("MM/yyyy").format(mesAnoEscolhido));
        DecimalFormat df = new DecimalFormat("#.##");

        for (String caixa : listaCaixas) {
            int vendasRealizadas = vendasPorCaixa.getOrDefault(caixa, 0);
            double valorTotalCaixa = valoresPorCaixa.getOrDefault(caixa, 0.0);

            System.out.println(caixa + ": Vendas realizadas: " + vendasRealizadas + "; Valor total das vendas: " + df.format(valorTotalCaixa));
        }
    }
    
    /**
     * O método gerarBalanco() exibe um balanço financeiro com base no mês e ano escolhidos pelo usuário.
     * O balanço inclui o total de despesas, total de receitas e o lucro para a data especificada.
     * Caso não haja despesas ou receitas no mês e ano escolhidos, uma mensagem é exibida.
     */    
    public void gerarBalanco() {
        Scanner teclado = new Scanner(System.in);

        // Solicitar ao usuário que insira o mês e ano para o balanço
        System.out.println("Digite o mês (MM) e o ano (yyyy) para o balanço: ");
        String mesAnoBalanco = teclado.nextLine();

        // Converter a string do mês e ano para um objeto Date
        Date mesAnoEscolhido = null;
        try {
            mesAnoEscolhido = new SimpleDateFormat("MM/yyyy").parse(mesAnoBalanco);
        } catch (ParseException e) {
            System.out.println("Formato de mês e ano inválido. Abortando a geração do balanço.");
            return;
        }

        // Inicializar variáveis para o somatório de despesas e receitas
        double totalDespesas = calcularDespesas(mesAnoEscolhido);
        double totalReceitas = calcularReceitas(mesAnoEscolhido);

        // Calcular o lucro (receitas - despesas)
        double lucro = totalReceitas - totalDespesas;

        // Exibir o balanço
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Balanço - " + new SimpleDateFormat("MM/yyyy").format(mesAnoEscolhido));
        System.out.println("Despesas: " + df.format(totalDespesas));
        System.out.println("Receitas: " + df.format(totalReceitas));
        System.out.println("Lucro: " + df.format(lucro));
    }
    
    /**
     * O método sairSistema() apenas exibe uma mensagem de encerramento do sistema quando chamado.
     */
    public void sairSistema(){
        System.out.println("Sistema encerrado. Até logo!");
    }
    
    
    // Abaixo estão alguns métodos utilitários para os métodos principais listados anteriormente.
    
 
    /**
     * O método calcularDespesas(Date mesAnoEscolhido) calcula o total de despesas para um determinado mês e ano.
     * Ele percorre a lista de despesas registradas, considerando apenas aquelas que correspondem ao mês e ano especificados.
     * @param mesAnoEscolhido Um objeto Date representando o mês e ano desejados.
     * @return O total de despesas para o mês e ano especificados.
     */    
    public double calcularDespesas(Date mesAnoEscolhido) {
        double totalDespesas = 0.0;

        for (Despesa despesa : listaDespesasRegistradas) {
            Date dataDespesaSemDia = truncateDia(despesa.getDataDespesa());

            if (isMesAnoIgual(dataDespesaSemDia, mesAnoEscolhido)) {
                // Considere apenas as despesas do mês e ano desejados
                totalDespesas += despesa.getValorDespesa();
            }
        }

        return totalDespesas;
    }

    /**
     * O método calcularReceitas(Date mesAnoEscolhido) calcula o total de receitas para um determinado mês e ano.
     * Ele percorre a lista de vendas realizadas, considerando apenas aquelas que correspondem ao mês e ano especificados.
     * @param mesAnoEscolhido Um objeto Date representando o mês e ano desejados.
     * @return O total de receitas para o mês e ano especificados.
     */
    public double calcularReceitas(Date mesAnoEscolhido) {
        double totalReceitas = 0.0;

        for (Venda venda : listaVendasRealizadas) {
            Date dataVendaSemDia = truncateDia(venda.getDataVenda());

            if (isMesAnoIgual(dataVendaSemDia, mesAnoEscolhido)) {
                totalReceitas += venda.getValorTotalVenda();
            }
        }

        return totalReceitas;
    }
    
    /**
     * O método parseDate(String dateStr) é responsável por converter uma string no formato "dd/MM/yyyy" para um objeto Date.
     * @param dateStr A string representando a data no formato "dd/MM/yyyy".
     * @return Um objeto Date representando a data convertida, ou null se ocorrer um erro de parse.
     */    
    public Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * O método truncateHora(Date date) trunca a parte da hora, minutos e segundos de uma data, deixando apenas a parte da data.
     * @param date A data a ser truncada.
     * @return Uma nova data com a parte da hora, minutos e segundos zerada.
     */    
    public Date truncateHora(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * O método truncateDia(Date date) trunca a parte do dia, hora, minutos e segundos de uma data, deixando apenas a parte do mês.
     * @param date A data a ser truncada.
     * @return Uma nova data com a parte do dia, hora, minutos e segundos zerada.
     */    
    public Date truncateDia(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * O método isMesAnoIgual(Date date1, Date date2) verifica se dois objetos Date representam o mesmo mês e ano.
     * @param date1 O primeiro objeto Date.
     * @param date2 O segundo objeto Date.
     * @return true se os objetos Date representam o mesmo mês e ano; false caso contrário.
     */    
    public boolean isMesAnoIgual(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

}
