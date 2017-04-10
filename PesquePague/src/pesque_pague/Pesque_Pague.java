package pesque_pague;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pesque_Pague {

    private static ArrayList<Comanda> comanda = new ArrayList<>();

    public static void main(String[] args) {
        new CriadorDeJSON();
        int cont = 0;
        do {
            if (cont == 0) {
                comanda.add(new Comanda("Henrique Starosky"));
                cont++;
            } else {
                int menu;
                String[] opc = {"Adicionar Comanda", "Fecha Comanda"};
                menu = JOptionPane.showOptionDialog(null, "Oi", "Blz", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
                switch (menu) {
                    case 0:

                        break;
                    case 1:
                        String[] listaComandas = new String[comanda.size()];
                        for (int i = 0; i < comanda.size(); i++) {
                            listaComandas[i] = "" + (i+1) + " - " + comanda.get(i).getNomeMaster();
                        }
                        JOptionPane.showInputDialog(null, "Selecione a comanda a ser apagada:", "Remove Comanda", JOptionPane.PLAIN_MESSAGE, null,listaComandas ,listaComandas[0]);
                        break;
                    default:
                        System.out.println("ok");
                }
            }

        } while (true);
    }
}

// String[] opc = {"Adicionar Comanda"};
// menu = JOptionPane.showOptionDialog(null, "Oi", "Blz", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
