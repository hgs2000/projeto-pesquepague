package pesque_pague;

public class Produto {

    //Quantidade do produtos registrados na comanda
    private int quantidade_produtos;

    //Nome do produto
    private final String NOME;
    //Preço do produto
    private final float PRECO;

    /**
     * Método para adquirir o preço do produto.
     *
     * @return preço do produto
     */
    public float getPRECO() {
        return PRECO;
    }

    /**
     * Método para adquirir o nome do produto.
     *
     * @return nome do produto
     */
    public String getNOME() {
        return NOME;
    }

    /**
     * Método para adquirir a quantidade de produtos
     *
     * @return quantidade de produtos
     */
    public int getQuantidade_produtos() {
        return quantidade_produtos;
    }

    /**
     * Método para modificar a quantidade de produtos na comanda
     *
     * @param quantidade_produtos
     */
    public void setQuantidade_produtos(int quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }

    public Produto(String nome, float preco) {
        this.NOME = "" + nome;
        this.PRECO = 0.00f + preco;
    }

}

class Peixe extends Produto {

    public Peixe(String nome, float preco) {
        super(nome, preco);
    }

}

class Servico extends Produto {

    public Servico(String nome, float preco) {
        super(nome, preco);
    }

}
