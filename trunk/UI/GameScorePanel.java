
package UI;

import javax.swing.JPanel;

import javax.swing.*;
import questions.*;

public class GameScorePanel extends JPanel {

	private javax.swing.JPanel jContentPane = null;
    private JLabel lblScore = null;

	private Quiz quiz = null;
	/**
	 * This is the default constructor
	 */
	public GameScorePanel(Quiz quiz) {
		super();
		this.quiz = quiz;
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
        this.add(getScoreLabel());
        addResults();
	}
	
    private JLabel getScoreLabel(){
        if(lblScore == null){
            String text;
            lblScore =new JLabel();
            text = "Puntaje Obtenido: " + ((Integer)quiz.getScore()).toString();
            lblScore.setText(text);
            lblScore.setBounds(15, 5, 400, 25);            
        }
        return lblScore;
    }
	private void addResults(){
		JLabel lblQuestion;
        JCheckBox cbResult;
        String[] questions = quiz.getQuestions();
        boolean[] results = quiz.getAnswers();
        for(int i = 0; i < questions.length; i++){
            lblQuestion = new JLabel();
            lblQuestion.setText(questions[i]);
            lblQuestion.setBounds(45,30+i*20,580, 20 );
            this.add(lblQuestion);
            
            cbResult = new JCheckBox();
            cbResult.setSelected(results[i]);
            cbResult.setEnabled(false);
            cbResult.setBounds(15, 30+i*20,20, 20);
            this.add(cbResult);
            
        }
	}
 }  //  @jve:decl-index=0:visual-constraint="20,5"
