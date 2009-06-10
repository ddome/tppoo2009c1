
package UI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import questions.*;


public class BooleanQuestionUI extends JPanel {

	private JLabel lblQuestion = null;
	private JRadioButton rbTrue = null;
	private JRadioButton rbFalse = null;
	private ButtonGroup buttonGroup = null;
	private Quiz quiz = null;
	/**
	 * This is the default constructor
	 */
	public BooleanQuestionUI(Quiz quiz) {
		super();
		this.quiz = quiz;
		this.buttonGroup = new ButtonGroup();
		initialize();
	}
	
	public Boolean getAnswer() throws ValidationException{
		return this.rbTrue.isSelected() || this.rbFalse.isSelected();
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
		this.add(getTrueRadioButton(), null);
		this.add(getFalseRadioButton(), null);
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
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getTrueRadioButton() {
		if (rbTrue == null) {
			rbTrue = new JRadioButton();
			rbTrue.setText("Verdadero");
			rbTrue.setBounds(19, 55, 172, 28);
		}
		buttonGroup.add(rbTrue);
		return rbTrue;
	}
	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getFalseRadioButton() {
		if (rbFalse == null) {
			rbFalse = new JRadioButton();
			rbFalse.setText("Falso");
			rbFalse.setBounds(19, 92, 172, 28);
		}
		buttonGroup.add(rbFalse);
		return rbFalse;
	}
  }  //  @jve:decl-index=0:visual-constraint="20,5"
