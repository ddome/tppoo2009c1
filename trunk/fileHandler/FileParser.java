package fileHandler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import questions.*;

/**
 * Tipo de pregunta con respuesta verdadero o falso.
 * @author Grupo 4 de Programacion Orientada a Objetos
 *
 */

public class FileParser{

	private BufferedReader fileBuffer;
	/**
	 * Crea una instancia de FileParser.
	 * @param Archivo que se desea parsear, de tipo File.
	 * @throws FileParserException Error al abrir el archivo.
	 */
	public FileParser(File file)throws FileParserException{
		try{
			fileBuffer = new BufferedReader(new FileReader(file));
		}catch(IOException e){
			throw new FileParserException("Error al intentar abrir el archivo: "+e.getMessage());
		}
	}
	/**
	 * Cierra el archivo abierto al crear la instancia de FileParser.
	 * @throws FileParserException Error al cerrar el archivo.
	 */	
	public void close()throws FileParserException{
		try{
			fileBuffer.close();
		}catch( IOException e){
			throw new FileParserException("El archivo no pudo cerrarse correctamente " + e.getMessage());
		}
	}
	
	/**
	 * Crea una instancia de FileParser.
	 * @return Retorna una lista con las preguntas leidas del archivo.
	 * @throw FileParserException Error al procesar el archivo. Posiblemente este
	 * mal formado.
	 */
	public ArrayList<Question> readQuestions() throws FileParserException{
		String line,question=null;
		Scanner scanner;
		ArrayList<Question> QuestionList= new ArrayList<Question>();
		ArrayList<String> options = new ArrayList<String>();
		ArrayList<String> answers = new ArrayList<String>();
		int questionType,i=0,score=0,level=0,infoLine=0,correctAnswers=1,posibleAnswers=1;
		
		try{
			for(; (line=ReadLine())!=null;infoLine=0,options.clear(),answers.clear()){
				scanner = new Scanner(line);
				questionType=scanner.nextInt();
				if(scanner.hasNext())
					throw new FileParserException("Archivo de preguntas mal formado.");
				scanner.close();
				while( infoLine<8 && (line=ReadLine())!=null ){
					scanner = new Scanner(line);
					switch(infoLine){
						case 0:	level=scanner.nextInt();
								break;
						case 1:	posibleAnswers=scanner.nextInt();
								if(posibleAnswers < 1)
									throw new FileParserException("Archivo de preguntas mal formado.");
								break;
						case 2:	correctAnswers=scanner.nextInt();
								if(correctAnswers < 1)
									throw new FileParserException("Archivo de preguntas mal formado.");
								break;
						case 3:	question=line.trim();
								break;
						case 4: options.add(line.trim());
								for(i=1;i<posibleAnswers ;i++){
									options.add(ReadLine().trim());
								}
								break;
						case 5:	line=line.trim();
								if(!options.contains(line))
									throw new FileParserException("Archivo de preguntas mal formado.");
								answers.add(line);
								for(i=1;i<correctAnswers;i++){
									line=ReadLine().trim();
									if(!options.contains(line))
										throw new FileParserException("Archivo de preguntas mal formado.");
									answers.add(line);
								}
								break;
						case 6: score=scanner.nextInt();
								break;
						case 7:	if(!line.equals("####"))
									throw new FileParserException("Archivo de preguntas mal formado.");
								break;
						default:
								throw new FileParserException("Archivo de preguntas mal formado.");
					}
					if((infoLine==0 || infoLine==1 || infoLine==2 || infoLine==6) && scanner.hasNext()){
						throw new FileParserException("Archivo de preguntas mal formado.");
					}
					scanner.close();
					infoLine++;
				}
				if(infoLine==8 || (infoLine==7 && line==null) )
					QuestionList.add(BuildQuestion(questionType,question,options,answers,level,score));
				else
					throw new FileParserException("Archivo de preguntas mal formado.");
			}
		}catch(Exception e){
			throw new FileParserException("Archivo mal formado");
		}
		return QuestionList;
	}
	
	private String ReadLine()throws Exception{
		String line;
		while((line=fileBuffer.readLine())!=null && line.trim().length()==0)
			;
			
		if(line==null)
			return null;
		else
			return line;
	}
	
	private Question BuildQuestion(int questionType,String question,List<String> options,List<String> answer,int level,int score)throws Exception{
		Question questionRet=null;
		
		switch(questionType){
			case 1: questionRet=BuildSimpleTextQuestion(question,options,answer,level,score);
				break;
			case 2: questionRet=BuildSimpleNumberQuestion(question,options,answer,level,score);
				break;
			case 3: questionRet=BuildSingleChoiceQuestion(question,options,answer,level,score);
				break;
			case 4: questionRet=BuildMultipleChoiceQuestion(question,options,answer,level,score);
				break;
			case 5: questionRet=BuildBooleanQuestion(question,options,answer,level,score);
				break;
			default:
				throw new FileParserException("Archivo de preguntas mal formado.");
		}
		
		return questionRet;
	}
	
	private Question BuildSimpleTextQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		if( answer.size()!=1 || options.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		return new SimpleTextQuestion(question,answer.get(0),level,score);
	}
	
	private Question BuildSimpleNumberQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		if( answer.size()!=1 || options.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		return new SimpleNumberQuestion(question,Double.valueOf(answer.get(0)),level,score);
	}
	
	private Question BuildSingleChoiceQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		String[] optionsAux;
		int answerIndex;
		
		if( options.size()<=1 || answer.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		optionsAux = new String[options.size()];
		optionsAux=options.toArray(optionsAux);
		
		return new SingleChoiceQuestion(question,optionsAux,answer.get(0),level,score);
	}
	
	private Question BuildMultipleChoiceQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		String[] optionsAux;
		String[] answersAux;
		int size=answer.size(),i;
		Integer[] answerIndexes = new Integer[size];
		
		if( options.size()<=1 || answer.size()<1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		for(i=0;i<size;i++){
			answerIndexes[i]=options.indexOf(answer.get(i));
		}
		
		optionsAux = new String[options.size()];
		optionsAux = options.toArray(optionsAux);
		
		answersAux = new String[answer.size()];
		answersAux = answer.toArray(answersAux);
		return new MultipleChoiceQuestion(question,optionsAux,answersAux,level,score);
	}
	
	private Question BuildBooleanQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{

		boolean boolAnswer=false;
		if( options.size()!=2 || answer.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		if( !options.get(0).toUpperCase().equals("VERDADERO") && !options.get(1).toUpperCase().equals("VERDADERO") )
			throw new FileParserException("Archivo mal formado");
		
		if( !options.get(0).toUpperCase().equals("FALSO") && !options.get(1).toUpperCase().equals("FALSO") )
			throw new FileParserException("Archivo mal formado");
		
		if(answer.get(0).toUpperCase().equals("VERDADERO"))
			boolAnswer=true;
		
		return new BooleanQuestion(question,boolAnswer,level,score);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
