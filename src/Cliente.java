import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nome;
    private String cpf;
    private TipoCliente tipoCliente;
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private double multaPendente;

    public Cliente(String nome, String cpf, TipoCliente tipoCliente){
        this.nome = nome;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
        //this.livrosEmprestados = new ArrayList<>();
        this.multaPendente = 0.0;
    }

    public abstract int getMaxLivros();
    public abstract double getValorMulta();
    public abstract int getPrazoEmprestimo();

    public void calcularMulta(){
        LocalDate hoje = LocalDate.now();
        for(Emprestimo emprestimo : emprestimos){
            if(hoje.isAfter(emprestimo.getDataDevolucao())){
                long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), hoje);
                multaPendente += diasAtraso * getValorMulta();
            }
        }
    }
    public boolean podeEmprestar(){
        calcularMulta();
        return multaPendente == 0 && emprestimos.size() < getMaxLivros();
    }

    public void adicionarMulta(double valor){
        this.multaPendente += valor;
    }

    public void pagarMulta(double valor){
        this.multaPendente -= valor;
        if (this.multaPendente < 0){
            this.multaPendente = 0;
        }
    }


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

   /* public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }*/

    /*public List<String> getLivrosEmprestados() {
        return livrosEmprestados;
    }*/

    /*public void setLivrosEmprestados(List<String> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }*/
    public  List<Emprestimo> getEmprestimos(){
        return emprestimos;
    }

    public double getMultaPendente() {
        return multaPendente;
    }

    public void setMultaPendente(double multaPendente) {
        this.multaPendente = multaPendente;
    }

}
