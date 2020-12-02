package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.SystemColor;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable JtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listar Clientes");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setBounds(149, 23, 133, 22);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 59, 466, 220);
		contentPane.add(scrollPane);
		
		JtCliente = new JTable();
		JtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"idCliente", "Nome", "CPF", "Endereco", "Telefone", "Idade"
			}
		));
		JtCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(JtCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrarCliente.setBackground(SystemColor.menu);
		btnCadastrarCliente.setBounds(33, 306, 158, 33);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAlterarCliente.setBackground(SystemColor.menu);
		btnAlterarCliente.setBounds(197, 306, 133, 33);
		contentPane.add(btnAlterarCliente);
		
		JButton btnNewButton = new JButton("Excluir Cliente");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(360, 306, 133, 33);
		contentPane.add(btnNewButton);
		
		readJTable();
		
	} 
	//metodo para ler uma tabela
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getCpf(),
					c.getEndereco(),
					c.getTelefone(),
					c.getIdade()
					
			});
		}
	}
}
