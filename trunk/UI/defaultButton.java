/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package UI;

import javax.swing.JButton;

/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class defaultButton extends JButton {

	private javax.swing.JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public defaultButton(String text) {
		super();
		initialize(text);
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize(String text) {
		this.setSize(140,30);
		this.setText(text);

	}
}
