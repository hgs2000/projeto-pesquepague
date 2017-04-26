package pesque_pague;

public class Servicos {

    final int tipoServico;
    private float taxaServico = 0.00f;

    public float retornaServico() {
        return taxaServico;
    }

    public Servicos() {
        tipoServico = 1;
    }
}
