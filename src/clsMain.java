
import javax.swing.JOptionPane;

import LP.*;
public class clsMain {

	/**
	 * github.com/orte/ProyectoClase
	 * M�todo main, crea y lanza el hilo swing y empieza la aplicaci�n
	 * @author jon.orte
	 * 
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		 javax.swing.SwingUtilities.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	            	//Create and set up the window.
	                MenuPrincipalFrm frame = new MenuPrincipalFrm();
	                frame.setVisible(true);
	            }
	        });
	}
}
