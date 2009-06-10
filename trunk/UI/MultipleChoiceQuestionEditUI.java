package UI;

import javax.swing.*;
import java.util.*;
import questions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class MultipleChoiceQuestionEditUI extends JPanel 
                                        implements Editable, Validable{

	private javax.swing.JPanel jContentPane = null;
	private JTextField txtQuestion = null;
	
    private JList liChoices = null;
    private List<String> choicesList =null;
	private JScrollPane choicesListScrollPane= null;
    
    private JList liAnswers = null;
    private List<String> answersList =null;
	private JScrollPane answerListScrollPane= null;
        
    private Question question = null;
	private Boolean isNewQuestion;
    
    private DefaultListModel elemChoices = null;
    private DefaultListModel elemAnswers = null;

    private JLabel lblLevel = null;
    private JLabel lblScore = null;
    private JComboBox cmbLevels = null;
    private JTextField txtScore = null;
    
    private defaultButton btnAdd = null;
    private defaultButton btnDelete = null;
    private defaultButton btnIsCorrect = null;
    private defaultButton btnIsNotCorrect = null;
    
    private JLabel lblChoices = null;
    private JLabel lblAnswers = null;
    
	/**
	 * Constructor para alta
	 */
	public MultipleChoiceQuestionEditUI() {
		super();
		isNewQuestion = true;
		initialize();
	}
	/**
	 * Constructor para edicion
	 */
	public MultipleChoiceQuestionEditUI(Question question) {
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
        elemChoices = new DefaultListModel();
        elemAnswers = new DefaultListModel();
		this.setSize(650, 350);
		this.setLayout(null);
		this.add(getQuestionTextBox(), null);
		this.add(this.getChoicesList(), null);
        this.add(this.getChoicesListScroll(liChoices));
        this.add(this.getAnswersList(), null);
        this.add(this.getAnswersListScroll(liAnswers));
        this.add(this.getLevelCombo());
        this.add(this.getScoreTxt());
        this.add(this.getLevelLabel());
        this.add(this.getScoreLabel());
        this.add(this.getAddButton(), null);
        this.add(this.getDeleteButton(), null);
        this.add(this.getIsCorrectButton(), null);
        this.add(this.getIsNotCorrectButton(), null);
        this.add(this.getChoicesLabel());
        this.add(this.getAnswersLabel());
	}
    
    public Question getEditedQuestion(){
		MultipleChoiceQuestion newQuestion;
        try{
            String[] choices = new String[choicesList.size()];
            choices = choicesList.toArray(choices);
            String[] answers = new String[answersList.size()];
            answers = answersList.toArray(answers);
            newQuestion = new MultipleChoiceQuestion(getQuestion(), 
                    choices,
                    answers, 
                    getDifficultyCode(cmbLevels.getSelectedItem().toString()), 
                    getScore());

            return (Question)newQuestion;
        }
        catch(Exception ex){
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
                && choicesList.size()> 0 && answersList.size() > 0;
        
        return resp;
    }
        
    private int getScore() throws NumberFormatException{
        Integer score = Integer.valueOf(txtScore.getText().trim());
        return score;
    }
	
    public void addClicked(){
        String newOption;
        newOption = JOptionPane.showInputDialog(this,
                "Ingrese la nueva opcion", 
                "Nueva opcion");
        if(newOption.length() > 0){
            choicesList.add(newOption);
            elemChoices.addElement(newOption);
            
        }
    }

    public void deleteClicked(){
        int index = liChoices.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una opcion a eliminar");
        }
        else{
            /* La quito de las respuestas correctas tambien
            */
            String choice = choicesList.get(index);
            if(answersList.indexOf(choice) != -1){
                answersList.remove(choice);
                elemAnswers.removeElement(choice);
            }
            choicesList.remove(index);
            elemChoices.removeElementAt(index);
        }        
    }
        
    public void isCorrectClicked(){
        int index = liChoices.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una opcion");
        }
        else{
            String choice = choicesList.get(index);
            /* Si no esta en la lista de preguntas, lo inserto
            */
            if(answersList.indexOf(choice) == -1){
                answersList.add(choice);
                elemAnswers.addElement(choice);
            }
        }   
    }
    
    public void isNotCorrectClicked(){
        int index = liChoices.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una opcion");
        }
        else{
            String choice = choicesList.get(index);
            /* Si esta en la lista de preguntas, lo quito
            */
            if(answersList.indexOf(choice) != -1){
                answersList.remove(choice);
                elemAnswers.removeElement(choice);
            }
        }    
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
    
	private JList getChoicesList(){
        if(liChoices == null){
            choicesList = new LinkedList<String>();
            
            if(!isNewQuestion){
                String[] choices=((MultipleChoiceQuestion)question).getChoices(); 
                liChoices = new JList(choices);
                for(String choice: choices){
                    choicesList.add(choice);
                    elemChoices.addElement(choice);
                }
            }
            liChoices = new JList(elemChoices);
            liChoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            liChoices.setBounds(19, 60, 450, 80);
        }
        return liChoices;
    }
    
	private JScrollPane getChoicesListScroll(JList list){
		choicesListScrollPane = new JScrollPane(list);
		choicesListScrollPane.setBounds(19, 60, 450, 80);
		return choicesListScrollPane;
	}
    
    private JList getAnswersList(){
        if(liAnswers == null){
            answersList = new LinkedList<String>();
            
            if(!isNewQuestion){
                String[] choices=((MultipleChoiceQuestion)question).getAnswers();
                for(String choice: choices){
                    answersList.add(choice);
                    elemAnswers.addElement(choice);
                }                
            }
            liAnswers = new JList(elemAnswers);
            liAnswers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            liAnswers.setBounds(19, 170, 450, 80);
            
        }
        return liAnswers;
    }
    
	private JScrollPane getAnswersListScroll(JList list){
		answerListScrollPane = new JScrollPane(list);
		answerListScrollPane.setBounds(19, 170, 450, 80);
		return answerListScrollPane;
	}
        
    private JLabel getChoicesLabel(){
        if(lblChoices == null){
            lblChoices = new JLabel();
            lblChoices.setBounds(19, 40, 450, 22);
            lblChoices.setText("Posibilidades");
        }
        return lblChoices;
    }
    
        private JLabel getAnswersLabel(){
        if(lblAnswers == null){
            lblAnswers = new JLabel();
            lblAnswers.setBounds(19, 140, 450, 25);
            lblAnswers.setText("Correctas");
        }
        return lblAnswers;
    }
    
    private JLabel getLevelLabel(){
        if(lblLevel == null){
            lblLevel = new JLabel();
            lblLevel.setBounds(19, 250, 180, 25);
            lblLevel.setText("Nivel: ");
        }
        return lblLevel;
    }

    private JLabel getScoreLabel(){
        if(lblScore == null){
            lblScore = new JLabel();
            lblScore.setBounds(19,280, 180, 25);
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
            cmbLevels.setBounds(220, 250, 200, 25); 
            if(!isNewQuestion){
                cmbLevels.setSelectedIndex(question.getLevel());
            }
        }
        return cmbLevels;
    }
    
    private JTextField getScoreTxt(){
        if(txtScore == null){
            txtScore = new JTextField();
            txtScore.setBounds(220, 280, 200, 25);
            if(!isNewQuestion){
                Integer score = question.getScore();
                txtScore.setText(score.toString());
            }
        }
        return txtScore;
    }
    
        private defaultButton getAddButton(){
		if (btnAdd == null) {
			btnAdd = new defaultButton("Agregar");
			btnAdd.setLocation(475, 50);
            btnAdd.setVisible(true);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MultipleChoiceQuestionEditUI questionEditPanel = 
                              (MultipleChoiceQuestionEditUI)
                              ((Component)e.getSource()).getParent();
					questionEditPanel.addClicked();
				}
			});
		}
		return btnAdd;
	}
        
    private defaultButton getDeleteButton(){
		if (btnDelete == null) {
			btnDelete = new defaultButton("Quitar");
			btnDelete.setLocation(475, 90);
            btnDelete.setVisible(true);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MultipleChoiceQuestionEditUI questionEditPanel = 
                            (MultipleChoiceQuestionEditUI)
                            ((Component)e.getSource()).getParent();
					questionEditPanel.deleteClicked();
				}
			});
		}
		return btnDelete;
	}
    
    private defaultButton getIsCorrectButton(){
		if (btnIsCorrect == null) {
			btnIsCorrect = new defaultButton("Es Correcta");
			btnIsCorrect.setLocation(475, 130);
            btnIsCorrect.setVisible(true);
			btnIsCorrect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MultipleChoiceQuestionEditUI questionEditPanel = 
                            (MultipleChoiceQuestionEditUI)
                            ((Component)e.getSource()).getParent();
					questionEditPanel.isCorrectClicked();
				}
			});
		}
		return btnIsCorrect;
	}
        
    private defaultButton getIsNotCorrectButton(){
		if (btnIsNotCorrect == null) {
			btnIsNotCorrect = new defaultButton("Es Incorrecta");
			btnIsNotCorrect.setLocation(475, 170);
            btnIsNotCorrect.setVisible(true);
			btnIsNotCorrect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MultipleChoiceQuestionEditUI questionEditPanel = 
                            (MultipleChoiceQuestionEditUI)
                            ((Component)e.getSource()).getParent();
					questionEditPanel.isNotCorrectClicked();
				}
			});
		}
		return btnIsNotCorrect;
	}
    
	private String getQuestion(){
		return getQuestionTextBox().getText();
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
 } 
