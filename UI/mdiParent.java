/*
 * Creado el 06/06/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package UI;

import javax.swing.JFrame;
import java.beans.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.awt.Window;
import questions.*;
import java.io.File;

/**
 * @author Carlos
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class mdiParent extends JFrame {

	private javax.swing.JPanel jContentPane = null;
	private JDesktopPane jDesktopPane = null;
	private defaultButton btnNewGame = null;
	private defaultButton btnHighScores = null;
	private defaultButton btnEdit = null;
	private defaultButton btnQuit = null;
	
	private Questionnaire q = null;
	private Quiz quiz = null;
	
	/**
	 * This method initializes jDesktopPane	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */    
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			jDesktopPane = new JDesktopPane();
			jDesktopPane.setLocation(190, 29);
			jDesktopPane.setSize(650, 400);
			jDesktopPane.setDesktopManager( new ImmovableDesktopManager() );  
		}
		return jDesktopPane;
	}

	private defaultButton getNewGameButton() {
		if (btnNewGame == null) {
			btnNewGame = new defaultButton("Nuevo Juego");
			btnNewGame.setText("Nuevo Juego");
			btnNewGame.setLocation(20, 40);
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String userName, option;
					int level;
					Object[] possibilities = {"Facil", "Intermedio", "Dificil"};
					// TODO ver que sea una opcion valida, (no cancel) y el nombre tenga al menos un caracter
					Window parent = SwingUtilities.getWindowAncestor((Component) e.getSource());
					option = (String)JOptionPane.showInputDialog(
					                    parent,
					                    "Ingrese la dificultad de juego",
					                    "Nuevo Juego",
					                    JOptionPane.QUESTION_MESSAGE,
					                    null,
					                    possibilities,
					                    possibilities[0]);
					level = getDifficultyCode(option);
					
					userName = (String)JOptionPane.showInputDialog(
		                    parent,
		                    "Ingrese su nombre",
		                    "Nuevo Juego",
		                    JOptionPane.QUESTION_MESSAGE,
		                    null,
		                    null,
		                    null);
					
					((mdiParent)parent).quiz = ((mdiParent)parent).q.generateQuiz(userName, level);
					
					QuestionParentPanel p = new QuestionParentPanel(((mdiParent)parent).quiz);
					p.setSize(650,400);
					addFrame(p, "Quiz!");
				}
				
				public int getDifficultyCode(String difficulty){
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
			});
		}
		return btnNewGame;
	}    
	
	private defaultButton getHighScoresButton() {
		if (btnHighScores == null) {
			btnHighScores = new defaultButton("Puntajes");
			btnHighScores.setLocation(20,90);
			btnHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HighScoresPanel p = new HighScoresPanel();
				p.setSize(650,400);
				addFrame(p, "Mejores Puntajes");
			}
		});
		}
		return btnHighScores;
	}
	
	private defaultButton getEditButton() {
		if (btnEdit == null) {
			btnEdit = new defaultButton("Editar Preguntas");
			btnEdit.setLocation(20,140);
			btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window parent = SwingUtilities.getWindowAncestor((Component) e.getSource()); 
				QuestionEditPanel p = new QuestionEditPanel(((mdiParent)parent).q);
				p.setSize(650,400);
				addFrame(p, "Preguntas");
			}
		});
		}
		return btnEdit;
	}
	
	private defaultButton getQuitButton() {
		if (btnQuit == null) {
			btnQuit = new defaultButton("Salir");
			btnQuit.setLocation(20,190);
			btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		}
		return btnQuit;
	}
	
	public void addFrame(JPanel panel, String title) {

		 try {	 
			 jDesktopPane.removeAll();
		 	JInternalFrame[] children = jDesktopPane.getAllFrames();
		 	mdiChild j = new mdiChild(panel, title);
		 	int i = 0;
		 	for(i = 0; i < children.length; i++){
		 		if(children[i].getTitle().equals(j.getTitle())){
		 			children[i].setSelected(true);
		 			return;
		 		}
		 	}

		 	jDesktopPane.add(j);
		 	j.setVisible(true);
		 	j.setSelected(true);
		} 
		catch (PropertyVetoException ex) {
		//Logger.getLogger(mainxpframe.class.getName()).log(Level.SEVERE, null, ex);
		}
	} 
	
    private static class ImmovableDesktopManager extends DefaultDesktopManager {  
         public void dragFrame( JComponent f, int x, int y ) {  
         }  
	} 
    

	/**
	 * This is the default constructor
	 */
	public mdiParent(Questionnaire q) {
		super();
		this.q = q;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(874, 484);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJDesktopPane(), null);
			jContentPane.add(getNewGameButton(), null);
			jContentPane.add(getHighScoresButton(), null);
			jContentPane.add(getEditButton(), null);
			jContentPane.add(getQuitButton(), null);
		}
		return jContentPane;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
