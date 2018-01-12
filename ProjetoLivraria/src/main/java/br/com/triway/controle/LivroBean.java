package br.com.triway.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.triway.model.Livro;
import br.com.triway.service.CatalogoService;
import javax.servlet.http.Part;

@ManagedBean(name="livroBean")
@ViewScoped
public class LivroBean implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String RESULTADO = "Resultado";
	private static final String LIVRO = "Livro";
	private static final String SUCESSO = "Sucesso";
	private static final String autor="autor";
	private static final Double preco=null;
	private static final String IMAGEM="/imagens";
	private static final String descricao="Descricao";
	private String titulo;
	private Livro livro;
	private List<Livro> livros;

	
	private Part file;
	public void upload(){
	 }

	
	
	
	public static String getResultado() {
		return RESULTADO;
	}

	public static String getSucesso() {
		return SUCESSO;
	}

	public static String getAutor() {
		return autor;
	}

	public static Double getPreco() {
		return preco;
	}

	public static String getImagem() {
		return IMAGEM;
	}

	public static String getDescricao() {
		return descricao;
	}

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
	public void init() {
		CatalogoService service = new CatalogoService();
		System.out.println("LivroBean.init()");
	}

	public String pesquisar() {
		CatalogoService service = new CatalogoService();
		livros = service.consultar(titulo);
		return RESULTADO;

	}

	public String verlivro(int codigo) {
		CatalogoService service = new CatalogoService();
		livro = service.verLivro(codigo);
		return LIVRO;
	}

	public String cadastrar() {
		CatalogoService service = new CatalogoService();
		Livro livro = new Livro();
		livro.setTitulo(titulo.toUpperCase());
		livro.setAutor(autor.toUpperCase());
		livro.setPreco(preco);
		livro.setImagem("imagens/");
		livro.setDescricao(descricao);
		System.out.println("LivroBean.cadastrar()");
		service.cadastroLivro(livro);
		return SUCESSO;
	}




	public Part getFile() {
		return file;
	}




	public void setFile(Part file) {
		this.file = file;
	}

}
