class Professor extends Cliente{
    public Professor(String nome, String cpf){
        super(nome, cpf, TipoCliente.PROFESSOR);
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
