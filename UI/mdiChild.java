/*
 * Creado el 06/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package UI;

import javax.swing.*;

/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class mdiChild extends JInternalFrame {

	private javax.swing.JPanel jContentPane = null;
	/**
	 * This is the default constructor
	 */
	public mdiChild(JPanel panel, String title) {
		super();
		initialize(panel, title);
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize(JPanel panel, String title) {
		this.setSize(650, 400);
		this.setContentPane(getJContentPane(panel));
		this.setTitle(title);
		
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane(JPanel panel) {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(panel);
		}
		return jContentPane;
	}
}
