import java.time.LocalDate;

public class Livro {
	private String titulo;
	String autor;
	Generos genero;
	int anoPublicacao;
	private int numExemplares;

	//enum criado separado
	public Livro(String titulo,String autor,Generos genero,int anoPubli ,int numExemplares) {
		this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPubli;
        this.numExemplares = numExemplares;
		
	}

	public boolean emprestar() {
		if (this.numExemplares > 0) {
			this.numExemplares--;
			return true;
		} else {
			System.out.println("Não há exemplares disponíveis para o livro: " + titulo);
			return false;
		}
	}

	public void devolver() {
		this.numExemplares++;
	}

	//set and get area
	 public String getTitulo() {
	        return titulo;
	    }
	 public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getAutor() {
	        return autor;
	    }
	    public void setAutor(String autor) {
	    	  this.autor=autor;
	    }

	    public Generos getGenero() {
	        return genero;
	    }
	    public void setGenero(Generos genero) {
	    	  this.genero=genero;
	    }

	    public int getAnoPubli() {
	        return anoPublicacao;
	    }
	    public void SetAnoPubli(int anoPublicacao) {
	    	this.anoPublicacao=anoPublicacao;
	    }
	    
	    public int getNumExemplares() {
	        return numExemplares;
	    }
	    public void setNumExemplares(int exemplaresDisponiveis){
	    	this.numExemplares=exemplaresDisponiveis;
	    }
	}
