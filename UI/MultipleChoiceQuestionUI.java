/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import questions.*;
import java.util.*;

/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
public class MultipleChoiceQuestionUI extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JLabel lblQuestion = null;
	private Quiz quiz = null;
	private JCheckBox[] cbChoices = null;
	/**
	 * This is the default constructor
	 */
	public MultipleChoiceQuestionUI(Quiz quiz) {
		super();
		this.quiz =quiz;
		initialize();
	}
    
	public String[] getAnswer() throws ValidationException{
        int count = 0;
		List<String> list = new LinkedList<String>();
        for(JCheckBox cb: cbChoices){
            if(cb.isSelected()){
                list.add(cb.getText());
                count++;
            }
        }
        /* Si no quedo ninguna seleccionada lanzo excepcion
        */
        if(count == 0){
            throw new ValidationException("Seleccione al menos una opcion.");
        }
        String[] resp = new String[list.size()];
        resp = list.toArray(resp);
		return resp;
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
		this.getCheckBoxes();
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

	private void getCheckBoxes() {
		int i = 0;
		String[] possibilities = ((ChoiceQuestion)this.quiz.getActualQuestion()).getChoices();
		this.cbChoices = new JCheckBox[possibilities.length];
		for(String choice: possibilities){
			this.cbChoices[i] = new JCheckBox();
			this.cbChoices[i].setText(choice);
			this.cbChoices[i].setBounds(19, 50 + i*40, 603, 25);
			this.cbChoices[i].setVisible(true);
			this.add(this.cbChoices[i], null);
			i++;
		}
	}
}  //  @jve:decl-index=0:visual-constraint="20,5"
