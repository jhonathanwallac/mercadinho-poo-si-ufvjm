package pooufvjm.projetomercadinho;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import pooufvjm.projetomercadinho.Decorator.Produto;

/**
 * A classe Venda representa uma transação de venda no mercadinho.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Venda {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    private int idVenda;
    private Date dataVenda;
    private String statusVenda;
    private List<Produto> itensVendidos;
    private double valorTotalVenda;
    private String cpfComprador;
    private String nomeComprador;
    private String codigoCaixa;

    /**
     * Construtor padrão que cria uma Venda sem informações iniciais.
     */
    public Venda() {

    }

    /**
     * Construtor que inicializa uma Venda com informações detalhadas.
     *
     * @param idVenda         O ID da venda.
     * @param dataVenda       A data da venda.
     * @param statusVenda     O status da venda.
     * @param itensVendidos   A lista de produtos vendidos.
     * @param valorTotalVenda O valor total da venda.
     * @param cpfComprador    O CPF do comprador.
     * @param nomeComprador   O nome do comprador.
     * @param codigoCaixa     O código do caixa onde a venda foi realizada.
     */
    public Venda(int idVenda, Date dataVenda, String statusVenda, List<Produto> itensVendidos, double valorTotalVenda, String cpfComprador, String nomeComprador, String codigoCaixa) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.statusVenda = statusVenda;
        this.itensVendidos = itensVendidos;
        this.valorTotalVenda = valorTotalVenda;
        this.cpfComprador = cpfComprador;
        this.nomeComprador = nomeComprador;
        this.codigoCaixa = codigoCaixa;
    }

    /**
     * Obtém o ID da venda.
     *
     * @return O ID da venda.
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * Define o ID da venda.
     *
     * @param idVenda O ID da venda.
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * Obtém a data da venda.
     *
     * @return A data da venda.
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * Define a data da venda.
     *
     * @param dataVenda A data da venda.
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * Obtém o status da venda.
     *
     * @return O status da venda.
     */
    public String getStatusVenda() {
        return statusVenda;
    }

    /**
     * Define o status da venda.
     *
     * @param statusVenda O status da venda.
     */
    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    /**
     * Obtém a lista de produtos vendidos.
     *
     * @return A lista de produtos vendidos.
     */
    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }

    /**
     * Define a lista de produtos vendidos.
     *
     * @param itensVendidos A lista de produtos vendidos.
     */
    public void setItensVendidos(List<Produto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    /**
     * Obtém o valor total da venda.
     *
     * @return O valor total da venda.
     */
    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    /**
     * Define o valor total da venda.
     *
     * @param valorTotalVenda O valor total da venda.
     */
    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    /**
     * Obtém o CPF do comprador.
     *
     * @return O CPF do comprador.
     */
    public String getCpfComprador() {
        return cpfComprador;
    }

    /**
     * Define o CPF do comprador.
     *
     * @param cpfComprador O CPF do comprador.
     */
    public void setCpfComprador(String cpfComprador) {
        this.cpfComprador = cpfComprador;
    }

    /**
     * Obtém o nome do comprador.
     *
     * @return O nome do comprador.
     */
    public String getNomeComprador() {
        return nomeComprador;
    }

    /**
     * Define o nome do comprador.
     *
     * @param nomeComprador O nome do comprador.
     */
    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    /**
     * Obtém o código do caixa onde a venda foi realizada.
     *
     * @return O código do caixa.
     */
    public String getCodigoCaixa() {
        return codigoCaixa;
    }

    /**
     * Define o código do caixa onde a venda foi realizada.
     *
     * @param codigoCaixa O código do caixa.
     */
    public void setCodigoCaixa(String codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    /**
     * Converte a Venda em uma representação de string.
     *
     * @return Uma string contendo informações sobre a Venda.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat formatoDecimal = new DecimalFormat("#0.00");

        StringBuilder sb = new StringBuilder();

        sb.append("EXTRATO DA VENDA\n");

        // Adicionar informações sobre os itens da venda (sem quantidade)
        sb.append("Itens da venda:\n");
        for (Produto produto : getItensVendidos()) {
            sb.append("   - ").append(produto.getNome()).append(", Preço: R$ ").append(formatoDecimal.format(produto.getPreco())).append("\n");
        }

        sb.append("############################################################\n");
        sb.append("ID da venda: ").append(getIdVenda()).append("\n");
        sb.append("Data da venda: ").append(dateFormat.format(getDataVenda())).append("\n");
        sb.append("Status da venda: ").append(getStatusVenda()).append("\n");
        sb.append("Valor total da venda: R$ ").append(formatoDecimal.format(getValorTotalVenda())).append("\n");
        sb.append("CPF do comprador: ").append(getCpfComprador()).append("\n");
        sb.append("Nome do comprador: ").append(getNomeComprador()).append("\n");
        sb.append("Caixa da venda: ").append(getCodigoCaixa()).append("\n");

        return sb.toString();
    }
}
