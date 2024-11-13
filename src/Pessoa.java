import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private TipoCliente tipoCliente;
    protected List<String> livrosEmprestados;
    private double multaPendente;

    public Pessoa(String nome, String cpf, TipoCliente tipoCliente){
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
        this.livrosEmprestados = new ArrayList<>();
        this.multaPendente = 0.0;
    }

    public abstract int getMaxLivros();
    public abstract int getPrazoEmprestimo();


}
