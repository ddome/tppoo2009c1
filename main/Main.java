package main;

import questions.*;

import java.io.*;

import javax.swing.JFrame;
import fileHandler.*;
import UI.*;

/**
 * Tipo de pregunta con respuesta verdadero o falso.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class Main {

        public static void main( String[] args) throws Exception,FileParserException{
                try{
                		File questions,ranking;
                		
                		questions = new File("data/questions.txt");
                		ranking = new File("data/ranking");
                		
                		if(!questions.exists() )
                			questions.createNewFile();
                		if(!ranking.exists() )
                			ranking.createNewFile();
                		
            			Questionnaire q = new Questionnaire(questions, ranking);      

                        mdiParent mainWindow = new mdiParent(q);
                        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        mainWindow.setVisible(true);

                }
                catch(Exception ex){
                        System.out.println(ex.getMessage());
                }
                                
        }
                
}
