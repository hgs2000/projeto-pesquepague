package pesque_pague;

import java.util.HashMap;
import java.util.Map;

public class CriadorDeJSON {

    static Map<String, Map<String, Float>> valor_json = new HashMap<>();

    public static Map<String, Float> getOpcoes(String tipo) throws Exception {
        if (valor_json.containsKey(tipo)) {
            return valor_json.get(tipo);
        } else {
            throw new Exception("Erro. Opção indisponível.");
        }
    }

    /**
     * Criado por Isabelle Kuehlewein
     *
     */
    public CriadorDeJSON() {

        valor_json.put("comidas", new HashMap<String, Float>() {
            {
                put("Porção de Peixe Frito (500g)", 20.00f);
                put("Meia Porção de Peixe Frito (250g)", 10.0f);
                put("Porção de Batata Frita (500g)", 17.00f);
                put("Meia Porção de Batata Frita", 8.50f);
                put("Porção de Polenta (500g)", 15.00f);
                put("Meia Porção de Polenta (250g)", 7.50f);
                put("X-Salada", 10.00f);
                put("X-Frango", 12.00f);
                put("X-Burger", 7.20f);
                put("X-Bacon", 12.00f);
                put("X-Egg", 9.00f);
                put("X-Tudo", 15.00f);
                put("Pastel de Frango", 4.50f);
                put("Pastel de Tilápia", 6.00f);
                put("Pastel de Carne", 4.50f);
                put("Pastel de Queijo", 4.00f);
                put("Pastel de Palmito", 4.00f);
                put("Pastel de Pizza", 4.50f);
                put("Pastel de Brigadeiro", 4.00f);
                put("Picolé de Fruta", 2.00f);
                put("Picolé com Recheio", 4.00f);
                put("Paleta Mexicana Recheada", 10.00f);
                put("Paleta Mexicana sem Recheio", 6.00f);
            }
        });
        valor_json.put("bebidas", new HashMap<String, Float>() {
            {
                put("Cerveja Skol", 6.50f);
                put("Cerveja Brahma", 6.50f);
                put("Cerveja Antárctica", 6.00f);
                put("Cerveja Sub Zero", 5.50f);
                put("Cerveja Antárctica Original", 7.50f);
                put("Refrigerante Pequeno (200ml)", 2.50f);
                put("Refrigerante Lata", 3.80f);
                put("Refrigerante 500ml ", 4.50f);
                put("Refrigerante 2l", 9.00f);
                put("H2OH!", 4.50f);
                put("Água sem gás", 1.50f);
                put("Água com gás", 2.50f);
                put("Taça Pequena de Vinho (200 ml)", 3.50f);
                put("Taça Grande de Vinho (400 ml)", 5.00f);
                put("Garrafa de Vinho (1.5 l)", 18.00f);
                put("Energético Red Bull", 10.00f);
                put("Energético Red Hot", 6.00f);
                put("Campari (100ml)", 5.00f);
                put("Run Bacardi (100ml)", 5.00f);
                put("Vodka (100ml)", 5.00f);
                put("Caipirinha (400ml)", 5.50f);
                put("Caipirissima (400ml)", 8.00f);
                put("Tequila Souza (200ml)", 12.00f);
            }
        });
        valor_json.put("servicos", new HashMap<String, Float>() {
            {
                put("Pedalinho (15min)", 4.00f);
                put("Pedalinho (1h)", 7.00f);
                put("Parque Aquático", 20.00f);
                put("Camping", 25.00f);
            }
        });
        valor_json.put("peixes", new HashMap<String, Float>() {
            {
                put("Tilápia", 12.00f);
                put("Traíra", 13.00f);
                put("Pacu", 13.00f);
                put("Carpa", 12.00f);
                put("Pintado", 30.00f);
                put("Cascudo", 13.00f);
            }
        });
        valor_json.put("setores", new HashMap<String, Float>() {
            {
                put("Restaurante Peixinho Bom", 1f);
                put("Venda e limpeza de peixes", 2f);
                put("Quiosque", 3f);
                put("Bar Molhado", 4f);
                put("Restaurante Park", 5f);
            }
        });
    }
}
