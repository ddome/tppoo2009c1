package UI;

import javax.swing.*;

import questions.*;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * @author Carlos
 */
public class QuestionDetailEditPanel extends JPanel {

	private Boolean isNewQuestion;
	private defaultButton btnCancel = null;
	private defaultButton btnSaveChanges = null;
	private Question question = null;
	private JPanel questionPanel = null;
	
	/**
	 * Constructor para nueva pregunta
	 */
	public QuestionDetailEditPanel(){
		super();
		this.isNewQuestion = true;
		initialize();
	}
	
	/**
	 * Constructor para edicion de pregunta
	 * Recibe la pregunta a editar
	 */
	public QuestionDetailEditPanel(Question question) {
		super();
		this.question = question;
		this.isNewQuestion = false;
		initialize();
	}
	
	public void  SaveChangesClicked(){
		
	}
	
	public void CancelClicked(){
		
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(null);
		this.setSize(650,400);
		this.add(this.getCancelButton());
		this.add(this.getSaveChangesButton());
		//this.add() obtener panel pregunta
	}
	
	private defaultButton getSaveChangesButton() {
		if (btnSaveChanges == null) {
			btnSaveChanges = new defaultButton("Guardar");
			btnSaveChanges.setLocation(500, 380);
			btnSaveChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionDetailEditPanel editPanel = (QuestionDetailEditPanel)((Component)e.getSource()).getParent();
					editPanel.SaveChangesClicked();
				}
			});
		}
		return btnSaveChanges;
	}
	
	private defaultButton getCancelButton(){
		if (btnCancel == null) {
			btnCancel = new defaultButton("Cancelar");
			btnCancel.setLocation(350, 380);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionDetailEditPanel editPanel = (QuestionDetailEditPanel)((Component)e.getSource()).getParent();
					editPanel.SaveChangesClicked();
				}
			});
		}
		return btnCancel;
	}
	
	private JPanel getQuestionPanel(){
		if(question instanceof SimpleTextQuestion){
			//questionPanel = new SimpleTextQuestionEditUI(question);
		}
		if(question instanceof SimpleNumberQuestion){
			//questionPanel = new SimpleNumberQuestionEditUI(question);
		}
		if(question instanceof BooleanQuestion){
			//questionPanel = new BooleanQuestionEditUI(question);
		}
		if(question instanceof SingleChoiceQuestion){
			//questionPanel = new SingleChoiceQuestionEditUI(question);
		}
		if(question instanceof MultipleChoiceQuestion){
			//questionPanel = new MultipleChoiceQuestionEditUI(question);
		}
		return questionPanel;
	}
}
