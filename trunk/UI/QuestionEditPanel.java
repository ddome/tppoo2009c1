/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
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
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class QuestionEditPanel extends JPanel {

	private defaultButton btnNewQuestion = null;
	private JComboBox cbQuestions = null;
	private JLabel lblSelectQuestion = null;
	private defaultButton btnEdit = null;
	private defaultButton btnDelete = null;
	private defaultButton btnSaveChanges = null;
	private JPanel questionPanel = null;
	
	private Questionnaire q = null;
	private List<String> questionsText =null;
	private List<Question> questions = null;
	/**
	 * This is the default constructor
	 */
	public QuestionEditPanel(Questionnaire q) {
		super();
		this.q = q;
		initialize();
	}
	
	public void DeleteQuestionClicked(){
		int confirm = JOptionPane.showConfirmDialog(this, 
									 "Seguro que desea eliminar la pregunta?", 
									 "Eliminar Preguntas",
									 JOptionPane.OK_CANCEL_OPTION,
									 JOptionPane.WARNING_MESSAGE,  
									 null);
		// Si confirmo el borrado
		if(confirm == 1){
			int index = cbQuestions.getSelectedIndex();
			//q.DeleteQuestion(questions[index]);
		}
	}
	
	public void EditQuestionClicked(){
		// Se busca la pregunta a editar en la lista
		//Question question = questions[cbQuestions.getSelectedIndex()];
		//this.add(this.getQuestionPanel(question));
	}
	
	public void NewQuestionClicked(){
		
	}
	
	public void  SaveChangesClicked(){
		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(null);
		this.setSize(650,400);
		this.add(getNewQuestionButton(), null);
		this.add(this.getQuestionsComboBox(), null);
		this.add(this.getSelectQuestionLabel());
		this.add(this.getEditButton());
		this.add(this.getDeleteButton());
		this.add(this.getSaveChangesButton());
	}
	
	private defaultButton getNewQuestionButton(){
		if(btnNewQuestion == null){
			btnNewQuestion = new defaultButton("Nueva Pregunta");
			btnNewQuestion.setLocation(20,20);
		}
		return btnNewQuestion;
	}
		
	private JComboBox getQuestionsComboBox(){
		questionsText = new LinkedList<String>();
		questions = new LinkedList<Question>();
		for(Question question: this.q.getQuestionList(Question.LEVEL_EASY)){
			if(question!= null){
				this.questionsText.add(question.getQuestion());	
				this.questions.add(question);
			}
		}
		
		String[] questionArray = new String[questionsText.size()];
		questionArray = questionsText.toArray(questionArray);
		this.cbQuestions = new JComboBox(questionArray);
		this.cbQuestions.setBounds(20, 80, 575, 25);
		this.cbQuestions.setVisible(true);
		return this.cbQuestions;
	}
	
	private JLabel getSelectQuestionLabel(){
		lblSelectQuestion = new JLabel();
		lblSelectQuestion.setText("Seleccione la pregunta a editar o borrar");
		lblSelectQuestion.setBounds(20, 50, 500, 25);
		return lblSelectQuestion;
	}
	
	private defaultButton getEditButton() {
		if (btnEdit == null) {
			btnEdit = new defaultButton("Editar");
			btnEdit.setLocation(160, 20);
			btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionEditPanel editPanel = (QuestionEditPanel)((Component)e.getSource()).getParent();
				editPanel.EditQuestionClicked();
			}
		});
		}
		return btnEdit;
	}
	
	private defaultButton getDeleteButton() {
		if (btnDelete == null) {
			btnDelete = new defaultButton("Borrar");
			btnDelete.setLocation(300, 20);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionEditPanel editPanel = (QuestionEditPanel)((Component)e.getSource()).getParent();
					editPanel.DeleteQuestionClicked();
				}
			});
		}
		return btnDelete;
	}	
	
	private defaultButton getSaveChangesButton() {
		if (btnSaveChanges == null) {
			btnSaveChanges = new defaultButton("Guardar");
			btnSaveChanges.setLocation(440, 20);
			btnSaveChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuestionEditPanel editPanel = (QuestionEditPanel)((Component)e.getSource()).getParent();
					editPanel.SaveChangesClicked();
				}
			});
			btnSaveChanges.setEnabled(false);
		}
		return btnSaveChanges;
	}
	
	private JPanel getQuestionPanel(){
		questionPanel = getSpecificQuestionPanel();
		questionPanel.setLocation(0,115);

		return (JPanel)questionPanel;
	}
	
	private JPanel getSpecificQuestionPanel(){
		JPanel panel = new JPanel();
		return panel;
	}
}
