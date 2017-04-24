package pesque_pague;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static pesque_pague.Pesque_Pague.FRAME;
import static pesque_pague.Pesque_Pague.CDJSON;

public class Comanda {

    private DecimalFormat df = new DecimalFormat("#.00");
    private boolean comandaAberta;
    private final String master_comanda;
    private final Map<String, Float> LISTA_DE_PRODUTOS = new HashMap<>();

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
                case 0: {
                    try {
                        Map<String, Float> mp = CDJSON.getOpcoes("comidas");
                        String[] opcs_comidas = new String[mp.size()];
                        int cont = 0;
                        DecimalFormat df = new DecimalFormat("#.00");
                        for (Map.Entry<String, Float> valores : mp.entrySet()) {
                            opcs_comidas[cont] = "" + (cont + 1) + ". " + valores.getKey() + " -- R$" + df.format(valores.getValue());
                            cont++;
                        }
                        String adicionaProduto = (String) JOptionPane.showInputDialog(FRAME, "rada", "rada", JOptionPane.PLAIN_MESSAGE, null, opcs_comidas, opcs_comidas[0]);
                        for (Map.Entry<String, Float> valores : mp.entrySet()) {
                            if (adicionaProduto.contains(valores.getKey())) {
                                LISTA_DE_PRODUTOS.put(valores.getKey(), valores.getValue());
                                break;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Hgs continua daqui ;)
                break;
                case 1:
                    try {
                        Map<String, Float> mp = CDJSON.getOpcoes("bebidas");
                        String[] opcs_comidas = new String[mp.size()];
                        int cont = 0;

                        for (Map.Entry<String, Float> valores : mp.entrySet()) {
                            opcs_comidas[cont] = "" + (cont + 1) + ". " + valores.getKey() + " -- R$" + df.format(valores.getValue());
                            cont++;
                        }
                        String adicionaProduto = (String) JOptionPane.showInputDialog(FRAME, "rada", "rada", JOptionPane.PLAIN_MESSAGE, null, opcs_comidas, opcs_comidas[0]);
                    } catch (Exception ex) {
                        Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        String[] lista = new String[LISTA_DE_PRODUTOS.size()];
        int cont = 0;
        for (Map.Entry<String, Float> valores : LISTA_DE_PRODUTOS.entrySet()) {
            lista[cont] = "" + valores.getKey() + " - " + df.format(valores.getValue());
            cont++;
        }
        JOptionPane.showInputDialog(FRAME, "nah", "ffs", JOptionPane.PLAIN_MESSAGE, null, lista, lista[0]);
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
