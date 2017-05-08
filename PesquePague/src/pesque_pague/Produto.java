package pesque_pague;

public class Produto {

    private final String NOME;
    private final float PRECO;

    public float getPRECO() {
        return PRECO;
    }

    public String getNOME() {
        return NOME;
    }

    public Produto(String nome, float preco) {
        this.NOME = nome;
        this.PRECO = preco;
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
