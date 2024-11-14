
public class Livro {
	String titulo;
	String autor;
	Generos genero;
	int anoPubli;
	int numExemplares;

	//enum criado separado
	public Livro(String titulo,String autor,Generos genero,int anoPubli ,int numExemplares) {
		this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPubli = anoPubli;
        this.numExemplares =numExemplares;
		
	}

	public boolean emprestar(int quantidadeEmprestada) {
        if (this.numExemplares >= quantidadeEmprestada) {
            this.SetNumExemplares(this.getNumExemplares() - quantidadeEmprestada);
            return true;
        } else {
            System.out.println("Não há exemplares disponíveis para o livro: " + titulo);
            return false;
        }
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
	    public void setAutor(String autor)
	    {
	    	  this.autor=autor;
	    }
	    public Generos getGenero() {
	        return genero;
	    }
	    public void setGenero(Generos genero)
	    {
	    	  this.genero=genero;
	    }
	    public int getAnoPubli() {
	        return anoPubli;
	    }
	    public void SetAnoPubli(int anoPubli) {
	    	this.anoPubli=anoPubli;
	    }
	    public int getNumExemplares() {
	        return numExemplares;
	    }
	    public void SetNumExemplares(int numExemplares){
	    	this.numExemplares=numExemplares;
	    }
	}
