/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package UI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import questions.*;

/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class SingleChoiceQuestionUI extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JLabel lblQuestion = null;
	private Quiz quiz= null;
	private ButtonGroup buttonGroup = null;
	private JRadioButton[] rbChoices = null;
	/**
	 * This is the default constructor
	 */
	public SingleChoiceQuestionUI(Quiz quiz) {
		super();
		this.quiz = quiz;
		this.buttonGroup = new ButtonGroup();
		initialize();
	}
	public int getAnswer(){
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
		this.getRadioButtons();
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
	/*TODO para cada respuesta correcta 
	 */
	private void getRadioButtons() {
		int i = 0;
		String[] possibilities = ((ChoiceQuestion)this.quiz.getActualQuestion()).getChoices();
		this.rbChoices = new JRadioButton[possibilities.length];
		for(String choice: possibilities){
			this.rbChoices[i] = new JRadioButton();
			this.rbChoices[i].setText(choice);
			this.rbChoices[i].setBounds(19, 50 + i*40, 603, 25);
			this.rbChoices[i].setVisible(true);
			this.buttonGroup.add(this.rbChoices[i]);
			this.add(this.rbChoices[i], null);
			i++;
		}
	}
}  //  @jve:decl-index=0:visual-constraint="20,5"
