package br.com.triway.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import br.com.triway.model.Livro;
import br.com.triway.util.FabricaConexao;

public class Livrodao implements Dao<Livro, Integer> {

	Logger LOG = Logger.getGlobal();
	private static final String OBTER_POR_ID_SQL = "SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM,"
			+ " PRECO, DESCRICAO FROM ESTOQUE WHERE COD_LIVRO = ?";
	private static final String CONSULTAR_SQL = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO,"
			+ " IMAGEM, DESCRICAO FROM ESTOQUE WHERE TITULO LIKE ?";

	public Livro consultar(Integer codigo) {
		Livro livro = null;
		try {
			Connection conexao = FabricaConexao.getConexao();

			PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_ID_SQL);
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
			}

			resultado.close();
		} catch (SQLException e) {
			LOG.severe(e.toString());
		}
		return livro;
	}

	
	
	public void alterar(Livro entidade) {
		// TODO Auto-generated method stub

	}

	public void salvar(Livro entidade) {
		// TODO Auto-generated method stub

	}

	public void remover(Livro entidade) {
		// TODO Auto-generated method stub

	}

	public Collection<Livro> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Livro> consultar(String titulo) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		try (Connection conexao = FabricaConexao.getConexao();
		PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL);) {
		consulta.setString(1, "%" + titulo.toUpperCase() + "%");
		ResultSet resultado = consulta.executeQuery();
		while (resultado.next()) {
		Livro livro = new Livro();
		livro.setAutor(resultado.getString("AUTOR"));
		livro.setCodigo(resultado.getInt("COD_LIVRO"));
		livro.setImagem(resultado.getString("IMAGEM"));
		livro.setPreco(resultado.getDouble("PRECO"));
		livro.setTitulo(resultado.getString("TITULO"));
		livro.setDescricao(resultado.getString("DESCRICAO"));
		lista.add(livro);
		}
		resultado.close();
		} catch (SQLException e) {
		LOG.severe(e.toString());
		}
		return lista;
		}
	
	
	
}

