package br.com.triway.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.triway.model.Livro;
import br.com.triway.service.CatalogoService;

@ManagedBean(name = "livroBean")
@SessionScoped
public class LivroBean  implements Serializable{

	private static final String RESULTADO = "Resultado";
	private static final String LIVRO = "Livro";

	
	private String titulo;
	private Livro livro;
	private List<Livro> livros;
	
	
	
	
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@PostConstruct
	public void init(){
		CatalogoService service = new CatalogoService();
		System.out.println("LivroBean.init()");
	}
	
	public String pesquisar() {
		CatalogoService service = null;
		livros = service.consultar(titulo);
		return  RESULTADO;

	}
	
	public String verlivro(int codigo) {
		CatalogoService service = null;
		livro = service.verLivro(codigo);
		return LIVRO;
	}
}
