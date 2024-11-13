package teste;

public class Livro {
	String Titulo;
	String Autor;
	Generos genero;
	int AnoPubli;
	int getAnoPublicacao;
	int NumExemplares;
	
	public enum Generos {
	        ROMANCE,
	        FICCAO,
	        BIOGRAFIA,
	        CONTO,
	        AUTOBIOGRAFIA
	    }

	
	public Livro(String Titulo,String Autor,Generos genero,int AnoPubli ,int NumExemplares) {
		this.Titulo = Titulo;
        this.Autor = Autor;
        this.genero = genero;
        this.AnoPubli = AnoPubli;
        this.NumExemplares = NumExemplares;
		
	}
	 public String getTitulo() {
	        return Titulo;
	    }

	    public String getAutor() {
	        return Autor;
	    }

	    public Generos getGenero() {
	        return genero;
	    }

	    public int getAnoPubli() {
	        return AnoPubli;
	    }

	    public int getNumExemplares() {
	        return NumExemplares;
	    }
	}
	

	



