package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		JtFilme.setFont(new Font("Arial", Font.PLAIN, 15));
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
		btnCadastrarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadatrarFilme cf = new JFCadatrarFilme();
				cf.setVisible(true);
			}
		});
		btnCadastrarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarFilme.setBackground(SystemColor.menu);
		btnCadastrarFilme.setBounds(22, 272, 138, 31);
		contentPane.add(btnCadastrarFilme);
		
		JButton btnAlterarFilme = new JButton("Alterar Filme");
		btnAlterarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//verificar se há linha selecionada 
				
				
				if(JtFilme.getSelectedRow()!= -1) {
					JFAtualizarFIlme af = new JFAtualizarFIlme((int)JtFilme.getValueAt(JtFilme.getSelectedRow(), 0));
					af.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
				
			}
		});
		btnAlterarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterarFilme.setBackground(SystemColor.menu);
		btnAlterarFilme.setBounds(22, 312, 140, 31);
		contentPane.add(btnAlterarFilme);
		
		JButton btnExcluirFilme = new JButton("Excluir Filme");
		btnExcluirFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JtFilme.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) JtFilme.getValueAt(JtFilme.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnExcluirFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirFilme.setBackground(SystemColor.menu);
		btnExcluirFilme.setBounds(216, 272, 138, 31);
		contentPane.add(btnExcluirFilme);
		
		JButton btnCancelarFilme = new JButton("Cancelar Filme");
		btnCancelarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarFilme.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancelarFilme.setBounds(216, 317, 138, 26);
		contentPane.add(btnCancelarFilme);
		
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
