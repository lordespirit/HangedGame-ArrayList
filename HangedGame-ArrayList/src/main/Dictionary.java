package main;

import java.util.ArrayList;
import util.FileHelper;

public class Dictionary {
		
	
	private ArrayList<SecretWord> list;
	final String fileDictionary; 
	
	public Dictionary(String fileName){
		this.fileDictionary = fileName;
		loadWordsFromFile();
	}
	
	private void loadWordsFromFile(){
		String[] allWords = FileHelper.readFile(fileDictionary);
	    list = new ArrayList<SecretWord>(allWords.length);
	    
		for(String str: allWords)
			list.add(new SecretWord(str));
	}
	
	public SecretWord getNextWord(){
		
		if(list.size()==0)
			loadWordsFromFile();
		
		int randomWord = (int) (Math.random() * list.size());
		SecretWord nextWord = list.get(randomWord);
		list.remove(randomWord);
			
			return nextWord;
	}
	
	public int size(){
		return list.size();
	}
	
	public static class SecretWord{
		
		private final String word;
		private final String hint;
		
		private SecretWord(String fileLineWord){
			
			String value[] = fileLineWord.split(":");
			if(value==null || value.length!=2){
				throw new RuntimeException("Formato no se puede crear. Compruebe que el fichero no tengo caracteres raros o lineas vacias");
			}
			this.word = value[1];
			this.hint = value[0];
			
		}

		public String getWord() {
			return word;
		}

		public String getHint() {
			return hint;
		}
		
	}
	

}
