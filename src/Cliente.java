import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nome;
    private String cpf;
    private TipoCliente tipoCliente;
    protected List<String> livrosEmprestados;
    private double multaPendente;

    public Cliente(String nome, String cpf, TipoCliente tipoCliente){
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
        this.livrosEmprestados = new ArrayList<>();
        this.multaPendente = 0.0;
    }

    public abstract int getMaxLivros();
    public abstract int getPrazoEmprestimo();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<String> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<String> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public double getMultaPendente() {
        return multaPendente;
    }

    public void setMultaPendente(double multaPendente) {
        this.multaPendente = multaPendente;
    }


}
