package pesque_pague;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static pesque_pague.Pesque_Pague.FRAME;

public class Comanda {

    private boolean comandaAberta;
    private final String master_comanda;
    private ArrayList<Produto> produtos_comanda = new ArrayList<>();

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
     */
    private void adicionaProduto() {
        String[] opcs = {"Adicionar Petisco", "Adicionar Bebida"};
        System.out.println(JOptionPane.showOptionDialog(FRAME, "Escolha o que adicionar:", "Adiciona Produto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]));
    }

    /**
     *
     */
    private void adicionaPeixe() {

    }

    private void cancelaProduto() {

    }

    /**
     *
     */
    private void adicionaServico() {

    }

    private void removeServico() {

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
                removeServico();
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
