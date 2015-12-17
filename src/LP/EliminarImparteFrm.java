package LP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LN.clsGestor;
import LN.clsImparte;
import LN.clsMatricula;
import java.awt.Component;
import java.awt.Rectangle;

/**
 * Clase ventana que hereda de JFrame y muestra una lista con las relaciones entre profesores y asignaturas guardadas, con 
 * el fin de poder seleccionar una y, al pulsar el botón aceptar, borrarla del sistema. Implementa las interfaces 
 * ActionListener y ListSelectionListener
 * @author jon.orte
 *
 */
public class EliminarImparteFrm extends JFrame implements ActionListener, ListSelectionListener{
	
	private JLabel lblSeleccionaLaImpart;
	private JList<clsImparte> list;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private clsGestor ges=new clsGestor();
	
	public EliminarImparteFrm() {
		setBounds(new Rectangle(200, 200, 0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Eliminar impartición");
		getContentPane().setLayout(null);
		
		lblSeleccionaLaImpart = new JLabel("Selecciona la relación entre profesor y asignatura que deseas eliminar");
		lblSeleccionaLaImpart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionaLaImpart.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaLaImpart.setBounds(47, 11, 439, 14);
		getContentPane().add(lblSeleccionaLaImpart);
		
		list = new JList<clsImparte>();
		LinkedList<clsImparte> impartes=new LinkedList<clsImparte>();
		try {
			impartes=ges.ListaImparticiones();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListaImparteMdl modelImpart=new ListaImparteMdl(impartes);
		list.setModel(modelImpart);
		list.setBounds(47, 36, 449, 259);
		list.addListSelectionListener(this);
		getContentPane().add(list);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAceptar.setBounds(161, 306, 89, 23);
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setEnabled(false);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(291, 306, 89, 23);
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		this.setSize(543, 401);
	}

	/**
	 * Cuando, después de seleccionar una impartición de la lista se pulsa Aceptar, se muestra un cuadro de dialogo preguntando
	 * si realmente se quiere eliminar esa impartición. Si se pulsa SI, se coge el elemento seleccionado y se pasa al método de
	 * la clase gestor EliminarImparticion para que lo elimine del sistema. Si no se pulsa SI se volverá a la selección
	 * de la impartición, y si se pulsa cancelar se cerrará la ventana
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aceptar")){
			clsImparte borrado=list.getSelectedValue();
			int i;
			i=JOptionPane.showConfirmDialog(this, "Estás seguro de que quieres eliminar esta impartición? "+borrado.toString());
			if (i==0){
				try {
					ges.EliminarImparticion(borrado);
					JOptionPane.showMessageDialog(this, "Has eliminado con éxito "+borrado.toString());
					LinkedList<clsImparte> imparts=new LinkedList<clsImparte>();
					try {
						imparts=ges.ListaImparticiones();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ListaImparteMdl modelImpart=new ListaImparteMdl(imparts);
					list.setModel(modelImpart);
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
	 * Al crearse la ventana no hay ningún objeto seleccionado en la lista y el botón aceptar está desactivado. Por lo tanto,
	 * si se selecciona un elemento de la lista, se activa el botón aceptar.
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
