package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable JtFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listar filmes");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Californian FB", Font.BOLD, 19));
		lblTitulo.setBackground(new Color(245, 222, 179));
		lblTitulo.setBounds(142, 11, 131, 25);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 49, 405, 212);
		contentPane.add(scrollPane);
		
		JtFilme = new JTable();
		JtFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idFilme", "Titulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(JtFilme);
		
		JButton btnCadastrarFilme = new JButton("Cadastrar Filme");
		btnCadastrarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarFilme.setBackground(SystemColor.menu);
		btnCadastrarFilme.setBounds(26, 312, 138, 31);
		contentPane.add(btnCadastrarFilme);
		
		JButton btnAlterarFilme = new JButton("Alterar Filme");
		btnAlterarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterarFilme.setBackground(SystemColor.menu);
		btnAlterarFilme.setBounds(174, 312, 136, 31);
		contentPane.add(btnAlterarFilme);
		
		JButton btnExcluirFilme = new JButton("Excluir Filme");
		btnExcluirFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirFilme.setBackground(SystemColor.menu);
		btnExcluirFilme.setBounds(320, 312, 111, 31);
		contentPane.add(btnExcluirFilme);
		
		readJTable();
	}
	
	//metodo para ler uma tabela
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JtFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
		}
		
	}
	
}
