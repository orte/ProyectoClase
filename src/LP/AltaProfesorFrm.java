package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import LN.clsGestor;
import LN.clsProfesor;
import comun.DuplicadoException;

import javax.swing.JComboBox;

public class AltaProfesorFrm extends JFrame implements ActionListener, DocumentListener{
	 
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblAp1;
	private JLabel lblAp2;
	private JLabel lblId;
	private JLabel lblDept;
	private JTextField txtNombre;
	private JTextField txtAp1;
	private JTextField txtAp2;
	private JTextField txtId;
	private JButton aceptar;
	private JPanel panel;
	private JComboBox comboBox;
	
	public AltaProfesorFrm(){
		setTitle("Alta de profesor");
		lblTitulo=new JLabel("Introduzca los datos del profesor");
		lblNombre=new JLabel("Nombre");
		lblNombre.setBounds(10, 2, 394, 22);
		lblAp1=new JLabel("Primer apellido");
		lblAp1.setBounds(10, 46, 394, 22);
		lblAp2=new JLabel("Segundo apellido");
		lblAp2.setBounds(10, 90, 394, 22);
		lblId=new JLabel("ID de profesor");
		lblId.setBounds(10, 134, 394, 22);
		lblDept=new JLabel("Departamento");
		lblDept.setBounds(10, 178, 192, 22);
		txtNombre=new JTextField();
		txtNombre.setBounds(10, 24, 192, 22);
		txtAp1=new JTextField();
		txtAp1.setBounds(10, 68, 192, 22);
		txtAp2=new JTextField();
		txtAp2.setBounds(10, 112, 192, 22);
		txtId=new JTextField();
		txtId.setBounds(10, 156, 192, 22);
		txtNombre.getDocument().addDocumentListener(this);
		txtAp1.getDocument().addDocumentListener(this);
		txtAp2.getDocument().addDocumentListener(this);
		txtId.getDocument().addDocumentListener(this);
		
		JPanel pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel campos=new JPanel();
		campos.setLayout(null);
		campos.add(lblNombre);
		campos.add(txtNombre);
		campos.add(lblAp1);
		campos.add(txtAp1);
		campos.add(lblAp2);
		campos.add(txtAp2);
		campos.add(lblId);
		campos.add(txtId);
		campos.add(lblDept);
		pane.add(campos, BorderLayout.CENTER);
		
		String [] depts = {"Informática", "Derecho", "ADE", "Comunicación", "Magisterio"};
		comboBox = new JComboBox(depts);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 198, 113, 20);
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
			clsProfesor nuevo=ges.nuevoProfesor(txtNombre.getText(), txtAp1.getText(), txtAp2.getText(), txtId.getText(), (String)comboBox.getSelectedItem());
			JOptionPane.showMessageDialog(this, "Enhorabuena, has dado de alta a "+nuevo.toString());;
			this.dispose();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicadoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Ya existe un profesor con este ID");
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtAp1.getText().equals("")==false&&txtAp2.getText().equals("")==false&&txtId.getText().equals("")==false){
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
