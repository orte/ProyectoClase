package LP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import comun.DuplicadoException;
import LN.clsAlumno;
import LN.clsGestor;

import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
/**
 * Clase ventana, que hereda de JFrame que enseña un formulario para dar de alta a un alumno. Implementa
 * las interfaces ActionListener y DocumentListener
 * @author jon.orte
 *
 */
public class AltaAlumnoFrm extends JFrame implements ActionListener, DocumentListener{
	 
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
	private JButton aceptar;
	private JPanel panel;
	private JComboBox comboBox;
	
	public AltaAlumnoFrm(){
		setResizable(false);
		setTitle("Alta de alumno");
		lblTitulo=new JLabel("Introduzca los datos del alumno");
		lblNombre=new JLabel("Nombre");
		lblNombre.setBounds(10, 2, 394, 22);
		lblAp1=new JLabel("Primer apellido");
		lblAp1.setBounds(10, 46, 394, 22);
		lblAp2=new JLabel("Segundo apellido");
		lblAp2.setBounds(10, 90, 394, 22);
		lblId=new JLabel("ID de alumno");
		lblId.setBounds(10, 134, 394, 22);
		lblAno=new JLabel("Año de matriculación");
		lblAno.setBounds(10, 178, 192, 22);
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
		campos.add(lblAno);
		pane.add(campos, BorderLayout.CENTER);
		
		String [] years = new String [16];
		for (int i=0;i<years.length;i++){
			years[i]=""+(2000+i);
		}
		comboBox = new JComboBox(years);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 198, 86, 20);
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

	/**
	 * Acción que ocurrirá cuando se pulse el botón Aceptar. Se cogerán los datos del formulario y con ellos
	 * se llamará al método nuevoAlumno de la clase gestor para crear un nuevo objeto de la clase alumno y 
	 * guardarlo en su fichero. Después se enseñará una ventana de diálogo con un mensaje y si existe un alumno
	 * con ese ID se abrirá otra.
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			clsAlumno nuevo=ges.nuevoAlumno(txtNombre.getText(), txtAp1.getText(), txtAp2.getText(), txtId.getText(), Integer.parseInt((String)comboBox.getSelectedItem()));
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
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Ya existe un alumno con este ID");
		}
	}

	/**
	 * Método que escucha los eventos en los campos de texto para activar el botón Aceptar cuando ninguno esté vacío
	 * @author jon.orte
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtAp1.getText().equals("")==false&&txtAp2.getText().equals("")==false&&txtId.getText().equals("")==false){
			aceptar.setEnabled(true);
		}
	}

	/**
	 * Método que escucha los eventos en los campos de texto para activar el botón Aceptar cuando ninguno esté vacío. Si
	 * al borrar algo de los mismos se queda alguno vacío, desactivará el botón
	 * @author jon.orte
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtAp1.getText().equals("")==false&&txtAp2.getText().equals("")==false&&txtId.getText().equals("")==false){
			aceptar.setEnabled(true);
		} else{
			aceptar.setEnabled(false);
		}
	}

	/**
	 * Método que escucha los eventos en los campos de texto para activar el botón Aceptar cuando ninguno esté vacío. Si
	 * al borrar algo de los mismos se queda alguno vacío, desactivará el botón
	 * @author jon.orte
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(txtNombre.getText().equals("")==false&&txtAp1.getText().equals("")==false&&txtAp2.getText().equals("")==false&&txtId.getText().equals("")==false){
			aceptar.setEnabled(true);
		} else{
			aceptar.setEnabled(false);
		}
	}
	
	
	
}
