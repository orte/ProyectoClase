package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import LN.clsAsignatura;
import LN.clsGestor;
import LN.clsProfesor;
import comun.DuplicadoException;

import javax.swing.JComboBox;

public class AltaAsignaturaFrm extends JFrame implements ActionListener, DocumentListener{
	 
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblDesc;
	private JLabel lblCreds;
	private JLabel lblId;
	private JTextField txtNombre;
	private JTextField txtDesc;
	private JTextField txtId;
	private JComboBox comboBox;
	private JButton aceptar;
	private JPanel panel;
	
	public AltaAsignaturaFrm(){
		setTitle("Alta de asignatura");
		lblTitulo=new JLabel("Introduzca los datos de la asignatura");
		lblNombre=new JLabel("Nombre");
		lblNombre.setBounds(10, 2, 394, 22);
		lblDesc=new JLabel("Descripción");
		lblDesc.setBounds(10, 46, 394, 22);
		lblCreds=new JLabel("Número de créditos");
		lblCreds.setBounds(10, 90, 394, 22);
		lblId=new JLabel("ID de la asignatura");
		lblId.setBounds(10, 134, 394, 22);
		txtNombre=new JTextField();
		txtNombre.setBounds(10, 24, 192, 22);
		txtDesc=new JTextField();
		txtDesc.setBounds(10, 68, 192, 22);
		txtId=new JTextField();
		txtId.setBounds(10, 156, 192, 22);
		txtNombre.getDocument().addDocumentListener(this);
		txtDesc.getDocument().addDocumentListener(this);
		txtId.getDocument().addDocumentListener(this);
		
		JPanel pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel campos=new JPanel();
		campos.setLayout(null);
		campos.add(lblNombre);
		campos.add(txtNombre);
		campos.add(lblDesc);
		campos.add(txtDesc);
		campos.add(lblCreds);
		campos.add(lblId);
		campos.add(txtId);
		pane.add(campos, BorderLayout.CENTER);
		
		
		String [] creds = new String [11];
		for (int i=0;i<creds.length;i++){
			creds[i]=""+i;
		}
		comboBox = new JComboBox(creds);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 111, 97, 20);
		campos.add(comboBox);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		aceptar=new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.setEnabled(false);
		aceptar.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(420, 315));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			clsAsignatura nuevo=ges.NuevaAsignatura(txtNombre.getText(), txtDesc.getText(),txtId.getText(), Integer.parseInt((String) comboBox.getSelectedItem()) );
			JOptionPane.showMessageDialog(this, "Enhorabuena, has dado de alta "+nuevo.toString());;
			this.dispose();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicadoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Ya existe una asignatura con este ID");
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtDesc.getText().equals("")==false&&comboBox.getSelectedItem().equals("")==false&&txtId.getText().equals("")==false){
			aceptar.setEnabled(true);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
