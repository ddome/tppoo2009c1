/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
package ui;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import questions.*;
/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
public class SimpleNumberQuestionUI extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JLabel lblQuestion = null;
	private JTextField txtAnswer = null;
	private Quiz quiz =null;
	/**
	 * This is the default constructor
	 */
	public SimpleNumberQuestionUI(Quiz quiz) {
		super();
		this.quiz = quiz;
		initialize();
	}
	
	public int getAnswer(){
		//return this.txtAnswer.toString();
		return 1;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(650, 350);
		this.setLayout(null);
		this.add(getQuestionLabel(), null);
		this.add(getJTextField(), null);
	}
	
	private JLabel getQuestionLabel(){
		if(lblQuestion == null){
			lblQuestion = new JLabel();
			lblQuestion.setBounds(19, 15, 603, 25);
			lblQuestion.setText(this.quiz.getActualQuestion().getQuestion());
			lblQuestion.setVisible(true);	
		}		
		return lblQuestion;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getJTextField() {
		if (txtAnswer == null) {
			txtAnswer = new JTextField();
			txtAnswer.setBounds(19, 51, 603, 28);
		}
		return txtAnswer;
	}
 }  //  @jve:decl-index=0:visual-constraint="20,5"
