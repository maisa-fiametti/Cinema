package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

	public class ClienteDAO {
		public void create (Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE(nome, cpf, endereco, telefone, idade) "+"(?,?,?,?,?)");
		
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
}