package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class JFTelas extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFTelas frame = new JFTelas();
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
	public JFTelas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setBackground(new Color(0, 0, 0));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLimpar.setBounds(244, 204, 84, 28);
		contentPane.add(btnLimpar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(0, 0, 0));
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(119, 204, 84, 28);
		contentPane.add(btnEntrar);
		
		JLabel lblTitulologin = new JLabel("Bem vindo (a) ao sistema!");
		lblTitulologin.setFont(new Font("Californian FB", Font.BOLD, 18));
		lblTitulologin.setBounds(119, 11, 277, 28);
		contentPane.add(lblTitulologin);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setBounds(64, 79, 67, 18);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSenha.setBounds(64, 150, 55, 28);
		contentPane.add(lblSenha);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(UIManager.getColor("menu"));
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		textUsuario.setForeground(new Color(0, 0, 0));
		textUsuario.setBounds(119, 101, 209, 28);
		contentPane.add(textUsuario);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordSenha.setHorizontalAlignment(SwingConstants.CENTER);
		passwordSenha.setBackground(UIManager.getColor("menu"));
		passwordSenha.setForeground(new Color(0, 0, 0));
		passwordSenha.setBounds(119, 165, 209, 28);
		contentPane.add(passwordSenha);
		
		JLabel lblTitulo2login = new JLabel("Digite o usu\u00E1rio e senha.");
		lblTitulo2login.setFont(new Font("Californian FB", Font.BOLD, 15));
		lblTitulo2login.setBounds(135, 50, 165, 14);
		contentPane.add(lblTitulo2login);
	}
}
