package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textCPFCliente;
	private JTextField textEnderecoCliente;
	private JTextField textTelefoneCliente;
	private JTextField textIdadeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 444);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro do cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setBounds(170, 11, 157, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblNomeCliente.setBackground(new Color(245, 222, 179));
		lblNomeCliente.setBounds(46, 44, 56, 17);
		contentPane.add(lblNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeCliente.setForeground(Color.BLACK);
		textNomeCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textNomeCliente.setBackground(SystemColor.info);
		textNomeCliente.setBounds(103, 59, 307, 29);
		contentPane.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblCPFCliente = new JLabel("CPF:");
		lblCPFCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblCPFCliente.setBackground(new Color(245, 222, 179));
		lblCPFCliente.setBounds(46, 92, 46, 14);
		contentPane.add(lblCPFCliente);
		
		textCPFCliente = new JTextField();
		textCPFCliente.setForeground(Color.BLACK);
		textCPFCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textCPFCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textCPFCliente.setBackground(SystemColor.info);
		textCPFCliente.setBounds(103, 109, 307, 23);
		contentPane.add(textCPFCliente);
		textCPFCliente.setColumns(10);
		
		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o:");
		lblEnderecoCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblEnderecoCliente.setBackground(new Color(245, 222, 179));
		lblEnderecoCliente.setBounds(46, 143, 88, 23);
		contentPane.add(lblEnderecoCliente);
		
		textEnderecoCliente = new JTextField();
		textEnderecoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textEnderecoCliente.setForeground(Color.BLACK);
		textEnderecoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		textEnderecoCliente.setBackground(SystemColor.info);
		textEnderecoCliente.setBounds(103, 165, 307, 29);
		contentPane.add(textEnderecoCliente);
		textEnderecoCliente.setColumns(10);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone:");
		lblTelefoneCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefoneCliente.setBackground(new Color(245, 222, 179));
		lblTelefoneCliente.setBounds(46, 205, 88, 17);
		contentPane.add(lblTelefoneCliente);
		
		JLabel lblIdadeCliente = new JLabel("Idade:");
		lblIdadeCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdadeCliente.setBackground(new Color(245, 222, 179));
		lblIdadeCliente.setBounds(46, 264, 46, 14);
		contentPane.add(lblIdadeCliente);
		
		textTelefoneCliente = new JTextField();
		textTelefoneCliente.setBounds(103, 233, 307, 23);
		contentPane.add(textTelefoneCliente);
		textTelefoneCliente.setColumns(10);
		
		textIdadeCliente = new JTextField();
		textIdadeCliente.setBounds(103, 279, 307, 23);
		contentPane.add(textIdadeCliente);
		textIdadeCliente.setColumns(10);
		
		JButton btnBotaoCadastrar = new JButton("Cadastar");
		btnBotaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(textNomeCliente.getText());
				c.setCpf(textCPFCliente.getText());
				c.setEndereco(textEnderecoCliente.getText());
				c.setTelefone(textTelefoneCliente.getText());
				c.setIdade(Integer.parseInt(textTelefoneCliente.getText().toString()));
				
				dao.create(c);
			}
		});  
		btnBotaoCadastrar.setBackground(UIManager.getColor("Menu.background"));
		btnBotaoCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoCadastrar.setBounds(103, 325, 109, 23);
		contentPane.add(btnBotaoCadastrar);
		
		JButton btnBotaoEditar = new JButton("Editar");
		btnBotaoEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoEditar.setBackground(UIManager.getColor("MenuBar.background"));
		btnBotaoEditar.setBounds(222, 325, 89, 23);
		contentPane.add(btnBotaoEditar);
		
		JButton btnBotaoEnviar = new JButton("Enviar");
		btnBotaoEnviar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBotaoEnviar.setBackground(UIManager.getColor("MenuBar.background"));
		btnBotaoEnviar.setBounds(321, 325, 89, 23);
		contentPane.add(btnBotaoEnviar);
	}
}
