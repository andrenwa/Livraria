package br.com.triway.service;

import java.util.List;

import br.com.triway.dao.Livrodao;
import br.com.triway.model.Livro;

public class CatalogoService {

	public List<Livro> consultar(String titulo) {

		if (titulo == null) {
			titulo = "";
		}
		System.out.println("Pesquisa: " + titulo);

		Livrodao dao = new Livrodao();

		List<Livro> livros = dao.consultar(titulo);

		if (livros.size() <= 0) {
			System.out.println("Livro não localizado");
		}
		return livros;
	}

	public Livro verLivro(Integer codigo) {
		Livrodao dao = new Livrodao();
		
		Livro livro = dao.consultar(codigo);
		return livro;
	}

}
