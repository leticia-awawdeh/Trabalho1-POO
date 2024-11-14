import java.util.HashMap;
import java.util.Map;

public class Catalogo {
    private Map<String, Livro> livros;

    public Catalogo(){
        livros = new HashMap<>();
    }

    public void adicionarLivro(Livro livro){
        livros.put(livro.getTitulo(), livro);
    }

    public Livro buscarLivro(String titulo){
        return livros.get(titulo);
    }

    public boolean emprestarLivro(String titulo){
        Livro livro = buscarLivro(titulo);
        if (livro != null){
            return livro.emprestar();
        } else {
            System.out.println("Livro não encontrado no catálgo: " + titulo);
            return false;
        }

    }
    public void devolverLivro(String titulo){
        Livro livro = buscarLivro(titulo);
        if(livro != null){
            livro.devolver();
        }
    }
}
