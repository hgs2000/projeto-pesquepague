package pesque_pague;

public class Produto {

    private int codigo;
    private String nome;
    private float preco;

    public float retornaPreco() {
        float valor = codigo;
        return valor;
    }
}

class Peixe extends Produto {

    private int codigo;
    private String nome;
    private float preco;
    private float taxaLimpeza;

    public float retornaPreco(float peso) {
        float valor = codigo;
        return valor;
    }

    public int retornaCodigo() {
        return codigo;
    }
    
    puclic float taxaLimpeza(){
        return taxa;    
    }

}
