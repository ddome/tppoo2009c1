
package ui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import questions.*;

public class QuestionParentPanel extends JPanel {
	private defaultButton btnNext = null;
	private JPanel questionPanel = null;
	private Quiz quiz = null;
	private Question actualQuestion = null;
	/**
	 * This is the default constructor
	 */
	public QuestionParentPanel(Quiz quiz) {
		super();
		this.quiz = quiz;
		initialize();
	}
	
	public void SetNextQuestion() throws Exception{
		if(this.questionPanel instanceof BooleanQuestionUI){
			this.quiz.answerActualQuestion(((BooleanQuestionUI)this.questionPanel).getAnswer());
		}
		else if(this.questionPanel instanceof SimpleTextQuestionUI){
			this.quiz.answerActualQuestion(((SimpleTextQuestionUI)this.questionPanel).getAnswer());
		}
		else if(this.questionPanel instanceof SimpleNumberQuestionUI){
			this.quiz.answerActualQuestion(((SimpleNumberQuestionUI)this.questionPanel).getAnswer());
		}
		else if(this.questionPanel instanceof SingleChoiceQuestionUI){
			this.quiz.answerActualQuestion(((SingleChoiceQuestionUI)this.questionPanel).getAnswer());
		}
		else if(this.questionPanel instanceof MultipleChoiceQuestionUI){
			this.quiz.answerActualQuestion(((MultipleChoiceQuestionUI)this.questionPanel).getAnswer());
		}
		else{
			return;
		}

		if(this.quiz.questionExists()){
			this.actualQuestion = this.quiz.getActualQuestion();
			
			this.remove(this.questionPanel);
			this.repaint();
			this.questionPanel = this.getQuestionPanel();
			this.add(this.questionPanel, null);
			//this.
		}

	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(650,400);
		this.setLayout(null);
		this.add(getNextButton(), null);
		this.add(getQuestionPanel(), null);
	}
	
	private defaultButton getNextButton(){
		if(btnNext == null){
			btnNext = new defaultButton("Continuar");
			btnNext.setLocation(480,320);
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionParentPanel parentPanel = (QuestionParentPanel)((Component)e.getSource()).getParent();
					try{
						parentPanel.SetNextQuestion();	
					}
					catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					
				}
			});
		}		
		return btnNext;
	}
	
	private JPanel getQuestionPanel(){
		
		if(actualQuestion == null){
			actualQuestion = quiz.getActualQuestion();
		}
		questionPanel = getSpecificQuestionPanel();
		questionPanel.setLocation(0,0);
		
		return (JPanel)questionPanel;
	}
	
	private JPanel getSpecificQuestionPanel(){
		JPanel specPanel = null;
		if(actualQuestion instanceof SimpleTextQuestion){
			specPanel = new SimpleTextQuestionUI(this.quiz);
		}
		if(actualQuestion instanceof SimpleNumberQuestion){
			specPanel = new SimpleNumberQuestionUI(this.quiz);
		}
		if(actualQuestion instanceof BooleanQuestion){
			specPanel = new BooleanQuestionUI(this.quiz);
		}
		if(actualQuestion instanceof SingleChoiceQuestion){
			specPanel = new SingleChoiceQuestionUI(this.quiz);
		}
		if(actualQuestion instanceof MultipleChoiceQuestion){
			specPanel = new MultipleChoiceQuestionUI(this.quiz);
		}
		return specPanel;
	}
	
}
