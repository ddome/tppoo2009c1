package main;

import questions.*;

import java.io.*;

import javax.swing.JFrame;
import fileHandler.*;
import UI.*;

public class Main {

        public static void main( String[] args) throws Exception,FileParserException{
                try{
                		File questions,ranking;
                		
                		java.io.File currentDir = new java.io.File("");
                		System.out.println(currentDir.getAbsolutePath());
                		
                		questions = new File("data/questions");
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
