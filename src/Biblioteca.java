import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        return null;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        System.out.println("Livro com título \"" + titulo + "\" não encontrado.");
        return null;
    }

    public List<Livro> pesquisarLivro(String termoBusca) {
        List<Livro> resultados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(termoBusca) || livro.getAutor().equalsIgnoreCase(termoBusca)) {
                resultados.add(livro);
            }
        }
        return resultados;
    }

    public void realizarEmprestimo(Cliente cliente, Livro livro) {
        if (cliente.podeEmprestar()) {
            if (livro.getNumExemplares() > 1) {  // Garante que pelo menos um exemplar ficará na biblioteca
                LocalDate hoje = LocalDate.now();
                LocalDate dataDevolucao = hoje.plusDays(cliente.getPrazoEmprestimo());
                Emprestimo emprestimo = new Emprestimo(livro, hoje, dataDevolucao);
                cliente.getEmprestimos().add(emprestimo);
                livro.setNumExemplares(livro.getNumExemplares() - 1);
                System.out.println("Empréstimo realizado para " + cliente.getNome() + " com devolução em " + dataDevolucao);
            } else {
                System.out.println("Não é possível emprestar o último exemplar do livro \"" + livro.getTitulo() + "\".");
            }
        } else {
            System.out.println("Não é possível realizar o empréstimo para " + cliente.getNome() + ". Verifique o limite ou a multa.");
        }
    }

    public void devolverLivro(Cliente cliente, Livro livro) {
        Emprestimo emprestimoParaDevolver = null;
        for (Emprestimo emprestimo : cliente.getEmprestimos()) {
            if (emprestimo.getLivro() == livro) {
                emprestimoParaDevolver = emprestimo;
                break;
            }
        }
        if (emprestimoParaDevolver != null) {
            cliente.getEmprestimos().remove(emprestimoParaDevolver);
            livro.setNumExemplares(livro.getNumExemplares() + 1);
            cliente.calcularMulta();
            System.out.println("Livro devolvido para " + cliente.getNome() + ". Multa acumulada: R$" + cliente.getMultaPendente());
        } else {
            System.out.println("Livro não encontrado na lista de empréstimos de " + cliente.getNome());
        }
    }

    public void pagarMulta(Cliente cliente) {
        if (cliente.getMultaPendente() > 0) {
            System.out.println("Multa de R$" + cliente.getMultaPendente() + " paga com sucesso.");
            cliente.setMultaPendente(0);
        } else {
            System.out.println("Não há multas pendentes para " + cliente.getNome() + ".");
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
