package Quiz;
import java.util.List; 

public class MultipleChoiceQuestion extends ChoiceQuestion<Integer[]> {

	private List<Integer> answers;
	
	public MultipleChoiceQuestion(String question,String choices[],int answers[], int level, int id){
		super(question,choices,level,id);
		
		for( Integer answer: answers ) {
			//Verifico que cada respuesta este dentro de las opciones disponibles
			if( answer < choices.length )
				this.answers.add(new Integer(answer));
		}		
	}
	
	public void addAnswer(int answer){
		if( answer < choices.length )
			this.answers.add(new Integer(answer));
	}
		
	public boolean isCorrect(Integer answers[]){
		
		boolean ret = true;
		
		for( Integer answer: answers ) {
			if( !this.answers.contains(answer) ){
				ret = false;
				break;
			}		
		}
		
		return ret;
	}
}
