package main;

import questions.*;

import java.io.*;

import javax.swing.JFrame;
import fileHandler.*;
import UI.*;

public class prueba {

        public static void main( String[] args) throws Exception,FileParserException{
                try{
                		File preguntas,ranking;
                		preguntas = new File("/Users/damian/Desktop/preguntas");
                		ranking = new File("/Users/damian/Desktop/ranking");
                		if(!preguntas.exists() )
                			preguntas.createNewFile();
                		if(!ranking.exists() )
                			ranking.createNewFile();
                		Questionnaire q = new Questionnaire(preguntas, ranking);      
                        
                        mdiParent mainWindow = new mdiParent(q);
                        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        mainWindow.setVisible(true);

                }
                catch(Exception ex){
                        System.out.println(ex.getMessage());
                }
                                
        }
                
}
