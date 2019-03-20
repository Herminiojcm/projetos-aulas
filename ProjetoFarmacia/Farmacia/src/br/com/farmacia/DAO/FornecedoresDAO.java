package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {
	// M�todo ou Fun��o salvar
	public void salvar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	// M�todo ou Fun��o excluir
	public void excluir(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE  codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	// M�todo ou Fun��o editar
	public void editar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET  descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}

	// M�todo ou Fun��o busca por c�digo
	public Fornecedores buscaPorCodigo(Fornecedores f)throws SQLException{
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT codigo, descricao ");
	sql.append("FROM fornecedores ");
	sql.append("WHERE codigo = ? ");
	
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
	
	comando.setLong(1, f.getCodigo());
	
	ResultSet resultado = comando.executeQuery();
	Fornecedores retorno = null;
	
	if(resultado.next()){
		retorno = new Fornecedores();
		retorno.setCodigo(resultado.getLong("codigo"));
		retorno.setDescricao(resultado.getString("descricao"));
	}
	
	return retorno;
}

	// M�todo ou Fun��o busca pela descri��o
public ArrayList<Fornecedores>buscarPorDescricao(Fornecedores f)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + f.getDescricao() + "%");
		
		
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
		
		while(resultado.next()){
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			
			lista.add(item);
		}

		return lista;
	}

	// M�todo ou Fun��o -----------
public ArrayList<Fornecedores> listar()throws SQLException{
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT codigo, descricao ");
	sql.append("FROM fornecedores ");
	sql.append("ORDER BY descricao ASC ");
	
	Connection conexao = ConexaoFactory.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
			
	ResultSet resultado = comando.executeQuery();
	 
	ArrayList<Fornecedores>lista = new ArrayList<Fornecedores>();
	
	while(resultado.next()){
		Fornecedores f = new Fornecedores();
		f.setCodigo(resultado.getLong("codigo"));
		f.setDescricao(resultado.getString("descricao"));
		
		lista.add(f);
	}

	return lista;
}
	// M�todo Main

	public static void main(String[] args) {

		// Teste de Inser��o
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setDescricao("Descri��o 08"
		 * );
		 * 
		 * Fornecedores f2 = new Fornecedores(); f2.setDescricao("Descri��o 09"
		 * );
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.salvar(f1); fdao.salvar(f2); System.out.println(
		 * "Salvo com sucesso !!");
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao salvar");
		 * e.printStackTrace();}
		 */

		// Teste de Exclus�o
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(2L);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.excluir(f1); System.out.println("Deletado com sucesso !!"
		 * );
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao deletar");
		 * e.printStackTrace(); }
		 */

		// Teste de Edi��o
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(3);
		 * f1.setDescricao("Herminio");
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.editar(f1); System.out.println("Editado com sucesso !!");
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao editar");
		 * e.printStackTrace();
		 * 
		 * }
		 */

		// Teste de busca c�digo
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(3);
		 * 
		 * Fornecedores f2 = new Fornecedores(); f2.setCodigo(2);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { Fornecedores f3 = fdao.buscaPorCodigo(f1); Fornecedores f4 =
		 * fdao.buscaPorCodigo(f2);
		 * 
		 * System.out.println("Resultado 1: " + f3); System.out.println(
		 * "Resultado 2: " + f4);
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao buscar");
		 * e.printStackTrace(); }
		 */

		// Teste de Listar busca
		/*
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { ArrayList<Fornecedores>lista = fdao.listar();
		 * 
		 * for (Fornecedores f : lista) { System.out.println("Resultado " + f);
		 * } } catch (SQLException e) { System.out.println("Erro ao buscar");
		 * e.printStackTrace(); }
		 * 
		 * //Teste listar descri��o
		 * 
		 * Fornecedores f1 = new Fornecedores(); f1.setDescricao("H");
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { ArrayList<Fornecedores>lista = fdao.buscaPorDescricao(f1);
		 * 
		 * for (Fornecedores f : lista) { System.out.println("Resultado " + f);
		 * } } catch (SQLException e) { System.out.println("Erro ao buscar");
		 * e.printStackTrace(); }
		 */

	}
}
