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
import LN.clsMatricula;
import LN.clsProfesor;

/**
 * Clase ventana que hereda de JFrame y muestra una lista con las matrículas guardadas, con el fin de poder seleccionar una y,
 * al pulsar el botón aceptar, borrarla del sistema. Implementa las interfaces ActionListener y ListSelectionListener
 * @author jon.orte
 *
 */
public class EliminarMatriculaFrm extends JFrame implements ActionListener, ListSelectionListener{
	
	private JLabel lblSeleccionaLaMatricula;
	private JList<clsMatricula> list;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private clsGestor ges=new clsGestor();
	
	public EliminarMatriculaFrm() {
		setResizable(false);
		setTitle("Eliminar matricula");
		getContentPane().setLayout(null);
		
		lblSeleccionaLaMatricula = new JLabel("Selecciona la matricula que deseas eliminar");
		lblSeleccionaLaMatricula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionaLaMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaLaMatricula.setBounds(20, 11, 247, 14);
		getContentPane().add(lblSeleccionaLaMatricula);
		
		list = new JList<clsMatricula>();
		LinkedList<clsMatricula> matris=new LinkedList<clsMatricula>();
		try {
			matris=ges.ListaMatriculas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListaMatriculasMdl modelMatr=new ListaMatriculasMdl(matris);
		list.setModel(modelMatr);
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
	 * Cuando, después de seleccionar una matrícula de la lista se pulsa Aceptar, se muestra un cuadro de dialogo preguntando
	 * si realmente se quiere eliminar esa matrícula. Si se pulsa SI, se coge el elemento seleccionado y se pasa al método de
	 * la clase gestor BorrarMatriucla para que lo elimine del sistema. Si no se pulsa SI se volverá a la seleccióm de la 
	 * matrícula, y si se pulsa cancelar se cerrará la ventana
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aceptar")){
			clsMatricula borrado=list.getSelectedValue();
			int i;
			i=JOptionPane.showConfirmDialog(this, "Estás seguro de que quieres eliminar esta matrícula? "+borrado.toString());
			if (i==0){
				try {
					ges.BorrarMatricula(borrado);
					JOptionPane.showMessageDialog(this, "Has eliminado con éxito a "+borrado.toString());
					LinkedList<clsMatricula> matris=new LinkedList<clsMatricula>();
					try {
						matris=ges.ListaMatriculas();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ListaMatriculasMdl modelMatr=new ListaMatriculasMdl(matris);
					list.setModel(modelMatr);
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
