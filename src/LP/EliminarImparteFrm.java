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

public class EliminarImparteFrm extends JFrame implements ActionListener, ListSelectionListener{
	
	private JLabel lblSeleccionaLaImpart;
	private JList<clsImparte> list;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private clsGestor ges=new clsGestor();
	
	public EliminarImparteFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Eliminar impartici�n");
		getContentPane().setLayout(null);
		
		lblSeleccionaLaImpart = new JLabel("Selecciona la relaci�n entre profesor y asignatura que deseas eliminar");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("aceptar")){
			clsImparte borrado=list.getSelectedValue();
			int i;
			i=JOptionPane.showConfirmDialog(this, "Est�s seguro de que quieres eliminar esta impartici�n? "+borrado.toString());
			if (i==0){
				try {
					ges.EliminarImparticion(borrado);
					JOptionPane.showMessageDialog(this, "Has eliminado con �xito "+borrado.toString());
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(btnAceptar.isEnabled()==false){
			btnAceptar.setEnabled(true);
		}
	}
}
