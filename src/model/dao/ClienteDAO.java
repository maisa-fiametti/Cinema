package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;

	public class ClienteDAO {
		public void create (Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE(nome, cpf, endereco, telefone, idade) VALUES "+"(?,?,?,?,?)");
		
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getEndereco());
			stmt.setString(4, c.getTelefone());
			stmt.setInt(5, c.getIdade());
		
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo! ");
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
		public List<Cliente> read(){
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			List<Cliente> clientes = new ArrayList<>();

			try {
				stmt = con.prepareStatement("SELECT * FROM cliente;");
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					Cliente c = new Cliente();
					c.setIdCliente(rs.getInt("idCliente"));
					c.setNome(rs.getString("nome"));
					c.setCpf(rs.getString("cpf"));
					c.setEndereco(rs.getString("endereco"));
					c.setTelefone(rs.getString("telefone"));
					c.setIdade(rs.getInt("idade"));
					clientes.add(c);
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD"+ e);
				e.printStackTrace();
			}finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			
			return clientes;
		}
		
		
		
		// ABAIXO HÁ OS MÉTODOS PARA ALTERAR O CADASTRO DE FILMES

		public Cliente read(int idCliente) {
			Connection con = ConnectionFactory.getConnection(); //conectar com o banco
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Cliente c = new Cliente();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
				stmt.setInt(1, idCliente);
				rs = stmt.executeQuery();
				if(rs != null && rs.next()) {
					c.setIdCliente(rs.getInt("idCliente"));
					c.setNome(rs.getString("nome"));
					c.setCpf(rs.getString("cpf"));
					c.setEndereco(rs.getString("endereco"));
					c.setTelefone(rs.getString("telefone"));
					c.setIdade(rs.getInt("idade"));
				}		
			} catch (SQLException e) {
				e.printStackTrace();
				
				// O FINALLY ENCERRA A CONEXÃO
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			return c;
		}
		
		//agora há o método para alterar o registro no banco de dados
		public void update(Cliente c) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("UPDATE cliente SET nome=?, cpf=?, endereco=?,"
						+ "telefone=?, idade=? WHERE idCliente=?;");
				stmt.setString(1, c.getNome());
				stmt.setString(2, c.getCpf());
				stmt.setString(3, c.getEndereco());
				stmt.setString(4, c.getTelefone());
				stmt.setInt(5, c.getIdade());
				stmt.setInt(6, c.getIdCliente());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao alterar: "+ e);
				
				//encerrando a conexão
			}finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
		}
		//agora há o método para deletar o registro no banco de dados
		public void delete(Cliente c) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente=?");
				stmt.setInt(1, c.getIdCliente());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
			} finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
		}
		
}