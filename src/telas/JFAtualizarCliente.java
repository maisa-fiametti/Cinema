package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textCPFCliente;
	private JTextField textEnderecoCliente;
	private JTextField textTelefoneCliente;
	private JTextField textIdadeCliente;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 444);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Altera\u00E7\u00E3o do cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setBounds(192, 11, 157, 23);
		contentPane.add(lblTitulo);
		
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		
		JLabel lblNewLabel = new JLabel("ID do Cliente:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(46, 44, 114, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("New label");
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(166, 45, 81, 19);
		contentPane.add(lblId);
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeCliente.setBackground(new Color(245, 222, 179));
		lblNomeCliente.setBounds(46, 75, 56, 17);
		contentPane.add(lblNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeCliente.setForeground(Color.BLACK);
		textNomeCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textNomeCliente.setBackground(SystemColor.info);
		textNomeCliente.setBounds(103, 90, 307, 29);
		contentPane.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblCPFCliente = new JLabel("CPF:");
		lblCPFCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblCPFCliente.setBackground(new Color(245, 222, 179));
		lblCPFCliente.setBounds(46, 122, 46, 14);
		contentPane.add(lblCPFCliente);
		
		textCPFCliente = new JTextField();
		textCPFCliente.setForeground(Color.BLACK);
		textCPFCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textCPFCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textCPFCliente.setBackground(SystemColor.info);
		textCPFCliente.setBounds(103, 145, 307, 23);
		contentPane.add(textCPFCliente);
		textCPFCliente.setColumns(10);
		
		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o:");
		lblEnderecoCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnderecoCliente.setBackground(new Color(245, 222, 179));
		lblEnderecoCliente.setBounds(46, 186, 88, 23);
		contentPane.add(lblEnderecoCliente);
		
		textEnderecoCliente = new JTextField();
		textEnderecoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textEnderecoCliente.setForeground(Color.BLACK);
		textEnderecoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textEnderecoCliente.setBackground(SystemColor.info);
		textEnderecoCliente.setBounds(103, 220, 307, 29);
		contentPane.add(textEnderecoCliente);
		textEnderecoCliente.setColumns(10);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefoneCliente.setBackground(new Color(245, 222, 179));
		lblTelefoneCliente.setBounds(46, 260, 88, 17);
		contentPane.add(lblTelefoneCliente);
		
		JLabel lblIdadeCliente = new JLabel("Idade:");
		lblIdadeCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdadeCliente.setBackground(new Color(245, 222, 179));
		lblIdadeCliente.setBounds(46, 314, 46, 14);
		contentPane.add(lblIdadeCliente);
		
		textTelefoneCliente = new JTextField();
		textTelefoneCliente.setBounds(103, 288, 307, 23);
		contentPane.add(textTelefoneCliente);
		textTelefoneCliente.setColumns(10);
		
		textIdadeCliente = new JTextField();
		textIdadeCliente.setBounds(103, 337, 307, 23);
		contentPane.add(textIdadeCliente);
		textIdadeCliente.setColumns(10);
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		textNomeCliente.setText(c.getNome());
		textCPFCliente.setText(c.getCpf());
		textEnderecoCliente.setText(c.getEndereco());
		textTelefoneCliente.setText(c.getTelefone());
		textIdadeCliente.setText(Integer.toString(c.getIdade()));
		
		
		JButton btnBotaoAlterarCliente = new JButton("Alterar");
		btnBotaoAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(textNomeCliente.getText());
				c.setCpf(textCPFCliente.getText());
				c.setEndereco(textEnderecoCliente.getText());
				c.setTelefone(textTelefoneCliente.getText());
				c.setTelefone(textTelefoneCliente.getText());
				c.setIdade(Integer.parseInt(textIdadeCliente.getText().toString()));
				
				dao.update(c);
			}
		});
				
		btnBotaoAlterarCliente.setBackground(UIManager.getColor("Menu.background"));
		btnBotaoAlterarCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoAlterarCliente.setBounds(103, 371, 109, 23);
		contentPane.add(btnBotaoAlterarCliente);
		
		JButton btnBotaoEditar = new JButton("Editar");
		btnBotaoEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoEditar.setBackground(UIManager.getColor("MenuBar.background"));
		btnBotaoEditar.setBounds(237, 371, 89, 23);
		contentPane.add(btnBotaoEditar);
		
		JButton btnBotaoEnviar = new JButton("Enviar");
		btnBotaoEnviar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoEnviar.setBackground(UIManager.getColor("MenuBar.background"));
		btnBotaoEnviar.setBounds(336, 371, 89, 23);
		contentPane.add(btnBotaoEnviar);
		
	}
}


