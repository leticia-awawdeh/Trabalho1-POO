class Aluno extends Cliente{
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
}
