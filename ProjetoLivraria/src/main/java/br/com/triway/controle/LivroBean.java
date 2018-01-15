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
@SessionScoped
public class LivroBean implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String RESULTADO = "/Resultado.xhtml";
	private static final String LIVRO = "Livro";
	private static final String SUCESSO = "Sucesso";
	private static final String IMAGEM="/imagens";
	
	private String descricao;
	private String autor;
	private Double preco;
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

	
	

	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public String getAutor() {
		return autor;
	}




	public void setAutor(String autor) {
		this.autor = autor;
	}




	public Double getPreco() {
		return preco;
	}




	public void setPreco(Double preco) {
		this.preco = preco;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public static String getImagem() {
		return IMAGEM;
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
//		
//		titulo = "tituloqualquer";
//		preco=4.5;
//		autor="antonio";
//		descricao="sasda";
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

		return "/Home.xhtml";
	}




	public Part getFile() {
		return file;
	}




	public void setFile(Part file) {
		this.file = file;
	}

}
