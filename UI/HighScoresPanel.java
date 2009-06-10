
package UI;

import javax.swing.JPanel;

import javax.swing.*;
import questions.*;

public class HighScoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private javax.swing.JPanel jContentPane = null;
    private JLabel lblScore = null;

	private Questionnaire q = null;

    
    private int difficulty = 0;
	/**
	 * This is the default constructor
	 */
	public HighScoresPanel(Questionnaire q, int difficulty) {
		super();
		this.q = q;
        this.difficulty = difficulty;
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
            text = "Puntajes Maximos";
            lblScore.setText(text);
            lblScore.setBounds(15, 5, 400, 25);            
        }
        return lblScore;
    }
	private void addResults(){
		JLabel lblScore;
		String Scores[]=null;
		try{
			Scores=q.getMaxScores(difficulty);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Error al leer los rankings."+ ex.getMessage());
		}
        for(int i = 0; i < Scores.length; i++){
            lblScore = new JLabel();
            lblScore.setText(Scores[i]);
            lblScore.setBounds(45,30+i*20,580, 20 );
            this.add(lblScore);
        }
	}
 }  //  @jve:decl-index=0:visual-constraint="20,5"
