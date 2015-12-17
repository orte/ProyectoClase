package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import LN.clsAlumno;
import LN.clsGestor;
import comun.DuplicadoException;

/**
 * Ventana interna que hereda de JInternalFrame y muestra un formulario para modificar un alumno en concreto. En su constructor
 * se reciben los atributos del alumno en cuestión para ponerlos por defecto en los campos de texto
 * @author jon.orte
 *
 */
public class ModificarAlumnoInternFrm extends JInternalFrame implements ActionListener{
	 
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
	private String id_alm;
	
	public ModificarAlumnoInternFrm(String nombre, String ap1, String ap2, String id, String year){
		setClosable(true);
		id_alm=id;
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
		txtNombre.setText(nombre);
		txtNombre.setBounds(10, 24, 192, 22);
		txtAp1=new JTextField();
		txtAp1.setText(ap1);
		txtAp1.setBounds(10, 68, 192, 22);
		txtAp2=new JTextField();
		txtAp2.setText(ap2);
		txtAp2.setBounds(10, 112, 192, 22);
		txtId=new JTextField();
		txtId.setText(id);
		txtId.setBounds(10, 156, 192, 22);
		
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
		
		int indx=-1;
		String [] years = new String [16];
		for (int i=0;i<years.length;i++){
			years[i]=""+(2000+i);
			if (year.equals(year)){
				indx=i;
			}
		}
		comboBox = new JComboBox(years);
		comboBox.setSelectedIndex(indx);
		comboBox.setBounds(10, 198, 86, 20);
		campos.add(comboBox);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		aceptar=new JButton("Aceptar");
		panel.add(aceptar);
		aceptar.setEnabled(true);
		aceptar.addActionListener(this);
		this.setSize(new Dimension(252, 323));
	}

	/**
	 * Al pulsar el botón aceptar, se llama al método ModificarAlumno de la clase gestor para, con los nuevos atributos
	 * modificar el alumno. Si este alumno modificado tiene un ID que coincide con el de alguno ya existente, se abre un
	 * cuadro de diálogo avisando de ello
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			clsAlumno mod=ges.ListaAlumnos().get(ges.BuscarAlumno(id_alm));
			ges.ModificarAlumno(mod, txtNombre.getText(), txtAp1.getText(), txtAp2.getText(), txtId.getText(), Integer.parseInt((String)comboBox.getSelectedItem()));
			JOptionPane.showMessageDialog(this, "Enhorabuena, has modificado los datos de "+mod.toString());;
			this.dispose();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicadoException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error, ya existe un alumno con este ID");
		}
	}
}
