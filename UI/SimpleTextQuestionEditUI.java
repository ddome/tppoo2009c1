package UI;

import javax.swing.*;

import questions.*;

public class SimpleTextQuestionEditUI extends JPanel 
                                            implements Editable, Validable{

	private javax.swing.JPanel jContentPane = null;
	private JTextField txtQuestion = null;
	private JTextField txtAnswer = null;
	private Question question = null;
	private Boolean isNewQuestion;

    private JLabel lblLevel = null;
    private JLabel lblScore = null;
    private JComboBox cmbLevels = null;
    private JTextField txtScore = null;
    
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
	
	public Question getEditedQuestion(){
		SimpleTextQuestion newQuestion;
        
        try{
            newQuestion = new SimpleTextQuestion(txtQuestion.getText(),
                txtAnswer.getText(),
                getDifficultyCode(cmbLevels.getSelectedItem().toString()),
                getScore());
            return newQuestion;
        }
        catch(NumberFormatException ex){
            return null;
        }		
	}
    
    public Boolean Validate(){
        Integer score;
        try{
            score = getScore();
        }
        catch(NumberFormatException ex){
            return false;
        }
        Boolean resp =  txtQuestion.getText().trim().length() > 0 
                && txtAnswer.getText().trim().length() > 0;
        
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
		this.add(getQuestionTextBox(), null);
		this.add(getAnswerTextBox(), null);
        this.add(this.getLevelCombo());
        this.add(this.getScoreTxt());
        this.add(this.getLevelLabel());
        this.add(this.getScoreLabel());
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
    
    private JLabel getLevelLabel(){
        if(lblLevel == null){
            lblLevel = new JLabel();
            lblLevel.setBounds(19, 210, 180, 25);
            lblLevel.setText("Nivel: ");
        }
        return lblLevel;
    }

    private JLabel getScoreLabel(){
        if(lblScore == null){
            lblScore = new JLabel();
            lblScore.setBounds(19,240, 180, 25);
            lblScore.setText("Puntaje: ");
        }
        return lblScore;
    }
    
    private JComboBox getLevelCombo(){
        if(cmbLevels == null){
            String[] difficulties = {"Facil", 
                                    "Intermedio",
                                    "Dificil"};
            cmbLevels = new JComboBox(difficulties);
            cmbLevels.setBounds(220, 210, 200, 25); 
            if(!isNewQuestion){
                cmbLevels.setSelectedIndex(question.getLevel());
            }
        }
        return cmbLevels;
    }
    
    private JTextField getScoreTxt(){
        if(txtScore == null){
            txtScore = new JTextField();
            txtScore.setBounds(220, 240, 200, 25);
            if(!isNewQuestion){
                Integer score = question.getScore();
                txtScore.setText(score.toString());
            }
        }
        return txtScore;
    }
    
    private int getDifficultyCode(String difficulty){
        int code;
        if(difficulty.equals("Facil")){
            code = Question.LEVEL_EASY;
        }
        else if(difficulty.equals("Intermedio")){
            code = Question.LEVEL_MEDIUM;
        }
        else{
            code = Question.LEVEL_HARD;
        }
        return code;
    }
    
    private String getDifficultyName(int code){
        String dif;
        if(code == Question.LEVEL_EASY){
            dif = new String("Facil'");
        }
        else if(code == Question.LEVEL_MEDIUM){
            dif = new String("Intermedio");
        }
        else{
            dif = new String("Dificil");
        }
        return dif;
    }
    
    private int getScore() throws NumberFormatException{
        Integer score = Integer.valueOf(txtScore.getText().trim());
        return score;
    }
 } 
