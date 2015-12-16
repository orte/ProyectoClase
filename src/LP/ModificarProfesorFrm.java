package LP;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import LN.clsGestor;
import LN.clsProfesor;

public class ModificarProfesorFrm extends JFrame implements ActionListener, InternalFrameListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSeleccionaElProfesor;
	private JList<clsProfesor>listProf;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private clsGestor ges=new clsGestor();
	
	public ModificarProfesorFrm() {
		setTitle("Modificar profesor");
		getContentPane().setLayout(null);
		
		lblSeleccionaElProfesor = new JLabel("Selecciona el profesor cuyos datos deseas modificar");
		lblSeleccionaElProfesor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccionaElProfesor.setBounds(10, 0, 275, 34);
		getContentPane().add(lblSeleccionaElProfesor);
		
		listProf = new JList<clsProfesor>();
		LinkedList<clsProfesor> profes=new LinkedList<clsProfesor>();
		try {
			profes=ges.ListaProfesores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListaProfeMdl modelProf=new ListaProfeMdl(profes);
		listProf.setModel(modelProf);
		listProf.setBounds(20, 34, 200, 283);
		getContentPane().add(listProf);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 328, 89, 23);
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(131, 328, 89, 23);
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		this.setSize(580, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("aceptar")){
			clsProfesor profe=(clsProfesor)listProf.getSelectedValue();
			ModificarProfeInternFrm internalFrame = new ModificarProfeInternFrm(profe.getNombre(), profe.getAp1(), profe.getAp2(), profe.getId_profesor(), profe.getDepartamento());
			internalFrame.setBounds(288, 11, 238, 292);
			getContentPane().add(internalFrame);
			internalFrame.setSize(new Dimension(252, 323));
			internalFrame.addInternalFrameListener(this);
			internalFrame.setVisible(true);
		} else if(e.getActionCommand().equals("cancelar")){
			this.dispose();
		}
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		LinkedList<clsProfesor> profes=new LinkedList<clsProfesor>();
		try {
			profes=ges.ListaProfesores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ListaProfeMdl modelProf=new ListaProfeMdl(profes);
		listProf.setModel(modelProf);
		listProf.repaint();
		this.getContentPane().revalidate();
}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		LinkedList<clsProfesor> profes=new LinkedList<clsProfesor>();
		try {
			profes=ges.ListaProfesores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ListaProfeMdl modelProf=new ListaProfeMdl(profes);
		listProf.setModel(modelProf);
		listProf.repaint();
		this.getContentPane().revalidate();
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}
}
