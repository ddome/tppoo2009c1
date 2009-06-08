import questions.*;

import java.io.*;

import javax.swing.JFrame;
import fileHandler.*;
import UI.*;
public class prueba {

	public static void main( String[] args) throws Exception,FileParserException{
		try{
			Questionnaire q = new Questionnaire(new File("/Users/damian/Desktop/hola"), null);	
			
			mdiParent mainWindow = new mdiParent(q);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setVisible(true);

		}
		catch(Exception ex){
			
		}
				
	}
		
}
