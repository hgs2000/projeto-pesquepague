package pesque_pague;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pesque_Pague {

    private static ArrayList<Comanda> comanda = new ArrayList<>();
    final static JFrame frame = new JFrame() {
        {
            setTitle("Pesque Pague Peixinho Bom");
            setVisible(true);
            setSize(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.decode("0XACE5EE"));
        }
    };

    private static String pedeString(String string) {
        String aux = "";
        do {
            aux = JOptionPane.showInputDialog(frame, string, null, JOptionPane.PLAIN_MESSAGE);
            if (aux == null) {
                return pedeString(string);
            }
        } while (aux.isEmpty());
        return aux;
    }

    public static void main(String[] args) {
        //new CriadorDeJSON();
        boolean continuar = true;
        int cont = 0;
        int menu;
        do {
            if (cont == 0) {
                comanda.add(new Comanda(pedeString("Informe o nome que nome do responsável da comanda: ")));
                cont++;
            } else {
                String[] opc = {"Adicionar Comanda", "Adicionar Produtos", "Fecha Comanda"};
                menu = JOptionPane.showOptionDialog(frame, new JLabel("Menu", JLabel.CENTER), null, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
                switch (menu) {
                    case 0:
                        comanda.add(new Comanda(pedeString("Informe o nome que nome do responsável da comanda: ")));
                        break;
                    case 1:
                        String[] listaAdicionaProduto = retornaListaDePessoas();
                        String aAlterar = (String) JOptionPane.showInputDialog(frame, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remover Comanda", JOptionPane.PLAIN_MESSAGE, null, listaAdicionaProduto, listaAdicionaProduto[0]);
                        if (aAlterar.contains(" (fechada)")) {
                            System.out.println("Está fechada ;-;");
                            JOptionPane.showMessageDialog(frame, "Está fechada", "Erro", JOptionPane.WARNING_MESSAGE);
                            break;
                        } else {
                            System.out.println("Está aberta ÔuÔ");
                            comanda.get(pegaCodigoComanda(aAlterar) - 1).controleComanda();
                            break;
                        }
                    case 2:
                        String[] listaRemocao = retornaListaDePessoas();
                        int valorARemover = pegaCodigoComanda((String) JOptionPane.showInputDialog(frame, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null, listaRemocao, listaRemocao[0]));
                        if (listaRemocao[valorARemover - 1].contains(" (fechada)")) {
                            JOptionPane.showMessageDialog(frame, "Está fechada", "Erro", JOptionPane.WARNING_MESSAGE);
                        } else {
                            System.out.println("Aberto");
                            comanda.get(valorARemover - 1).fechaComanda();
                        }

                        break;
                    default:
                        System.out.println("O programa está fechando");
                        System.exit(0);
                        continuar = false;
                }
            }
        } while (continuar);
    }

    private static String[] retornaListaDePessoas() {
        String[] lista = new String[comanda.size()];
        for (int i = 0; i < comanda.size(); i++) {
            if (comanda.get(i).getEstadoComanda() == false) {
                lista[i] = "" + (i + 1) + " - " + comanda.get(i).getNomeMaster() + " (fechada)";
            } else {
                lista[i] = "" + (i + 1) + " - " + comanda.get(i).getNomeMaster();
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
