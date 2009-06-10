package questions;

import player.*;

import java.io.File;

/**
 * Clase que maneja un juego de diez preguntas.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */

public class Quiz {
	
	private Question quiz[];
	private int index;
	private int score;
	private boolean answers[];
	private Game game;
	Ranking ranking;
		
	/**
	 * Crea una nueva instancia.
	 * @param user El usuario que esta jugando, utilizado para grabar su puntaje en caso de ser maximo
	 * @param level El nivel de dificultad del juego
	 * @param q Las diez preguntas del juego
	 * @param rankingFile El archivo con los maximos puntajes
	 * @throws RankingFileException Error al abrir el archivo de puntajes
	 * @throws Exception 
	 */
	public Quiz(String user,int level,Question q[],File rankingFile)throws RankingFileException,Exception {
		index = 0;
		score = 0;
		quiz = q;
		answers = new boolean[quiz.length];
		ranking = new Ranking(rankingFile);
		game = new Game(user,level);
	}
	
	/**
	 * Retorna la pregunta actual a responder.
	 * @return La pregunta actual a responder
	 */
	public Question getActualQuestion() {
		if( index < quiz.length )
			return quiz[index];
		else
			return null;
	}
	
	/**
	 * Metodo utilizado para itererar por la lista de preguntas. Al responder, la pregunta actual
	 * pasa a la siguiente en la lista. Acumula el puntaje en caso de responder bien y lo salva en caso 
	 * de haber respondido la ultima pregunta de la lista.
	 * @param answer La respuesta a la pregunta actual
	 * @throws RankingFileException Error al abrir el archivo de puntajes
	 * @throws Exception
	 */
	public void answerActualQuestion(Object answer)throws RankingFileException,Exception {
		
		if( index < quiz.length ) {
			if( quiz[index].isCorrect(answer) ) {
				score+=quiz[index].getScore();
				answers[index] = true;
			}
			else
				answers[index] = false;
				
			index++;	
			if( index == quiz.length  ) {
				game.setScore(score);
				ranking.saveScore(game);
			}
		}		
	}
	
	/**
	 * Devuelve un arreglo de tipo String con todas las preguntas utilizadas durante
	 * un juego.
	 * @return La lista de preguntas utilizada
	 */
	public String[] getQuestions() {	
		String q[]  = new String[quiz.length];
		
		for(int i=0;i<quiz.length;i++ ) {
			q[i] = quiz[i].getQuestion();
		}		
		return q;
	}
	
	/**
	 * Pregunta si hay mas preguntas en la lista.
	 * @return Verdadero si hay mas preguntas en la lista, falso caso contrario
	 */
	public boolean questionExists() {
		return (index < quiz.length);
	}
	
	/** 
	 * Retorna una arreglo de tipo boolean con true si la respuesta correspondiente
	 * a ese indice fue contestada correctamente, false en caso contrario.
	 * @return La lista que indica que preguntas fuero bien respondidas
	 */
	public boolean[] getAnswers() {			
	
		return answers;
	}
	
	/**
	 * Reinicia el juego, comenzando a preguntar desde la primer pregunta de la lista nuevamente.
	 */
	public void restart() {
		index = 0;
		score = 0;
	}
	
	/**
	 * Devuelve cual es el score total acumulado.
	 * @return El puntaje acumulado
	 */
	public int getScore() {
		return score;
	}
	
	
}

