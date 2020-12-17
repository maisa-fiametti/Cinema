package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

public class JFAtualizarFIlme extends JFrame {

	private JPanel contentPane;
	private JTextField textTituloFilme;
	private JTextField textCategoriaFilme;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFIlme frame = new JFAtualizarFIlme(id);
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
	public JFAtualizarFIlme(int id) {
		setBackground(new Color(245, 222, 179));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 446);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alterar filme");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBounds(172, 11, 165, 20);
		contentPane.add(lblTitulo);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblNewLabel = new JLabel("ID do filme:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 31, 90, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("New label");
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(136, 42, 75, 17);
		contentPane.add(lblId);
		
		
		textTituloFilme = new JTextField();
		textTituloFilme.setForeground(Color.BLACK);
		textTituloFilme.setBackground(SystemColor.info);
		textTituloFilme.setHorizontalAlignment(SwingConstants.CENTER);
		textTituloFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		textTituloFilme.setBounds(91, 101, 336, 31);
		contentPane.add(textTituloFilme);
		textTituloFilme.setColumns(10);
		
		JLabel lblTituloFilme = new JLabel("T\u00EDtulo:");
		lblTituloFilme.setBackground(new Color(245, 222, 179));
		lblTituloFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblTituloFilme.setBounds(36, 70, 75, 20);
		contentPane.add(lblTituloFilme);
		
		JLabel TextSinopseFilme = new JLabel("Sinopse:");
		TextSinopseFilme.setFont(new Font("Arial", Font.BOLD, 14));
		TextSinopseFilme.setBounds(21, 133, 90, 20);
		contentPane.add(TextSinopseFilme);
		
		JLabel lblCategoriaFilme = new JLabel("Categoria:");
		lblCategoriaFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategoriaFilme.setBounds(21, 245, 75, 14);
		contentPane.add(lblCategoriaFilme);
		
		JLabel lblTempoFilme = new JLabel("Tempo:");
		lblTempoFilme.setFont(new Font("Arial", Font.BOLD, 14));
		lblTempoFilme.setBounds(36, 318, 75, 14);
		contentPane.add(lblTempoFilme);
		
		textCategoriaFilme = new JTextField();
		textCategoriaFilme.setBackground(SystemColor.info);
		textCategoriaFilme.setHorizontalAlignment(SwingConstants.CENTER);
		textCategoriaFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		textCategoriaFilme.setBounds(91, 270, 336, 31);
		contentPane.add(textCategoriaFilme);
		textCategoriaFilme.setColumns(10);
		
		JSpinner spinnerTempoFilme = new JSpinner();
		spinnerTempoFilme.setFont(new Font("Arial", Font.PLAIN, 15));
		spinnerTempoFilme.setBackground(Color.WHITE);
		spinnerTempoFilme.setBounds(92, 312, 65, 20);
		contentPane.add(spinnerTempoFilme);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setFont(new Font("Arial", Font.BOLD, 14));
		lblImagem.setBounds(207, 315, 75, 20);
		contentPane.add(lblImagem);
		
		JRadioButton rdbtnImagem2D = new JRadioButton("2D");
		rdbtnImagem2D.setBackground(new Color(245, 222, 179));
		rdbtnImagem2D.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnImagem2D.setBounds(286, 316, 51, 18);
		contentPane.add(rdbtnImagem2D);
		
		JRadioButton rdbtnImagem3D = new JRadioButton("3D");
		rdbtnImagem3D.setBackground(new Color(245, 222, 179));
		rdbtnImagem3D.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnImagem3D.setBounds(345, 312, 51, 27);
		contentPane.add(rdbtnImagem3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtnImagem2D);
		imagem.add(rdbtnImagem3D);
		
		JLabel lblAudio = new JLabel("\u00C1udio:");
		lblAudio.setFont(new Font("Arial", Font.BOLD, 14));
		lblAudio.setBounds(36, 348, 57, 14);
		contentPane.add(lblAudio);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBackground(new Color(245, 222, 179));
		rdbtnDublado.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnDublado.setBounds(93, 339, 79, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBackground(new Color(245, 222, 179));
		rdbtnLegendado.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnLegendado.setBounds(187, 339, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		imagem.add(rdbtnDublado);
		imagem.add(rdbtnLegendado);
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		textTituloFilme.setText(f.getTitulo());
		TextSinopseFilme.setText(f.getSinopse());
		textCategoriaFilme.setText(f.getCategoria());
		spinnerTempoFilme.setValue(f.getTempo());
		if(f.isImagem3d() == true) {
			rdbtnImagem3D.setSelected(true);
		}else if (f.isImagem3d() == false) {
			rdbtnImagem2D.setSelected(true);
		}
		if(f.isDublado() == true) {
			rdbtnDublado.setSelected(true);
		}else if (f.isDublado() == false) {
			rdbtnLegendado.setSelected(true);
		}
		
		
		JButton btnAlterarFilme = new JButton("Alterar");
		btnAlterarFilme.addActionListener(new ActionListener() {
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
		btnAlterarFilme.setBackground(UIManager.getColor("MenuBar.background"));
		btnAlterarFilme.setForeground(new Color(0, 0, 0));
		btnAlterarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterarFilme.setBounds(91, 373, 100, 23);
		contentPane.add(btnAlterarFilme);
		
		JButton btnLimparCadastroFilme = new JButton("Limpar");
		btnLimparCadastroFilme.setBackground(UIManager.getColor("Menu.background"));
		btnLimparCadastroFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLimparCadastroFilme.setBounds(219, 373, 89, 23);
		contentPane.add(btnLimparCadastroFilme);
		
		JButton btnEnviarCadastroFilme = new JButton("Enviar");
		btnEnviarCadastroFilme.setBackground(UIManager.getColor("Menu.background"));
		btnEnviarCadastroFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEnviarCadastroFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnviarCadastroFilme.setBounds(338, 373, 89, 23);
		contentPane.add(btnEnviarCadastroFilme);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 165, -318, -54);
		contentPane.add(scrollPane);
		
		JTextArea textSinopseFilme = new JTextArea();
		textSinopseFilme.setBackground(SystemColor.info);
		textSinopseFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		textSinopseFilme.setBounds(91, 164, 336, 70);
		contentPane.add(textSinopseFilme);
		
	
	}
}
