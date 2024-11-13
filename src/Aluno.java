class Aluno extends Cliente{
    public Aluno(String nome, String cpf){
        super(nome, cpf, TipoCliente.ALUNO);
    }

    @Override
    public int getMaxLivros() {
        return 0;
    }

    @Override
    public int getPrazoEmprestimo() {
        return 0;
    }
}
