package LP;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * clase que hereda de JPanel usada para poner una imagen de fondo de pantalla al pasarle la ruta del fichero de la imagen
 * Sacada de: http://stackoverflow.com/questions/1064977/setting-background-images-in-jframe
 *
 */
public class JPanelWithBackground extends JPanel {

	  private Image backgroundImage;

	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public JPanelWithBackground(String fileName) throws IOException {
	    backgroundImage = ImageIO.read(new File(fileName));
	  }

	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this);
	  }
	}
