/*
 * Creado el 07/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
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
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
public class QuestionEditPanel extends JPanel {

	private defaultButton btnNewQuestion = null;
	private JList liQuestions = null;
	private JLabel lblSelectQuestion = null;
	private defaultButton btnEdit = null;
	private defaultButton btnDelete = null;
	private JScrollPane qListScrollPane= null;
    
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
	
	private Question getSelectedQuestion(){
		int selectedIndex = this.liQuestions.getSelectedIndex();
		return selectedIndex == -1 ? null: this.questions.get(selectedIndex);
	}
	
	public void DeleteQuestionClicked(){
		int selectedIndex = liQuestions.getSelectedIndex();
		/* Valido que el usuario seleccione una pregunta
		*/
		if(selectedIndex == -1){
			JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar la pregunta a eliminar.", 
                    "Eliminar Pregunta",
                    JOptionPane.OK_OPTION, 
                    null);
		}
		else{
			int confirm = JOptionPane.showConfirmDialog(this, 
					 "Seguro que desea eliminar la pregunta?", 
					 "Eliminar Preguntas",
					 JOptionPane.OK_CANCEL_OPTION,
					 JOptionPane.WARNING_MESSAGE,  
					 null);
			// Si confirmo el borrado
			if(confirm == JOptionPane.OK_OPTION){
				q.deleteQuestion(getSelectedQuestion());
                /*TODO refresh de preguntas*/
			}
		}
			

	}
	
	public void EditQuestionClicked(){
            Window parent = SwingUtilities.getWindowAncestor((Component)this);
            Question question = getSelectedQuestion();
            // Si no hay ninguna seleccionada, muestro mensaje
            if(question == null){
                JOptionPane.showMessageDialog(this, 
                        "Debe seleccionar la pregunta a editar.", 
                        "Editar Pregunta",
                        JOptionPane.OK_OPTION, 
                        null);
            }
            else{
                QuestionDetailEditPanel editPanel;
                editPanel = new QuestionDetailEditPanel(q, question);       

                ((mdiParent)parent).addFrame(editPanel, "Editar Preguntas");
        }
	}
	
	public void NewQuestionClicked(){
        Window parent = SwingUtilities.getWindowAncestor((Component)this);
        
        QuestionDetailEditPanel editPanel;
        editPanel = new QuestionDetailEditPanel(q);       

        ((mdiParent)parent).addFrame(editPanel, "Nueva Pregunta");
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
		this.add(this.getQuestionsList(), null);
		this.add(this.getSelectQuestionLabel());
		this.add(this.getEditButton());
		this.add(this.getDeleteButton());
		this.add(this.getQuestionsListScroll(liQuestions));
	}
	
	private defaultButton getNewQuestionButton(){
		if(btnNewQuestion == null){
			btnNewQuestion = new defaultButton("Nueva Pregunta");
			btnNewQuestion.setLocation(20,20);
            btnNewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionEditPanel editPanel = (QuestionEditPanel)((Component)e.getSource()).getParent();
				editPanel.NewQuestionClicked();
			}
		});
		}
		return btnNewQuestion;
	}
		
	private JList getQuestionsList(){
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
		this.liQuestions = new JList(questionArray);
		this.liQuestions.setBounds(20, 80, 575, 250);
		this.liQuestions.setVisible(true);
		return this.liQuestions;
	}
	
	private JScrollPane getQuestionsListScroll(JList list){
		qListScrollPane = new JScrollPane(list);
		qListScrollPane.setBounds(20, 80, 575, 250);
		return qListScrollPane;
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
}
