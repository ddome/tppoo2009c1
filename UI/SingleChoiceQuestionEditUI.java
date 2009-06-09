package UI;

import javax.swing.*;
import java.util.*;
import questions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class SingleChoiceQuestionEditUI extends JPanel {

	private javax.swing.JPanel jContentPane = null;
	private JTextField txtQuestion = null;
	private defaultButton btnAdd = null;
    private defaultButton btnDelete = null;
    private defaultButton btnIsCorrect = null;
    private JLabel lblAnswer = null;
    private JLabel lblLevel = null;
    private JLabel lblScore = null;
    private JComboBox cmbLevels = null;
    private JTextField txtScore = null;
    
    
    private JList liChoices = null;
    private List<String> choicesList =null;
	private JScrollPane choicesListScrollPane= null;
    private DefaultListModel elements = null;    
    
    private Question question = null;
	private Boolean isNewQuestion;
    
	/**
	 * Constructor para alta
	 */
	public SingleChoiceQuestionEditUI() {
		super();
		isNewQuestion = true;
		initialize();
	}
	/**
	 * Constructor para edicion
	 */
	public SingleChoiceQuestionEditUI(Question question) {
		super();
		isNewQuestion = false;
		this.question = question;
		initialize();
	}
	
	//public Question getFinalQuestion(){
		/*SimpleTextQuestion newQuestion;
		newQuestion = new SimpleTextQuestion(getQuestion(), getAnswer(), 1, 1);
		return (Question)newQuestion;*/
	//}
    
    public void addClicked(){
        String newOption;
        newOption = JOptionPane.showInputDialog(this,
                "Ingrese la nueva opcion", 
                "Nueva opcion");
        if(newOption.length() > 0){
            choicesList.add(newOption);
            elements.addElement(newOption);
            
        }
    }

    public void deleteClicked(){
        int index = liChoices.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una opcion a eliminar");
        }
        else{
            choicesList.remove(index);
            elements.remove(index);
        }        
    }
        
    public void isCorrectClicked(){
        int index = liChoices.getSelectedIndex();
        if(index == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una opcion");
        }
        else{
            lblAnswer.setText(choicesList.get(index));
        }   
    }
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(650, 350);
		this.setLayout(null);
        this.elements = new DefaultListModel();
		this.add(getQuestionTextBox(), null);
		this.add(this.getChoicesList(), null);
        this.add(this.getChoicesListScroll(liChoices));
        this.add(this.getAddButton(), null);
        this.add(this.getDeleteButton(), null);
        this.add(this.getIsCorrectButton(), null);
        this.add(this.getAnswerLabel());
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
    
	private JList getChoicesList(){
        if(liChoices == null){
            choicesList = new LinkedList<String>();
            
            if(!isNewQuestion){
                String[] choices=((SingleChoiceQuestion)question).getChoices(); 
                for(String choice: choices){
                    choicesList.add(choice);
                    elements.addElement(choice);
                }
            }
            liChoices = new JList(elements);
            liChoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            liChoices.setBounds(19, 50, 400, 120);
            
        }
        return liChoices;
    }
    
	private JScrollPane getChoicesListScroll(JList list){
		choicesListScrollPane = new JScrollPane(list);
		choicesListScrollPane.setBounds(19, 50, 400, 120);
		return choicesListScrollPane;
	}
    
    private defaultButton getAddButton(){
		if (btnAdd == null) {
			btnAdd = new defaultButton("Agregar");
			btnAdd.setLocation(430, 50);
            btnAdd.setVisible(true);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SingleChoiceQuestionEditUI questionEditPanel = (SingleChoiceQuestionEditUI)((Component)e.getSource()).getParent();
					questionEditPanel.addClicked();
				}
			});
		}
		return btnAdd;
	}
        
    private defaultButton getDeleteButton(){
		if (btnDelete == null) {
			btnDelete = new defaultButton("Quitar");
			btnDelete.setLocation(430, 90);
            btnDelete.setVisible(true);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SingleChoiceQuestionEditUI questionEditPanel = (SingleChoiceQuestionEditUI)((Component)e.getSource()).getParent();
					questionEditPanel.deleteClicked();
				}
			});
		}
		return btnDelete;
	}
                
    private defaultButton getIsCorrectButton(){
		if (btnIsCorrect == null) {
			btnIsCorrect = new defaultButton("Es Correcta");
			btnIsCorrect.setLocation(430, 130);
            btnIsCorrect.setVisible(true);
			btnIsCorrect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SingleChoiceQuestionEditUI questionEditPanel = (SingleChoiceQuestionEditUI)((Component)e.getSource()).getParent();
					questionEditPanel.isCorrectClicked();
				}
			});
		}
		return btnIsCorrect;
	}
                 
    private JLabel getAnswerLabel(){
        if(lblAnswer == null){
            lblAnswer = new JLabel();
            lblAnswer.setBounds(19, 180, 600, 25);
            if(!isNewQuestion){
                lblAnswer.setText("Correcta: "+ ((SingleChoiceQuestion)question).getAnswer());
            }
        }
        return lblAnswer;
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
    
	
/*	private String getAnswer(){
		return getAnswerTextBox().getText();
	}*/
 } 
