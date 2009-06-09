package questions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*; 

/**
 * Tipo de pregunta de varias opciones con multiples respuestas.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */
public class MultipleChoiceQuestion extends ChoiceQuestion{

	private HashSet<String> answers = new HashSet<String>();
		
	/**
	 * Devuelve una instancia nueva.
	 * @param question La pregunta a responder
	 * @param choices Las opciones posibles
	 * @param answers Las respuestas a la pregunta
	 * @param level El nivel de dificultad
	 * @param score El puntaje de la pregunta
	 */
	public MultipleChoiceQuestion(String question,String choices[],String answers[], int level, int score){
		super(question,choices,level,score);
		
		for( String answer: answers) {	
			this.addAnswer(answer);
		}		
	}
	
	/**
	 * 
	 * @param answer Nueva respuesta
	 */
	public void addAnswer(String answer){
		if( super.choices.contains(answer)  )
			this.answers.add(answer);	
	}
	
	@Override
	public boolean isCorrect(Object answers) {
		if( answers instanceof String[] )
			return isCorrect((String[])answers);
		else
			return false;
	}
	
	public boolean isCorrect(String answers[]){
		
		boolean ret = true;
		
		for( String answer: answers ) {
			if( !this.answers.contains(answer) ){
				ret = false;
				break;
			}		
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @return Las respuestas de la pregunta
	 */
	public String[] getAnswers(){
		
		String aux[] = new String[(answers.size())];	
		aux = answers.toArray(aux);
		
		return aux;
	}
	
	/**
	 * Guarda la pregunta en forma de texto en un archivo
	 * @param outFile El archivo a ser escrito
	 * @throws IOException Error al escribir la pregunta
	 */
	public void WriteToFile(BufferedWriter outFile) throws IOException{
		int i;
		String[] choices = this.getChoices();
		String[] answers = this.getAnswers();
		outFile.write("4");
		outFile.newLine();
		outFile.write(Integer.valueOf(this.getLevel()).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(choices.length).toString());
		outFile.newLine();
		outFile.write(Integer.valueOf(answers.length).toString());
		outFile.newLine();
		outFile.write(this.getQuestion());
		outFile.newLine();
		for(i=0;i<choices.length;i++){
			outFile.write(choices[i]);
			outFile.newLine();
		}
		for(i=0;i<answers.length;i++){
			outFile.write(answers[i]);
			outFile.newLine();
		}
		outFile.write(Integer.valueOf(this.getScore()).toString());
		outFile.newLine();
	}
}
