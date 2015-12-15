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
import LN.clsProfesor;

public class EliminarProfesorFrm extends JFrame implements ActionListener, ListSelectionListener{
	
	private JLabel lblSeleccionaElProfe;
	private JList<clsProfesor> list;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private clsGestor ges=new clsGestor();
	
	public EliminarProfesorFrm() {
		setTitle("Eliminar profesor");
		getContentPane().setLayout(null);
		
		lblSeleccionaElProfe = new JLabel("Selecciona el profesor que deseas eliminar");
		lblSeleccionaElProfe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionaElProfe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElProfe.setBounds(20, 11, 247, 14);
		getContentPane().add(lblSeleccionaElProfe);
		
		list = new JList<clsProfesor>();
		LinkedList<clsProfesor> profes=new LinkedList<clsProfesor>();
		try {
			profes=ges.ListaProfesores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ListaProfeMdl modelProf=new ListaProfeMdl(profes);
		list.setModel(modelProf);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aceptar")){
			clsProfesor borrado=list.getSelectedValue();
			int i;
			i=JOptionPane.showConfirmDialog(this, "Estás seguro de que quieres eliminar a "+borrado.getNombre()+" "+borrado.getAp1()+"?");
			if (i==0){
				try {
					ges.BorrarProfesor(borrado);
					JOptionPane.showMessageDialog(this, "Has eliminado con éxito a "+borrado.toString());
					LinkedList<clsProfesor> profes=new LinkedList<clsProfesor>();
					try {
						profes=ges.ListaProfesores();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ListaProfeMdl modelProf=new ListaProfeMdl(profes);
					list.setModel(modelProf);
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(btnAceptar.isEnabled()==false){
			btnAceptar.setEnabled(true);
		}
	}
}

