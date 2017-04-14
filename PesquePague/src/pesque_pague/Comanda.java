package pesque_pague;

public class Comanda {

    private boolean comandaAberta;
    private final String master_comanda;

    /**
     * Muda o valor de comandaAberta para aberta (true).
     */
    private void novaComanda() {
        comandaAberta = true;
    }

    /**
     * Muda o valor de comandaAberta para fechada (false).
     */
    public void fechaComanda() {
        comandaAberta = false;
    }

    /**
     *
     * @param produto
     * @param codigoSetor
     */
    public void adicionaProduto(Produto produto, int codigoSetor) {

    }

    /**
     *
     * @param peixe
     */
    public void adicionaProduto(Peixe peixe) {

    }

    /**
     *
     * @param tipoServico
     * @param codigoSetor
     */
    public void adicionaServico(int tipoServico, int codigoSetor) {

    }

    /**
     * Método utilizado para retornar o estado da Comanda.
     *
     * @return true quando aberta e false quando fechada.
     */
    public boolean getEstadoComanda() {
        return comandaAberta;
    }

    /**
     * Método utilizado para retornar o nome do usuário dono da Comanda.
     *
     * @return Nome do usuário da Comanda
     */
    public String getNomeMaster() {
        return master_comanda;
    }

    public Comanda(String nome_master) {
        novaComanda();
        this.master_comanda = nome_master;
    }

}
