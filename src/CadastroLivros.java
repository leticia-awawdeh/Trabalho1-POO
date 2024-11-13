package teste;

import java.util.ArrayList;

public class CadastroLivros {
    private ArrayList<Livro> livros;

    public CadastroLivros() {
        livros = new ArrayList<>();
    } 

    public void adicionarLivro(Livro Livro) {
        livros.add(Livro);
        System.out.println("Livro adicionado com sucesso!");
    }
 
    public boolean removerLivro(String Titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(Titulo)) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso!");
                return true; 
            }
        }
        System.out.println("Livro não encontrado.");
        return false; 
    }

   
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}