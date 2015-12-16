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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Eliminar impartición");
		getContentPane().setLayout(null);
		
		lblSeleccionaLaImpart = new JLabel("Selecciona la matricula que deseas eliminar");
		lblSeleccionaLaImpart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSeleccionaLaImpart.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaLaImpart.setBounds(20, 11, 247, 14);
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(btnAceptar.isEnabled()==false){
			btnAceptar.setEnabled(true);
		}
	}
}
