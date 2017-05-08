package pesque_pague;

import java.util.HashMap;
import java.util.Map;

public class CriadorDeJSON {

    private static final Map<String, Map<String, Produto>> VALOR_JSON = new HashMap<>();

    public Map<String, Produto> getOpcoes(String tipo) throws Exception {
        if (VALOR_JSON.containsKey(tipo)) {
            return VALOR_JSON.get(tipo);
        } else {
            throw new Exception("Erro. Opção indisponível.");
        }
    }

    /**
     * Criado por Isabelle Kuehlewein
     *
     */
    public CriadorDeJSON() {
        VALOR_JSON.put("comidas", new HashMap<String, Produto>() {
            {
                put("Porção de Peixe Frito (500g)", new Produto("Porção de Peixe Frito (500g)", 20.00f));
                put("Meia Porção de Peixe Frito (250g)", new Produto("Meia Porção de Peixe Frito (250g)", 10.00f));
                put("Porção de Batata Frita (500g)", new Produto("Porção de Batata Frita (500g)", 17.00f));
                put("Meia Porção de Batata Frita", new Produto("Meia Porção de Batata Frita", 8.50f));
                put("Porção de Polenta (500g)", new Produto("Porção de Polenta (500g)", 15.00f));
                put("Meia Porção de Polenta (250g)", new Produto("Meia Porção de Polenta (250g)", 7.50f));
                put("X-Salada", new Produto("X-Salada", 10.00f));
                put("X-Frango", new Produto("X-Frango", 12.00f));
                put("X-Burger", new Produto("X-Burger", 7.20f));
                put("X-Bacon", new Produto("X-Bacon", 12.00f));
                put("X-Egg", new Produto("X-Egg", 9.00f));
                put("X-Tudo", new Produto("X-Tudo", 15.00f));
                put("Pastel de Frango", new Produto("Pastel de Frango", 4.50f));
                put("Pastel de Tilápia", new Produto("Pastel de Tilápia", 6.00f));
                put("Pastel de Carne", new Produto("Pastel de Carne", 4.50f));
                put("Pastel de Queijo", new Produto("Pastel de Queijo", 4.00f));
                put("Pastel de Palmito", new Produto("Pastel de Palmito", 4.00f));
                put("Pastel de Pizza", new Produto("Pastel de Pizza", 4.50f));
                put("Pastel de Brigadeiro", new Produto("Pastel de Brigadeiro", 4.00f));
                put("Picolé de Fruta", new Produto("Picolé de Fruta", 2.00f));
                put("Picolé com Recheio", new Produto("Picolé com Recheio", 4.00f));
                put("Paleta Mexicana Recheada", new Produto("Paleta Mexicana Recheada", 10.00f));
                put("Paleta Mexicana sem Recheio", new Produto("Paleta Mexicana sem Recheio", 6.00f));
            }
        });
        VALOR_JSON.put("bebidas", new HashMap<String, Produto>() {
            {
                put("Cerveja Skol", new Produto("Cerveja Skol", 6.50f));
                put("Cerveja Brahma", new Produto("Cerveja Brahma", 6.50f));
                put("Cerveja Antárctica", new Produto("Cerveja Antárctica", 6.00f));
                put("Cerveja Sub Zero", new Produto("Cerveja Sub Zero", 5.50f));
                put("Cerveja Antárctica Original", new Produto("Cerveja Antárctica Original", 7.50f));
                put("Refrigerante Pequeno (200ml)", new Produto("Refrigerante Pequeno (200ml)", 2.50f));
                put("Refrigerante Lata", new Produto("Refrigerante Lata", 3.80f));
                put("Refrigerante 500ml", new Produto("Refrigerante 500ml ", 4.50f));
                put("Refrigerante 2l", new Produto("Refrigerante 2l", 9.00f));
                put("H2OH!", new Produto("H2OH!", 4.50f));
                put("Água sem gás", new Produto("Água sem gás", 1.50f));
                put("Água com gás", new Produto("Água com gás", 2.50f));
                put("Taça Pequena de Vinho (200 ml)", new Produto("Taça Pequena de Vinho (200 ml)", 3.50f));
                put("Taça Grande de Vinho (400 ml)", new Produto("Taça Grande de Vinho (400 ml)", 5.00f));
                put("Garrafa de Vinho (1.5 l)", new Produto("Garrafa de Vinho (1.5 l)", 18.00f));
                put("Energético Red Bull", new Produto("Energético Red Bull", 10.00f));
                put("Energético Red Hot", new Produto("Energético Red Hot", 6.00f));
                put("Campari (100ml)", new Produto("Campari (100ml)", 5.00f));
                put("Run Bacardi (100ml)", new Produto("Run Bacardi (100ml)", 5.00f));
                put("Vodka (100ml)", new Produto("Vodka (100ml)", 5.00f));
                put("Caipirinha (400ml)", new Produto("Caipirinha (400ml)", 5.50f));
                put("Caipirissima (400ml)", new Produto("Caipirissima (400ml)", 8.00f));
                put("Tequila Souza (200ml)", new Produto("Tequila Souza (200ml)", 12.00f));
            }
        });
        VALOR_JSON.put("servicos", new HashMap<String, Produto>() {
            {
                put("Pedalinho (15min)", new Servico("Pedalinho (15min)", 4.00f));
                put("Pedalinho (1h)", new Servico("Pedalinho (1h)", 7.00f));
                put("Parque Aquático", new Servico("Parque Aquático", 20.00f));
                put("Camping", new Servico("Camping", 25.00f));
            }
        });
        VALOR_JSON.put("peixes", new HashMap<String, Produto>() {
            {
                put("Tilápia", new Peixe("Tilápia", 12.00f));
                put("Traíra", new Peixe("Traíra", 13.00f));
                put("Pacu", new Peixe("Pacu", 13.00f));
                put("Carpa", new Peixe("Carpa", 12.00f));
                put("Pintado", new Peixe("Pintado", 30.00f));
                put("Cascudo", new Peixe("Cascudo", 13.00f));
            }
        });
        VALOR_JSON.put("setores", new HashMap<String, Produto>() {
            {
                put("Restaurante Peixinho Bom", new Servico("Restaurante Peixinho Bom", 1f));
                put("Venda e limpeza de peixes", new Servico("Venda e limpeza de peixes", 2f));
                put("Quiosque", new Servico("Quiosque", 3f));
                put("Bar Molhado", new Servico("Bar Molhado", 4f));
                put("Restaurante Park", new Servico("Restaurante Park", 5f));
            }
        });
    }
}
