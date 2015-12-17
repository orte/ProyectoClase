package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import LN.clsAsignatura;
import LN.clsGestor;
import LN.clsImparte;
import LN.clsProfesor;
import comun.DuplicadoException;

/**
 * Clase de tipo ventana que muestra dos listas, una con Profesores y otra con Asignaturas. El usuario selecciona un elemento 
 * de cada una y con ellos se crea una nueva matrícula. Implementa ListSelectionListener y ActionListener
 * @author jon.orte
 *
 */
public class NuevoImparteFrm extends JFrame implements ListSelectionListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private clsGestor ges=new clsGestor();
	private JLabel lblSeleccioneElProfesor;
	private JList<clsProfesor> listProf;
	private JList<clsAsignatura> listAsign;
	private JLabel lblProfes;
	private JLabel lblAsignaturas;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public NuevoImparteFrm() {
		setResizable(false);
		setTitle("Nueva impartición");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSeleccioneElProfesor = new JLabel("Seleccione el profesor y la asignatura a la que quiere que imparta");
		lblSeleccioneElProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElProfesor.setBounds(10, 11, 424, 14);
		contentPane.add(lblSeleccioneElProfesor);
		
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
		listProf.setBounds(20, 76, 177, 151);
		listProf.addListSelectionListener(this);
		contentPane.add(listProf);
		
		listAsign = new JList<clsAsignatura>();
		LinkedList<clsAsignatura> asigns=new LinkedList<clsAsignatura>();
		/**
		 * Aquí se comprueba si en la lista de asignaturas hay alguna que ya tiene impartidor. En ese caso, se quita de la
		 * lista para evitar duplicados.
		 */
		try{
			asigns=ges.ListaAsignaturas();
			LinkedList <clsImparte> impart=ges.ListaImparticiones();
			clsImparte[] arr1=new clsImparte[impart.size()];
			for(int i=0; i<arr1.length; i++){
				arr1[i]=impart.get(i);
			}
			clsAsignatura[] arr2=new clsAsignatura[asigns.size()];
			for(int i=0; i<arr2.length; i++){
				arr2[i]=asigns.get(i);
			}
			for (int j=0; j<arr2.length; j++){
				for(int i=0; i<arr1.length; i++){
					if(arr2[j].getId_asinatura().equals(arr1[i].getId_asignatura())){
						asigns.remove(arr2[j]);
					}
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		} 
		ListaAsignMdl modelAsgn=new ListaAsignMdl(asigns);
		listAsign.setModel(modelAsgn);
		listAsign.setBounds(234, 76, 177, 151);
		listAsign.addListSelectionListener(this);
		contentPane.add(listAsign);
		
		lblProfes = new JLabel("Profesores");
		lblProfes.setBounds(20, 62, 61, 14);
		contentPane.add(lblProfes);
		
		lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setBounds(234, 62, 68, 14);
		contentPane.add(lblAsignaturas);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(117, 253, 89, 23);
		btnAceptar.setEnabled(false);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(222, 253, 89, 23);
		contentPane.add(btnCancelar);
		this.setLocationRelativeTo(null);
	}

	/**
	 * El botón Aceptar está desactivado por defecto. Este método sirve para que, cuando haya un elemento seleccionado en ambas
	 * listas, el botón se active
	 * @author jon.orte
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		boolean a=false;
		boolean b=false;
		if (listProf.isSelectionEmpty()==false){
			a=true;
		}
		if (listAsign.isSelectionEmpty()==false){
			b=true;
		}
		if(a&b==true){
			btnAceptar.setEnabled(true);
		}
	}

	/**
	 * Cuando se seleccionan un profesor y una asignatura de las listas, se cogen ambas selecciones y se pasan al método
	 * NuevaImparticion del gestor para que se cree con ellos un nuevo objeto clsImparte. Si se pulsa Cancelar, se cierra
	 * la ventana
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("aceptar")){
			try {
				clsImparte nueva=ges.NuevaImparticion(listProf.getSelectedValue(), listAsign.getSelectedValue());
				JOptionPane.showMessageDialog(this, "Enhorabuena! Hay una nueva impartición. "+nueva.toString());
				this.dispose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else if(arg0.getActionCommand().equals("cancelar")){
			this.dispose();
		}
	}
}
