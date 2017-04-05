package pesque_pague;

import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pesque_Pague {

    public static void main(String[] args) {
        new CriadorDeJSON();
    }

    static void carregaArquivos() {

        File fl = new File("src/pesque_pague/arquivo.json");
        if (fl.exists()) {
            System.out.println("foi");
            try {
                FileReader fr = new FileReader(fl);
                JsonReader reader = new JsonReader(fr);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Pesque_Pague.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("não foi");
        }

    }
}
