package LP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MenuPrincipalWdw extends JFrame implements ActionListener{
	
	private JPanel pane;
	private JLabel label;
	private JPanel opciones;
	private JRadioButton but1;
	private JRadioButton but2;
	private JRadioButton but3;
	private ButtonGroup group;
	private JButton aceptar;
	
	public MenuPrincipalWdw(){
		
		
		label=new JLabel("Bienvenido! Introduzca una opción");
		opciones=new JPanel(new GridLayout(3,0));
		but1=new JRadioButton("Alta de alumno");
		but1.setActionCommand("1");
		but2=new JRadioButton("Modificar alumno");
		but2.setActionCommand("2");
		but3=new JRadioButton("Eliminar alumno");
		but3.setActionCommand("3");
		group=new ButtonGroup();
		group.add(but1);
		group.add(but2);
		group.add(but3);
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(this);
		pane.add(label, BorderLayout.PAGE_START);
		opciones.add(but1);
		opciones.add(but2);
		opciones.add(but3);
		pane.add(opciones, BorderLayout.CENTER);
		pane.add(aceptar, BorderLayout.PAGE_END);
		pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsMenu menu=new clsMenu();
		String command=group.getSelection().getActionCommand();
		if(command.equals("1")){
			menu.AltaAlumno();
		} else if(command.equals("2")){
			menu.ModificarAlumno();
		} else if(command.equals("3")){
			menu.EliminarAlumno();
		}
		this.dispose();
	}
	
	

	/*static clsMenu menu=new clsMenu();
	private static final long serialVersionUID = 1L;
	
	public static void addComponentsToPane(Container pane){
		BorderLayout border=new BorderLayout();
		pane.setLayout(border);
		JLabel label=new JLabel("Bienvenido! Introduzca una opción");
		pane.add(label, border.PAGE_START);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,0));
		JRadioButton but1=new JRadioButton("1.- Alta de alumno");
		but1.setActionCommand("1");
		JRadioButton but2=new JRadioButton("2.- Modificar datos de alumno");
		but2.setActionCommand("2");
		JRadioButton but3=new JRadioButton("3.- Eliminar alumno");
		but3.setActionCommand("3");
		final ButtonGroup group=new ButtonGroup();
		group.add(but1);
		group.add(but2);
		group.add(but3);
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		pane.add(panel, border.CENTER);
		
		JPanel pan=new JPanel();
		pan.setLayout(new FlowLayout());
		JButton acept=new JButton("Aceptar");
		JButton canc=new JButton("Salir");
		acept.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String command=group.getSelection().getActionCommand();
				if(command.equals("1")){
					menu.AltaAlumno();
				} else if(command.equals("2")){
					menu.ModificarAlumno();
				} else if(command.equals("3")){
					menu.EliminarAlumno();
				}
			}
		});
		pan.add(acept);
		pan.add(canc);
		pane.add(pan, border.PAGE_END);
		
	}
	public static void createAndShowGUI(){
		JFrame frame=new JFrame("Menú principal");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}*/
}
