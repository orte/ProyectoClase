package LP;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import comun.VacioException;

import LN.clsAlumno;
import LN.clsGestor;

/**
 * Clase ventana que hereda de JFrame y muestra una lista con los alumnos guardados, con el fin de poder seleccionar uno
 * y, al pulsar el bot�n aceptar, borrarlo del sistema. Implementa las interfaces ActionListener y ListSelectionListener
 * @author jon.orte
 *
 */
public class EliminarAlumnoFrm extends JFrame implements ActionListener, ListSelectionListener{
	
	private JLabel lblSeleccionaElAlumno;
	private JList<clsAlumno> list;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private clsGestor ges=new clsGestor();
	
	public EliminarAlumnoFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Eliminar alumno");
		getContentPane().setLayout(null);
		
		lblSeleccionaElAlumno = new JLabel("Selecciona el alumno que deseas eliminar");
		lblSeleccionaElAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionaElAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElAlumno.setBounds(20, 11, 247, 14);
		getContentPane().add(lblSeleccionaElAlumno);
		
		list = new JList<clsAlumno>();
		LinkedList<clsAlumno> alumnos=new LinkedList<clsAlumno>();
		try {
			alumnos=ges.ListaAlumnos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ListaAlumnoMdl modelAlm=new ListaAlumnoMdl(alumnos);
		list.setModel(modelAlm);
		list.setBounds(10, 36, 294, 259);
		list.addListSelectionListener(this);
		getContentPane().add(list);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(20, 308, 89, 23);
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(179, 308, 89, 23);
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		this.setSize(328, 401);
		
	}

	/**
	 * Cuando, despu�s de seleccionar un alumno de la lista se pulsa Aceptar, se muestra un cuadro de dialogo preguntando
	 * si realmente se quiere eliminar ese alumno. Si se pulsa SI, se coge ese alumno seleccionado y se pasa por par�metro
	 * al m�todo de la clase gestor BorrarAlumno para que lo elimine del sistema. Si no se pulsa SI se volver� a la selecci�n
	 * de alumno, y si se pulsa cancelar se cerrar� la ventana
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aceptar")){
			clsAlumno borrado=list.getSelectedValue();
			int i;
			i=JOptionPane.showConfirmDialog(this, "Est�s seguro de que quieres eliminar a "+borrado.getNombre()+" "+borrado.getAp1()+"?");
			if (i==0){
				try {
					ges.BorrarAlumno(borrado);
					JOptionPane.showMessageDialog(this, "Has eliminado con �xito a "+borrado.toString());
					LinkedList<clsAlumno> alumnos=new LinkedList<clsAlumno>();
					try {
						alumnos=ges.ListaAlumnos();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ListaAlumnoMdl modelAlm=new ListaAlumnoMdl(alumnos);
					list.setModel(modelAlm);
					list.repaint();
					this.getContentPane().revalidate();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if(e.getActionCommand().equals("cancelar")){
			this.dispose();
		}
	}

	/**
	 * Al crearse la ventana no hay ning�n objeto seleccionado en la lista y el bot�n aceptar est� desactivado. Por lo tanto,
	 * si se selecciona un elemento de la lista, se activa el bot�n aceptar.
	 * @author jon.orte
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(btnAceptar.isEnabled()==false){
			btnAceptar.setEnabled(true);
		}
	}
}
