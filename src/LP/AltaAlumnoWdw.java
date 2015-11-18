package LP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import comun.DuplicadoException;
import LN.clsAlumno;
import LN.clsGestor;

public class AltaAlumnoWdw extends JFrame implements ActionListener, DocumentListener{
	 
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblAp1;
	private JLabel lblAp2;
	private JLabel lblId;
	private JLabel lblAno;
	private JTextField txtNombre;
	private JTextField txtAp1;
	private JTextField txtAp2;
	private JTextField txtId;
	private JTextField txtAno;
	private JButton aceptar;
	
	public AltaAlumnoWdw(){
		lblTitulo=new JLabel("Introduzca los datos del alumno");
		lblNombre=new JLabel("Nombre");
		lblAp1=new JLabel("Primer apellido");
		lblAp2=new JLabel("Segundo apellido");
		lblId=new JLabel("ID de alumno");
		lblAno=new JLabel("Año de matriculación");
		txtNombre=new JTextField();
		txtAp1=new JTextField();
		txtAp2=new JTextField();
		txtId=new JTextField();
		txtAno=new JTextField();
		aceptar=new JButton("Aceptar");
		aceptar.setEnabled(false);
		aceptar.addActionListener(this);
		txtNombre.getDocument().addDocumentListener(this);
		txtAp1.getDocument().addDocumentListener(this);
		txtAp2.getDocument().addDocumentListener(this);
		txtId.getDocument().addDocumentListener(this);
		txtAno.getDocument().addDocumentListener(this);
		
		JPanel pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(lblTitulo, BorderLayout.PAGE_START);
		
		JPanel campos=new JPanel(new GridLayout(10,0));
		campos.add(lblNombre);
		campos.add(txtNombre);
		campos.add(lblAp1);
		campos.add(txtAp1);
		campos.add(lblAp2);
		campos.add(txtAp2);
		campos.add(lblId);
		campos.add(txtId);
		campos.add(lblAno);
		campos.add(txtAno);
		pane.add(campos, BorderLayout.CENTER);
		
		pane.add(aceptar, BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			clsAlumno nuevo=ges.nuevoAlumno(txtNombre.getText(), txtAp1.getText(), txtAp2.getText(), txtId.getText(), Integer.parseInt(txtAno.getText()));
			ExitoWdw din=new ExitoWdw(nuevo.toString());
			this.dispose();
			din.pack();
			din.setVisible(true);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicadoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtAp1.getText().equals("")==false&&txtAp2.getText().equals("")==false&&txtId.getText().equals("")==false&&txtAno.getText().equals("")==false){
		//if(txtNombre.getText()!=null&&txtAp1.getText()!=null&&txtAp2.getText()!=null&&txtId.getText()!=null&&txtAno.getText()!=null){
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
