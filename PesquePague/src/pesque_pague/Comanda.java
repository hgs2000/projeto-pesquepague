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
     *
     * @param opcao : 1 para adicionar produto ou 2 para adicionar um peixe
     */
    private void adicionaProduto(int opcao) {
        if (opcao == 1) {
            String[] opcs = {"Adicionar Petisco", "Adicionar Bebida"};
            int opc = JOptionPane.showOptionDialog(FRAME, "Escolha o que adicionar:", "Adicionar Produto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
            //String codSetor = JOptionPane.showInputDialog("Favor escrever seu setor (código identificador)");
            switch (opc) {
                case 0:
                    
                    //Hgs continua daqui ;)
                    break;
                case 1:

                    break;
                default:

                    break;
            }
        } else {

        }
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

    /**
     *
     */
    public void controleComanda() {
        String[] opcs = {"Adiciona Produto", "Adiciona Peixe", "Cancela Produto Registrado", "Adiciona Servico", "Remove Servico"};
        int opc = JOptionPane.showOptionDialog(FRAME, "Escolha a opção a ser realizada", "Comanda de " + master_comanda, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
        switch (opc) {
            case 0:
                adicionaProduto(1);
                break;
            case 1:
                adicionaProduto(2);
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
