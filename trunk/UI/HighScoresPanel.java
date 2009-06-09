/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
package UI;

import javax.swing.*;

import javax.swing.JLabel;
/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
public class HighScoresPanel extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JLabel[] Scores = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public HighScoresPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel = new JLabel();
		this.setLayout(null);
		this.setSize(650,400);
		jLabel.setBounds(168, 92, 346, 69);
		jLabel.setText("puntajes");
		this.add(jLabel, null);
	}
	
}
