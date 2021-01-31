package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cf = new JFCadastrarCliente();
				cf.setVisible(true);
				dispose();
			}
		});
		btnCadastrarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrarCliente.setBackground(SystemColor.menu);
		btnCadastrarCliente.setBounds(33, 306, 158, 33);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar se há linha selecionada 
				
				
				if(JtCliente.getSelectedRow()!= -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente((int)JtCliente.getValueAt(JtCliente.getSelectedRow(), 0));
					ac.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnAlterarCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAlterarCliente.setBackground(SystemColor.menu);
		btnAlterarCliente.setBounds(43, 350, 148, 33);
		contentPane.add(btnAlterarCliente);
		
		JButton btnNewButton = new JButton("Excluir Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JtCliente.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIdCliente((int) JtCliente.getValueAt(JtCliente.getSelectedRow(), 0));
						dao.delete(c);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(253, 306, 133, 33);
		contentPane.add(btnNewButton);
		
		JButton btnCancelarCliente = new JButton("Cancelar");
		btnCancelarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancelarCliente.setBounds(253, 356, 133, 27);
		contentPane.add(btnCancelarCliente);
		
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
