import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class WordList{

  public static final String WORDS_DIRECTORY = "word_lists";
  private File wordList;
  private int reqLen;

  public WordList(File pWordList){
    wordList = pWordList;
    try{
      Scanner scan = new Scanner(wordList);
      reqLen = scan.nextLine().length();
      scan.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }
  public String getWord(){
    String word = "";
    int lineNum = (int)(Math.random()*getNumOfWords());
    try{
      Scanner scan = new Scanner(wordList);
      for(int i = 0; i<=lineNum; i++){
        if(i==lineNum){
          word = scan.nextLine();
        }else{
          scan.nextLine();
        }
      }
      scan.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();  
    }
    return word;
  }

  public boolean isValidInput(String input){
    boolean valid = false;
    try{
      Scanner scan = new Scanner(wordList);
      if(scan.findAll(input).count()>=1 && input.length() == reqLen){
        valid = true;
      }
      scan.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();  
    }
    return valid;
  }

  public int getNumOfWords(){
    try{
      int numLines = (int)Files.lines(wordList.toPath()).count(); 
      return numLines;
   }catch(IOException e){
     e.printStackTrace();
   }
   return -1;
  }

  public File getFile(){
    return wordList;
  }

}
