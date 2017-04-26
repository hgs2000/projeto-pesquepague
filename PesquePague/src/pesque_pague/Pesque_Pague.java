package pesque_pague;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pesque_Pague {

    public static final CriadorDeJSON CDJSON = new CriadorDeJSON();

    private static final ArrayList<Comanda> COMANDA = new ArrayList<>();
    final static JFrame FRAME = new JFrame() {
        {
            setTitle("Pesque Pague Peixinho Bom");
            setVisible(true);
            setSize(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.decode("0XACE5EE"));
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            setIconImage(new ImageIcon(getClass().getResource("peixes.png"), "Peixes").getImage());
        }
    };

    private static String novaComanda(String string) {
        String aux = "";
        do {
            aux = JOptionPane.showInputDialog(FRAME, string, null, JOptionPane.PLAIN_MESSAGE);
            if (aux == null) {
                return novaComanda(string);
            }
        } while (aux.isEmpty());
        return aux;
    }

    public static void main(String[] args) {
        //Variável utilizada para verificar se o programa deve continuar a executar.
        boolean continuar = true;
        //Contador de número de comandas
        int cont = 0;
        do {
            int menu;
            String[] opc = {"Adicionar Comanda", "Adicionar Produtos", "Fecha Comanda", "Listar Produtos Na Comanda"};
            menu = JOptionPane.showOptionDialog(FRAME, new JLabel("Menu", JLabel.CENTER), null, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
            switch (menu) {
                //Adiciona comanda 'x'
                case 0:
                    COMANDA.add(new Comanda(novaComanda("Informe o nome que nome do responsável da comanda: ")));
                    break;
                //Modificar produtos da comanda 'x'
                case 1:
                    try {
                        String[] listaAdicionaProduto = retornaListaDePessoas();
                        String aAlterar = (String) JOptionPane.showInputDialog(FRAME, new JLabel("Selecione a comanda a ser utilizada:", JLabel.CENTER), "Remover Comanda", JOptionPane.PLAIN_MESSAGE, null, listaAdicionaProduto, listaAdicionaProduto[0]);
                        if (aAlterar.contains(" (fechada)")) {
                            System.out.println("Está fechada ;-;");
                            JOptionPane.showMessageDialog(FRAME, "Erro: A Lista está fechada", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        } else {
                            do {
                                System.out.println("Está aberta ÔuÔ");
                                COMANDA.get(pegaCodigoComanda(aAlterar) - 1).controleComanda();
                            } while (true);
                        }
                    } catch (Exception e) {
                        if (e.getMessage().equals("sair")) {
                            System.out.println(e.getMessage());
                        } else if (e.getClass().equals(ArrayIndexOutOfBoundsException.class)) {
                            JOptionPane.showMessageDialog(FRAME, "Erro. Não há comandas registradas.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                //Fecha comanda 'x'
                case 2:
                    try {
                        String[] listaRemocao = retornaListaDePessoas();
                        int valorARemover = pegaCodigoComanda((String) JOptionPane.showInputDialog(FRAME, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null, listaRemocao, listaRemocao[0]));
                        if (listaRemocao[valorARemover - 1].contains(" (fechada)")) {
                            System.out.println("Fechada");
                            JOptionPane.showMessageDialog(FRAME, "Está fechada", "Erro", JOptionPane.WARNING_MESSAGE);
                        } else {
                            System.out.println("Aberto");
                            COMANDA.get(valorARemover - 1).fechaComanda();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(FRAME, "Erro. Não há comandas registradas.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 3:
                    String[] listaMostrar = retornaListaDePessoas();
                    int valorAMostrar = pegaCodigoComanda((String) JOptionPane.showInputDialog(FRAME, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null, listaMostrar, listaMostrar[0]));
                    if (listaMostrar[valorAMostrar - 1].contains(" (fechada)")) {
                        System.out.println("Fechada");
                        JOptionPane.showMessageDialog(FRAME, "Está fechada", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("Aberto");
                        COMANDA.get(valorAMostrar - 1).mostraProdutos();
                    }
                    break;
                default:
                    System.out.println("O programa está fechando");
                    System.exit(0);
                    continuar = false;
            }
        } while (continuar);
    }

    private static String[] retornaListaDePessoas() {
        String[] lista = new String[COMANDA.size()];
        for (int i = 0; i < COMANDA.size(); i++) {
            if (COMANDA.get(i).getEstadoComanda() == false) {
                lista[i] = "" + (i + 1) + " - " + COMANDA.get(i).getNomeMaster() + " (fechada)";
            } else {
                lista[i] = "" + (i + 1) + " - " + COMANDA.get(i).getNomeMaster();
            }
        }
        return lista;
    }

    /**
     * Método utilizado para pegar o número da posição da comanda.
     *
     * @param aRemover
     * @return código da comanda
     */
    private static int pegaCodigoComanda(String aRemover) {
        String nums = "";
        for (int i = 0; i < aRemover.length(); i++) {
            if (Character.isDigit(aRemover.charAt(i))) {
                nums += aRemover.charAt(i);
            } else if (aRemover.charAt(i) == ' ') {
                break;
            }
        }
        return Integer.parseInt(nums);
    }

}
