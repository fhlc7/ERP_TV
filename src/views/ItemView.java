package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.omg.IOP.CodecPackage.FormatMismatch;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.text.Format;
import java.util.logging.SimpleFormatter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JFormattedTextField frmtdtxtfldEntrada;
	private JFormattedTextField frmtdtxtfldSaida;
	private JTextField txtQuem;
	private JLabel lblItem;
	private JComboBox comboBoxStatus;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemView frame = new ItemView();
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
	public ItemView() {
		setTitle("Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 730);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblItem = new JLabel("Item");
		lblItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblItem.setFont(new Font("SansSerif", Font.PLAIN, 72));
		lblItem.setBounds(6, 6, 824, 92);
		contentPane.add(lblItem);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Insira os dados do item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 110, 824, 214);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("id:");
		lblId.setBounds(53, 46, 55, 16);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(120, 40, 122, 28);
		panel.add(txtId);
		txtId.setEditable(false);
		txtId.setText("id");
		txtId.setColumns(10);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(53, 85, 74, 16);
		panel.add(lblDescrio);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(120, 80, 577, 28);
		panel.add(txtDescricao);
		txtDescricao.setText("Descricao");
		txtDescricao.setColumns(10);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			frmtdtxtfldEntrada = new JFormattedTextField(maskFormatter);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data inválida\n\nTente novamente: " + e);
			frmtdtxtfldEntrada.setText(null);
			frmtdtxtfldEntrada.requestFocus();
		}
		frmtdtxtfldEntrada.setBounds(120, 120, 75, 28);
		panel.add(frmtdtxtfldEntrada);

		JLabel lblEntrada = new JLabel("Entrada:");
		lblEntrada.setBounds(53, 126, 55, 16);
		panel.add(lblEntrada);

		JLabel lblSada = new JLabel("Saída:");
		lblSada.setBounds(207, 126, 35, 16);
		panel.add(lblSada);
		try {
			MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
			frmtdtxtfldSaida = new JFormattedTextField(maskFormatter);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data inválida\n\nTente novamente: " + e);
			frmtdtxtfldSaida.setText(null);
			frmtdtxtfldSaida.requestFocus();
		}
		frmtdtxtfldSaida.setBounds(254, 120, 75, 28);
		panel.add(frmtdtxtfldSaida);
		frmtdtxtfldSaida.setText("Saida");

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(341, 127, 38, 16);
		panel.add(lblStatus);

		txtQuem = new JTextField();
		txtQuem.setBounds(120, 160, 421, 28);
		panel.add(txtQuem);
		txtQuem.setText("Quem");
		txtQuem.setColumns(10);

		JLabel lblQuem = new JLabel("Quem:");
		lblQuem.setBounds(53, 166, 37, 16);
		panel.add(lblQuem);

		comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(391, 122, 150, 26);
		panel.add(comboBoxStatus);
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "Pendente", "Em andamento", "Finalizado" }));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(709, 34, 90, 28);
		panel.add(btnAtualizar);
		btnAtualizar.setMnemonic('a');
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(709, 74, 90, 28);
		panel.add(btnNovo);
		btnNovo.setMnemonic('n');
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setBounds(709, 114, 90, 28);
		panel.add(btnSalvar);
		btnSalvar.setMnemonic('s');
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(709, 154, 90, 28);
		panel.add(btnDeletar);
		btnDeletar.setMnemonic('d');
		
		table = new JTable();
		table.setBounds(6, 336, 824, 349);
		contentPane.add(table);
	}
	
	private void atualizar() {
		limpar();
		txtDescricao.requestFocus();
	}
	
	private void limpar() {
		txtId.setText(null);
		txtDescricao.setText(null);
		
	}
	
	private void salvar() {
		
	}
	
}
