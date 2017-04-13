package pesque_pague;

import java.util.HashMap;
import java.util.Map;

public class CriadorDeJSON {

    //http://stackoverflow.com/questions/11851603/how-to-convert-hashmap-to-json-file
    public CriadorDeJSON() {
        Map<String, Map<String, Float>> valor_json = new HashMap<>();
        valor_json.put("comidas", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);

            }
        });
        valor_json.put("bebidas", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);

            }
        });
        valor_json.put("servicos", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);

            }
        });
        valor_json.put("peixes", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);

            }
        });
        valor_json.put("setores", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);

            }
        });

    }
}
