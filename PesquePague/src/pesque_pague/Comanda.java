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

    private final DecimalFormat df = new DecimalFormat("#.00");
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
     * @param opcao : 1 para adicionar produto, 2 para adicionar um peixe ou 3
     * para serviço
     */
    private void adicionaProduto(int opcao) {
        switch (opcao) {
            case 1:
                String[] opcs = {"Adicionar Petisco", "Adicionar Bebida"};
                int opc = JOptionPane.showOptionDialog(FRAME, "Escolha o que adicionar:", "Adicionar Produto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
                //String codSetor = JOptionPane.showInputDialog("Favor escrever seu setor (código identificador)");
                switch (opc) {
                    case 0: {
                        adicionarProduto2("comidas");
                        break;
                    }
                    //Hgs continua daqui ;)
                    case 1:
                        adicionarProduto2("bebidas");
                        break;
                    default:
                        break;
                }
                break;
            case 2: {
                adicionarProduto2("peixes");
                break;
            }
            case 3: {
                adicionarProduto2("servicos");
                break;
            }
            default:
                System.out.println("Informar o desenvolvedor se e como você chegou aqui.");
        }
    }

    private void adicionarProduto2(String codigo) {
        try {
            Map<String, Float> mp = CDJSON.getOpcoes(codigo);
            String[] opcoes = new String[mp.size()];
            int cont = 0;
            for (Map.Entry<String, Float> valores : mp.entrySet()) {
                opcoes[cont] = "" + (cont + 1) + ". " + valores.getKey() + " -- R$" + df.format(valores.getValue());
                cont++;
            }
            String adicionaProduto = (String) JOptionPane.showInputDialog(FRAME, "Escolha o deve ser adicionado à comanda.", "Adicionar " + codigo, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            pegaProduto(mp, adicionaProduto);
        } catch (Exception ex) {
            Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método utilizado para adicionar o produto a lista de produtos na comanda.
     *
     * @param mp: Mapa de produtos
     * @param produtoAAdicionar: nome do produto a ser adicionado;
     */
    private void pegaProduto(Map<String, Float> mp, String produtoAAdicionar) {
        try {
            //int quantProduto;

            /*if (!produtoAAdicionar.matches(".([0-9])*.")) {
            quantProduto = 1;
            } else {
            
            }*/
            for (Map.Entry<String, Float> valores : mp.entrySet()) {
                if (produtoAAdicionar.contains(valores.getKey())) {
                    LISTA_DE_PRODUTOS.put(valores.getKey(), valores.getValue());
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("ata");
        }
    }

    /**
     * Método para "remover" o produto da comanda.
     */
    private void cancelaProduto() {
        String[] lista = new String[LISTA_DE_PRODUTOS.size()];
        int cont = 0;
        for (Map.Entry<String, Float> valores : LISTA_DE_PRODUTOS.entrySet()) {
            lista[cont] = "" + (cont + 1) + ". " + valores.getKey() + " -- R$" + df.format(valores.getValue());
            cont++;
        }
        String produto = (String) JOptionPane.showInputDialog(FRAME, "Escolha o registro a ser cancelado:", "Cancelar registro", JOptionPane.PLAIN_MESSAGE, null, lista, lista[0]);
        if (!produto.contains(" (removido)")) {
            for (Map.Entry<String, Float> valores : LISTA_DE_PRODUTOS.entrySet()) {
                if (produto.contains(valores.getKey())) {
                    //int numero = pegaNumeroDeProdutos(produto);
                    LISTA_DE_PRODUTOS.put(valores.getKey() + " (removido) ( "/* + numero */ + ")", valores.getValue());
                    LISTA_DE_PRODUTOS.remove(valores.getKey());
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(FRAME, "Erro. O produto já foi removido.", "Erro: Produto Removido", JOptionPane.INFORMATION_MESSAGE);
        }
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
     * Método utilizado para controlar a comanda
     *
     * @throws Exception
     */
    public void controleComanda() throws Exception {
        String[] opcs = {"Adiciona Produto", "Adiciona Peixe", "Adiciona Servico", "Cancela Produto Registrado"};
        int opc = JOptionPane.showOptionDialog(FRAME, "Escolha a opção a ser realizada", "Comanda de " + master_comanda, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcs, opcs[0]);
        switch (opc) {
            case 0:
                adicionaProduto(1);
                break;
            case 1:
                adicionaProduto(2);
                break;
            case 2:
                try {
                    adicionaProduto(3);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(FRAME, "Erro. Não há serviços registrados.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            case 3:
                try {
                    cancelaProduto();
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(FRAME, "Erro. Não há produtos/serviços na comanda de " + getNomeMaster() + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                    System.out.println();
                    break;
                }
            default:
                throw new Exception("sair");
        }
    }

    public void mostraProdutos() {
        String[] lista = new String[LISTA_DE_PRODUTOS.size()];
        int cont = 0;
        for (Map.Entry<String, Float> valores : LISTA_DE_PRODUTOS.entrySet()) {
            lista[cont] = "" + valores.getKey() + " -- R$" + df.format(valores.getValue());
            cont++;
        }
        JOptionPane.showMessageDialog(FRAME, "Lista dos Produtos registrados", "Lista de Produtos Registrados", JOptionPane.PLAIN_MESSAGE);
    }

    public Comanda(String nome_master) {
        novaComanda();
        this.master_comanda = nome_master;
    }

    /* private int pegaNumeroDeProdutos(String produto) {
        String codigo = "";
        try {
            int cont = 0;
            for (int i = 1; i < produto.length(); i++) {
                if (produto.substring(cont, cont + i).matches("([0-9]*)")) {
                    codigo = produto.substring(cont, cont + i);
                    break;
                }
                cont++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("out of bounds. continua o jogo");
        }
        return Integer.parseInt(codigo);
    }*/
}
