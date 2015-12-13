package LP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JInternalFrame;

public class ModificarAlumnoFrm extends JFrame{
	public ModificarAlumnoFrm() {
		setTitle("Modificar alumno");
		getContentPane().setLayout(null);
		
		JLabel lblSeleccionaElAlumno = new JLabel("Selecciona el alumno cuyos datos deseas modificar");
		lblSeleccionaElAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccionaElAlumno.setBounds(10, 0, 381, 34);
		getContentPane().add(lblSeleccionaElAlumno);
		
		JList list = new JList();
		list.setBounds(10, 36, 288, 198);
		getContentPane().add(list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(20, 250, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(191, 250, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
