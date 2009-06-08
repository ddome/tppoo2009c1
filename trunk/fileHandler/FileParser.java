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

public class FileParser{

	private BufferedReader fileBuffer;
	
	public FileParser(File file)throws Exception{
		try{
			fileBuffer = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e){
			throw new FileParserException("Error al intentar abrir el archivo: "+e.getMessage());
		}
	}
	
	public void close()throws Exception{
		try{
			fileBuffer.close();
		}catch( IOException e){
			throw new FileParserException("El archivo no pudo cerrarse correctamente " + e.getMessage());
		}
	}
	
	public ArrayList<Question> readQuestions() throws Exception{
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
									throw new FileParserException("3- Archivo de preguntas mal formado.");
								break;
						case 2:	correctAnswers=scanner.nextInt();
								if(correctAnswers < 1)
									throw new FileParserException("4- Archivo de preguntas mal formado.");
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
									throw new FileParserException("5- Archivo de preguntas mal formado.");
								answers.add(line);
								for(i=1;i<correctAnswers;i++){
									line=ReadLine().trim();
									if(!options.contains(line))
										throw new FileParserException("6- Archivo de preguntas mal formado.");
									answers.add(line);
								}
								break;
						case 6: score=scanner.nextInt();
								break;
						case 7:	if(!line.equals("####"))
									throw new FileParserException("8- Archivo de preguntas mal formado.");
								break;
						default:
								throw new FileParserException("9- Archivo de preguntas mal formado.");
					}
					if((infoLine==0 || infoLine==1 || infoLine==2 || infoLine==6) && scanner.hasNext()){
						throw new FileParserException("55- Archivo de preguntas mal formado.");
					}
					scanner.close();
					infoLine++;
				}
					QuestionList.add(BuildQuestion(questionType,question,options,answers,level,score));
			}
		}catch(Exception e){
			throw new FileParserException("Archivo mal formado: " + e.getMessage());
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
				throw new FileParserException("11- Archivo de preguntas mal formado.");
		}
		
		return questionRet;
	}
	
	private Question BuildSimpleTextQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		if( answer.size()!=1 || options.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("12- Archivo de preguntas mal formado.");
		return new SimpleTextQuestion(question,answer.get(0),level,score);
	}
	
	private Question BuildSimpleNumberQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		if( answer.size()!=1 || options.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("13- Archivo de preguntas mal formado.");
		
		return new SimpleNumberQuestion(question,Double.valueOf(answer.get(0)),level,score);
	}
	
	private Question BuildSingleChoiceQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		String[] optionsAux;
		int answerIndex;
		
		if( options.size()<=1 || answer.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		answerIndex=options.indexOf(answer.get(0));
		optionsAux = new String[options.size()];
		optionsAux=options.toArray(optionsAux);
		
		return new SingleChoiceQuestion(question,optionsAux,answerIndex,level,score);
	}
	
	private Question BuildMultipleChoiceQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{
		String[] optionsAux;
		int size=answer.size(),i;
		Integer[] answerIndexes = new Integer[size];
		
		if( options.size()<=1 || answer.size()<=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("Archivo de preguntas mal formado.");
		
		for(i=0;i<size;i++){
			answerIndexes[i]=options.indexOf(answer.get(i));
		}
		
		optionsAux = new String[options.size()];
		optionsAux=options.toArray(optionsAux);
		return new MultipleChoiceQuestion(question,optionsAux,answerIndexes,level,score);
	}
	
	private Question BuildBooleanQuestion(String question,List<String> options,List<String> answer,int level,int score) throws Exception{

		boolean boolAnswer=false;
		if( options.size()!=2 || answer.size()!=1 || score < 0 || level < 0 || level > 2 )
			throw new FileParserException("14- Archivo de preguntas mal formado.");
		
		if(answer.get(0).toUpperCase().equals("VERDADERO"))
			boolAnswer=true;
		
		return new BooleanQuestion(question,boolAnswer,level,score);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
