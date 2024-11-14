import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 10) {
            System.out.println("\n--- Sistema de Gestão de Biblioteca ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Consultar Multas");
            System.out.println("6. Pagar Multa");
            System.out.println("7. Listar Livros");
            System.out.println("8. Listar Clientes");
            System.out.println("9. Pesquisar Livro por Título ou Autor");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarLivro(biblioteca, scanner);
                    break;
                case 2:
                    cadastrarCliente(biblioteca, scanner);
                    break;
                case 3:
                    realizarEmprestimo(biblioteca, scanner);
                    break;
                case 4:
                    realizarDevolucao(biblioteca, scanner);
                    break;
                case 5:
                    consultarMultas(biblioteca, scanner);
                    break;
                case 6:
                    pagarMulta(biblioteca, scanner);
                    break;
                case 7:
                    listarLivros(biblioteca);
                    break;
                case 8:
                    listarClientes(biblioteca);
                    break;
                case 9:
                    pesquisarLivro(biblioteca, scanner);
                    break;
                case 10:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void cadastrarLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Gênero (ROMANCE, FICCAO, BIOGRAFIA, TECNICO): ");
        Generos genero = Generos.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        System.out.print("Número de Exemplares Disponíveis: ");
        int exemplares = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Livro livro = new Livro(titulo, autor, genero, ano, exemplares);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    private static void cadastrarCliente(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Tipo de Cliente (ALUNO ou PROFESSOR): ");
        TipoCliente tipo = TipoCliente.valueOf(scanner.nextLine().toUpperCase());

        Cliente cliente;
        if (tipo == TipoCliente.ALUNO) {
            cliente = new Aluno(nome, cpf);
        } else {
            cliente = new Professor(nome, cpf);
        }

        biblioteca.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void realizarEmprestimo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Título do Livro para Empréstimo: ");
        String titulo = scanner.nextLine();

        Cliente cliente = biblioteca.buscarClientePorCpf(cpf);
        Livro livro = biblioteca.buscarLivroPorTitulo(titulo);

        if (cliente != null && livro != null) {
            biblioteca.realizarEmprestimo(cliente, livro);
        } else {
            System.out.println("Cliente ou livro não encontrado.");
        }
    }

    private static void realizarDevolucao(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Título do Livro para Devolução: ");
        String titulo = scanner.nextLine();

        Cliente cliente = biblioteca.buscarClientePorCpf(cpf);
        Livro livro = biblioteca.buscarLivroPorTitulo(titulo);

        if (cliente != null && livro != null) {
            biblioteca.devolverLivro(cliente, livro);
        } else {
            System.out.println("Cliente ou livro não encontrado.");
        }
    }

    private static void consultarMultas(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = biblioteca.buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.println("Multa pendente: R$" + cliente.getMultaPendente());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void pagarMulta(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = biblioteca.buscarClientePorCpf(cpf);
        if (cliente != null) {
            biblioteca.pagarMulta(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void listarLivros(Biblioteca biblioteca) {
        List<Livro> livros = biblioteca.getLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Lista de Livros:");
            for (Livro livro : livros) {
                System.out.println("- " + livro.getTitulo() + " por " + livro.getAutor() + " (Exemplares disponíveis: " + livro.getNumExemplares() + ")");
            }
        }
    }

    private static void listarClientes(Biblioteca biblioteca) {
        List<Cliente> clientes = biblioteca.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("- " + cliente.getNome() + " (" + cliente.getTipoCliente() + ") - Multa pendente: R$" + cliente.getMultaPendente());
            }
        }
    }

    private static void pesquisarLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título ou autor para busca: ");
        String busca = scanner.nextLine();
        List<Livro> resultados = biblioteca.pesquisarLivro(busca);

        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado para a busca: " + busca);
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : resultados) {
                System.out.println("- " + livro.getTitulo() + " por " + livro.getAutor());
            }
        }
    }
}
