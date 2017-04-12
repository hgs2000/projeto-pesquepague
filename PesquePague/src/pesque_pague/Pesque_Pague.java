package pesque_pague;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pesque_Pague {

    private static ArrayList<Comanda> comanda = new ArrayList<>();

    static Scanner tec = new Scanner(System.in);

    private static String pedeString(String string) {
        String aux = "";
        do {
            System.out.println(string);
            aux = tec.nextLine();
        } while (aux.isEmpty());
        return aux;
    }

    public static void main(String[] args) {
        new CriadorDeJSON();
        boolean b = true;
        int cont = 0;
        int menu;
        do {
            if (cont == 0) {
                comanda.add(new Comanda(pedeString("Informe o nome que nome do responsável da comanda: ")));
                cont++;
            } else {
                String[] opc = {"Adicionar Comanda", "Adicionar Produtos", "Fecha Comanda"};
                menu = JOptionPane.showOptionDialog(null, new JLabel("Menu", JLabel.CENTER), "Pesque-Paque Peixinho Bom", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
                switch (menu) {
                    case 0:
                        comanda.add(new Comanda(pedeString("Informe o nome que nome do responsável da comanda: ")));
                        break;
                    case 1:
                        String[] listaAdicionaProduto = new String[comanda.size()];
                        for (int i = 0; i < comanda.size(); i++) {
                            listaAdicionaProduto[i] = "" + (i + 1) + " - " + comanda.get(i).getNomeMaster();
                        }
                        JOptionPane.showInputDialog(null, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null, listaAdicionaProduto, listaAdicionaProduto[0]);
                        break;
                    case 2:
                        String[] listaRemocao = new String[comanda.size()];
                        for (int i = 0; i < comanda.size(); i++) {
                            if (comanda.get(i).getEstadoComanda() == false) {
                                listaRemocao[i] = "" + (i + 1) + " - " + comanda.get(i).getNomeMaster() + " (fechada)";
                            } else {
                                listaRemocao[i] = "" + (i + 1) + " - " + comanda.get(i).getNomeMaster();
                            }
                        }
                        String aRemover = (String) JOptionPane.showInputDialog(null, new JLabel("Selecione a comanda a ser apagada:", JLabel.CENTER), "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null, listaRemocao, listaRemocao[0]);
                        int valorARemover = pegaCodigoComanda(aRemover);
                        System.out.println(valorARemover);
                        comanda.get(valorARemover - 1).fechaComanda();
                        break;
                    default:
                        System.out.println("ok");
                        b = false;
                }
            }
        } while (b);
    }

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

// String[] opc = {"Adicionar Comanda"};
// menu = JOptionPane.showOptionDialog(null, "Oi", "Blz", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
