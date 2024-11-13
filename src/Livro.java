
public class Livro {
	private String titulo;
	String autor;
	Generos genero;
	int anoPublicacao;
	private int numExemplares;

	// TODO: colocar na classe ENUM
	public enum Generos {
	        ROMANCE,
	        FICCAO,
	        BIOGRAFIA,
	        CONTO,
	        AUTOBIOGRAFIA
	}

	
	public Livro(String Titulo,String Autor,Generos genero,int AnoPubli ,int NumExemplares) {
		this.titulo = Titulo;
        this.autor = Autor;
        this.genero = genero;
        this.anoPublicacao = AnoPubli;
        this.numExemplares = NumExemplares;
		
	}

	public boolean emprestar(int quantidaeEmprestada){
		if(this.numExemplares > 0){
			this.setNumExemplares(this.getNumExemplares() - quantidaeEmprestada);
			return true;
		} else {
			System.out.println("Não há exemplares disponíveis para o livro: " + titulo);
			return false;
		}
	}

	//TODO: Colocar os Seters
	 public String getTitulo() {
	        return titulo;
	    }

	    public String getAutor() {
	        return autor;
	    }

	    public Generos getGenero() {
	        return genero;
	    }

	    public int getAnoPublicacao() {
	        return anoPublicacao;
	    }

		public void setNumExemplares(int exemplaresDisponiveis){
			this.numExemplares = exemplaresDisponiveis;
		}
	    public int getNumExemplares() {
	        return numExemplares;
	    }
	}
	

	



