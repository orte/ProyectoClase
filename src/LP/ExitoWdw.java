package LP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExitoWdw extends JFrame implements ActionListener{
	private JLabel titulo;
	private JButton aceptar;
	
	public ExitoWdw(String nuevo){
		titulo=new JLabel(nuevo+" ha sido dado de alta con éxito");
		aceptar=new JButton("Aceptar");
		aceptar.addActionListener(this);
		
		JPanel pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		
		pane.add(titulo, BorderLayout.PAGE_START);
		pane.add(aceptar, BorderLayout.PAGE_END);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
