package ui;

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

	private defaultButton btnCancel = null;
	private defaultButton btnSaveChanges = null;
	private JPanel questionPanel = null;

    private Boolean isNewQuestion;    
    private Question question = null;
    private Questionnaire q = null;
	
	/**
	 * Constructor para nueva pregunta
	 */
	public QuestionDetailEditPanel(Questionnaire q){
		super();
		this.isNewQuestion = true;
        this.q = q;
		initialize();
	}
	
	/**
	 * Constructor para edicion de pregunta
	 * Recibe la pregunta a editar
	 */
	public QuestionDetailEditPanel(Questionnaire q, Question question) {
		super();
		this.question = question;
        this.q = q;
		this.isNewQuestion = false;
		initialize();
	}
	
	public void  SaveChangesClicked(){
        Window parent = SwingUtilities.getWindowAncestor((Component)this);
        QuestionEditPanel editPanel;
        editPanel = new QuestionEditPanel(q);       
//Guardar pregunta
        ((mdiParent)parent).addFrame(editPanel, "Editar Preguntas");
	}
	
	public void CancelClicked(){
		Window parent = SwingUtilities.getWindowAncestor((Component)this);
        QuestionEditPanel editPanel;
        editPanel = new QuestionEditPanel(q);       

        ((mdiParent)parent).addFrame(editPanel, "Editar Preguntas");
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(null);
		this.setSize(650,400);
		this.add(this.getCancelButton(), null);
		this.add(this.getSaveChangesButton(), null);
        if(isNewQuestion){
            
        }
        else{
            this.add(this.getQuestionPanel(), null);
        }
		
	}
	
	private defaultButton getSaveChangesButton() {
		if (btnSaveChanges == null) {
			btnSaveChanges = new defaultButton("Guardar");
			btnSaveChanges.setLocation(480, 320);
            btnSaveChanges.setVisible(true);
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
			btnCancel.setLocation(330, 320);
            btnCancel.setVisible(true);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionDetailEditPanel editPanel = (QuestionDetailEditPanel)((Component)e.getSource()).getParent();
					editPanel.CancelClicked();
				}
			});
		}
		return btnCancel;
	}
	
	private JPanel getQuestionPanel(){
		if(question instanceof SimpleTextQuestion){
			questionPanel = new SimpleTextQuestionEditUI(question);
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
