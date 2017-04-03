package pesque_pague;

public class Produto {

    private int codigo;
    private String nome;
    private float preco;

    public float retornaPreco() {
        float valor = codigo;
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }
}

class Peixe extends Produto {

    private int codigo;
    private String nome;
    private float preco;
    private float taxa = 3.00f;

    public float retornaPreco(float peso) {
        return (preco * peso);

    }

    public int retornaCodigo() {
        return codigo;
    }

    public float taxaLimpeza(float peso) {
        return taxa * peso;
    }

}
