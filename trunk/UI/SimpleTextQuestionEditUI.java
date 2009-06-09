package ui;

import javax.swing.*;

import questions.*;

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
	
	public Question getFinalQuestion(){
		SimpleTextQuestion newQuestion;
		newQuestion = new SimpleTextQuestion(getQuestion(), getAnswer(), 1, 1);
		return (Question)newQuestion;
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
		this.add(getAnswerTextBox(), null);
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
	private JTextField getAnswerTextBox() {
		if (txtAnswer == null) {
			txtAnswer = new JTextField();
			txtAnswer.setBounds(19, 51, 603, 28);
			if(!isNewQuestion){
				txtAnswer.setText(((SimpleTextQuestion)question).getAnswer());	
			}			
		}
		return txtAnswer;
	}
	
	private String getQuestion(){
		return getQuestionTextBox().getText();
	}
	
	private String getAnswer(){
		return getAnswerTextBox().getText();
	}
 } 
