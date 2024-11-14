public class Aluno extends Cliente{
    public Aluno(String nome, String cpf){
        super(nome, cpf, TipoCliente.ALUNO);
    }

    @Override
    public int getMaxLivros() {
        return 3;
    }

    @Override
    public int getPrazoEmprestimo() {
        return 5;
    }

    @Override
    public double getValorMulta(){
        return 2.0;
    }
}
