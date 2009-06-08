/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package UI;

import javax.swing.*;

import questions.*;
/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class SimpleTextQuestionEditUI extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JTextField txtQuestion = null;
	private JTextField txtAnswer = null;
	private Question question = null;
	private Boolean isNewQuestion;

	/**
	 * Constructor para alta
	 */
	public SimpleTextQuestionEditUI() {
		super();
		isNewQuestion = true;
		initialize();
	}
	/**
	 * Constructor para edicion
	 */
	public SimpleTextQuestionEditUI(Question question) {
		super();
		isNewQuestion = false;
		this.question = question;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(650, 350);
		this.setLayout(null);
		this.add(getQuestionTextBox(), null);
		this.add(getJTextField(), null);
	}
	
	private JTextField getQuestionTextBox(){
		if(txtQuestion == null){
			txtQuestion = new JTextField();
			txtQuestion.setBounds(19, 15, 603, 25);
			txtQuestion.setVisible(true);	
			if(!isNewQuestion){
				txtQuestion.setText(question.getQuestion());
			}
		}		
		return txtQuestion;
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
			if(!isNewQuestion){
				txtAnswer.setText(((SimpleTextQuestion)question).getAnswer());	
			}			
		}
		return txtAnswer;
	}
 } 
