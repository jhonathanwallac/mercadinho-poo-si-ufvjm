package pooufvjm.projetomercadinho;

import java.util.Date;

/**
 * A classe Despesa representa as despesas que compõem uma das informações do balanco mensal emitido pelo sistema.
 * @author Jhonathan Wallace Lacerda dos Santos
 * @author Pedro Henrique Barroso
 */
public class Despesa {
    // Questão 1: Implementação da classe com base no diagrama de classes criado.
    
    private int idDespesa;
    private String nomeDespesa;
    private float valorDespesa;
    private Date dataDespesa;

    /**
     * Construtor que inicializa uma Despesa com informações detalhadas.
     *
     * @param idDespesa    O ID da despesa.
     * @param nomeDespesa  O nome da despesa.
     * @param valorDespesa O valor da despesa.
     * @param dataDespesa  A data da despesa.
     */
    public Despesa(int idDespesa, String nomeDespesa, float valorDespesa, Date dataDespesa) {
        this.idDespesa = idDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
        this.dataDespesa = dataDespesa;
    }

    /**
     * Construtor padrão que cria uma Despesa sem informações iniciais.
     */
    public Despesa() {

    }

    /**
     * Obtém o ID da despesa.
     *
     * @return O ID da despesa.
     */
    public int getIdDespesa() {
        return idDespesa;
    }

    /**
     * Define o ID da despesa.
     *
     * @param idDespesa O ID da despesa.
     */
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    /**
     * Obtém o nome da despesa.
     *
     * @return O nome da despesa.
     */
    public String getNomeDespesa() {
        return nomeDespesa;
    }

    /**
     * Define o nome da despesa.
     *
     * @param nomeDespesa O nome da despesa.
     */
    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    /**
     * Obtém o valor da despesa.
     *
     * @return O valor da despesa.
     */
    public float getValorDespesa() {
        return valorDespesa;
    }

    /**
     * Define o valor da despesa.
     *
     * @param valorDespesa O valor da despesa.
     */
    public void setValorDespesa(float valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    /**
     * Obtém a data da despesa.
     *
     * @return A data da despesa.
     */
    public Date getDataDespesa() {
        return dataDespesa;
    }

    /**
     * Define a data da despesa.
     *
     * @param dataDespesa A data da despesa.
     */
    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    /**
     * Converte a Despesa em uma representação de string.
     *
     * @return Uma string contendo informações sobre a Despesa.
     */
    @Override
    public String toString() {
        // Questão 3: Sobrescrever o método toString() de todas as classes implementadas.
        
        return "\n"
                + "ID despesa: " + getIdDespesa() + "\n"
                + "Valor despesa: " + getValorDespesa() + "\n"
                + "Data despesa: " + getDataDespesa() + "\n"
                + "Nome despesa: " + getNomeDespesa();
    }
}
