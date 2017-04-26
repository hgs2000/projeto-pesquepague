package pesque_pague;

public class Produto {

    private int codigo;
    private String nome;
    private float preco;

    /**
     * Retorna o preco final
     * @return preço final
     */
    public float retornaPreco() {
        return preco;
    }

    /**
     * 
     * @return codigo do produto
     */
    public int getCodigo() {
        return codigo;
    }

}

class Peixe extends Produto {

    private int codigo;
    private String nome;
    private float preco;
    private final float taxa;

    Peixe() {
        this.taxa = 3.00f;
    }

    public float retornaPreco(float peso) {
        return (preco * peso);
    }

    public int retornaCodigo() {
        return codigo;
    }
}
