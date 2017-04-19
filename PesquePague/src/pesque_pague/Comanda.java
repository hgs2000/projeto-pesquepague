package pesque_pague;

import javax.swing.JOptionPane;
import static pesque_pague.Pesque_Pague.FRAME;

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
     * Método para adicionar produtos à comanda.
     */
    private void adicionaProduto() {
        String[] opcs = {"Adicionar Petisco", "Adicionar Bebida"};
        int opc = JOptionPane.showOptionDialog(FRAME, "Escolha o que adicionar:", "Adicionar Produto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
        String codSetor = JOptionPane.showInputDialog("Favor escrever seu setor (código identificador)");

        switch (opc) {
            case 0:

//Hgs continua daqui ;)
                opcs = new String[CriadorDeJSON.valor_json.size()];
                break;
            case 1:

                break;
            default:

                break;
        }
    }

    /**
     * Método para adicionar um produto Peixe à comanda.
     */
    private void adicionaPeixe() {

    }

    /**
     * Método para "remover" o produto da comanda.
     */
    private void cancelaProduto() {

    }

    /**
     * Método para adicionar um serviço à comanda.
     */
    private void adicionaServico() {

    }

    /**
     * Método para "remover" um serviço da comanda.
     */
    private void cancelaServico() {

    }

    /**
     * Método utilizado para retornar o estado da Comanda.
     *
     * @return true quando aberta e false quando fechada.
     */
    private boolean getEstadoComanda() {
        return comandaAberta;
    }

    /**
     * Método utilizado para retornar o nome do usuário dono da Comanda.
     *
     * @return Nome do usuário da Comanda
     */
    private String getNomeMaster() {
        return master_comanda;
    }

    /**
     *
     */
    public void controleComanda() {
        String[] opcs = {"Adiciona Produto", "Adiciona Peixe", "Cancela Produto Registrado", "Adiciona Servico", "Remove Servico"};
        int opc = JOptionPane.showOptionDialog(FRAME, "Escolha a opção a ser realizada", "Comanda de " + master_comanda, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
        switch (opc) {
            case 0:
                adicionaProduto();
                break;
            case 1:
                adicionaPeixe();
                break;
            case 2:
                cancelaProduto();
                break;
            case 3:
                adicionaServico();
                break;
            case 4:
                cancelaServico();
                break;
            default:
                System.out.println(opc);
        }

    }

    public Comanda(String nome_master) {
        novaComanda();
        this.master_comanda = nome_master;
    }
}
