package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class JFCadatrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField textTituloFilme;
	private JTextField textCategoriaFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadatrarFilme frame = new JFCadatrarFilme();
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
	public JFCadatrarFilme() {
		setBackground(new Color(245, 222, 179));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 446);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro do filme");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBounds(172, 11, 165, 20);
		contentPane.add(lblTitulo);
		
		textTituloFilme = new JTextField();
		textTituloFilme.setForeground(Color.BLACK);
		textTituloFilme.setBackground(SystemColor.info);
		textTituloFilme.setHorizontalAlignment(SwingConstants.CENTER);
		textTituloFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		textTituloFilme.setBounds(91, 52, 336, 31);
		contentPane.add(textTituloFilme);
		textTituloFilme.setColumns(10);
		
		JLabel lblTituloFilme = new JLabel("T\u00EDtulo:");
		lblTituloFilme.setBackground(new Color(245, 222, 179));
		lblTituloFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloFilme.setBounds(36, 33, 75, 20);
		contentPane.add(lblTituloFilme);
		
		JLabel TextSinopseFilme = new JLabel("Sinopse:");
		TextSinopseFilme.setFont(new Font("Arial", Font.BOLD, 14));
		TextSinopseFilme.setBounds(36, 82, 90, 20);
		contentPane.add(TextSinopseFilme);
		
		JLabel lblCategoriaFilme = new JLabel("Categoria:");
		lblCategoriaFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoriaFilme.setBounds(36, 186, 75, 14);
		contentPane.add(lblCategoriaFilme);
		
		JLabel lblTempoFilme = new JLabel("Tempo:");
		lblTempoFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblTempoFilme.setBounds(36, 253, 75, 14);
		contentPane.add(lblTempoFilme);
		
		textCategoriaFilme = new JTextField();
		textCategoriaFilme.setBackground(SystemColor.info);
		textCategoriaFilme.setHorizontalAlignment(SwingConstants.CENTER);
		textCategoriaFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		textCategoriaFilme.setBounds(91, 211, 336, 31);
		contentPane.add(textCategoriaFilme);
		textCategoriaFilme.setColumns(10);
		
		JSpinner spinnerTempoFilme = new JSpinner();
		spinnerTempoFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		spinnerTempoFilme.setBackground(Color.WHITE);
		spinnerTempoFilme.setBounds(92, 251, 65, 20);
		contentPane.add(spinnerTempoFilme);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Arial", Font.BOLD, 14));
		lblImagem.setBounds(208, 250, 75, 20);
		contentPane.add(lblImagem);
		
		JRadioButton rdbtnImagem2D = new JRadioButton("2D");
		rdbtnImagem2D.setBackground(new Color(245, 222, 179));
		rdbtnImagem2D.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnImagem2D.setBounds(274, 251, 51, 18);
		contentPane.add(rdbtnImagem2D);
		
		JRadioButton rdbtnImagem3D = new JRadioButton("3D");
		rdbtnImagem3D.setBackground(new Color(245, 222, 179));
		rdbtnImagem3D.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnImagem3D.setBounds(327, 247, 51, 27);
		contentPane.add(rdbtnImagem3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtnImagem2D);
		imagem.add(rdbtnImagem3D);
		
		JLabel lblAudio = new JLabel("\u00C1udio:");
		lblAudio.setFont(new Font("Arial", Font.BOLD, 14));
		lblAudio.setBounds(36, 294, 57, 14);
		contentPane.add(lblAudio);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBackground(new Color(245, 222, 179));
		rdbtnDublado.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnDublado.setBounds(93, 291, 79, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBackground(new Color(245, 222, 179));
		rdbtnLegendado.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnLegendado.setBounds(174, 290, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		imagem.add(rdbtnDublado);
		imagem.add(rdbtnLegendado);
		
		JButton btnCadastrarFilme = new JButton("Cadastrar");
		btnCadastrarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(textTituloFilme.getText());
				f.setSinopse(TextSinopseFilme.getText());
				f.setCategoria(textCategoriaFilme.getText());
				f.setTempo(Integer.parseInt(spinnerTempoFilme.getValue().toString()));
				if(rdbtnImagem2D.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtnImagem3D.isSelected()) {
					f.setImagem3d(true);
				}
				if(rdbtnDublado.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
			}
		});
		btnCadastrarFilme.setBackground(UIManager.getColor("MenuBar.background"));
		btnCadastrarFilme.setForeground(new Color(0, 0, 0));
		btnCadastrarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarFilme.setBounds(98, 330, 100, 23);
		contentPane.add(btnCadastrarFilme);
		
		JButton btnLimparCadastroFilme = new JButton("Limpar");
		btnLimparCadastroFilme.setBackground(UIManager.getColor("Menu.background"));
		btnLimparCadastroFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLimparCadastroFilme.setBounds(222, 330, 89, 23);
		contentPane.add(btnLimparCadastroFilme);
		
		JButton btnEnviarCadastroFilme = new JButton("Enviar");
		btnEnviarCadastroFilme.setBackground(UIManager.getColor("Menu.background"));
		btnEnviarCadastroFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEnviarCadastroFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnviarCadastroFilme.setBounds(326, 330, 89, 23);
		contentPane.add(btnEnviarCadastroFilme);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 165, -318, -54);
		contentPane.add(scrollPane);
		
		JTextArea textSinopseFilme = new JTextArea();
		textSinopseFilme.setBackground(SystemColor.info);
		textSinopseFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		textSinopseFilme.setBounds(91, 105, 336, 70);
		contentPane.add(textSinopseFilme);
	}
}
