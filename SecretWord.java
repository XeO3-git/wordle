import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Files;

public class SecretWord{
  private int guesses;
  private WordList wordList;
  private String word;

  private static final String WHITE = "\u001B[37m";
  private static final String GREEN = "\u001B[32m";
  private static final String YELLOW = "\u001B[33m"; 

  
  public SecretWord(WordList pWordList){
    wordList = pWordList;
    word = wordList.getWord();
    guesses = word.length();
  }
  public String getWord(){
    return word;
  }
  public String getHint(String input){
    input = input.toLowerCase();
    String hint = "";
    if(!(wordList.isValidInput(input))){
      return "invalid input try again";
    }
    if(guesses <= 0){
      return "out of guesses!";
    }
    if(input.equals(word)){
      guesses = 0;
      return "you won!";
    }
    for(int i = 0; i<this.word.length(); i++){
      char inputCharAt = input.charAt(i);
      char wordCharAt = word.charAt(i);

      if(inputCharAt == wordCharAt){
        hint = hint + GREEN + inputCharAt;
      }else if (word.contains(""+inputCharAt)){
        hint = hint + YELLOW + inputCharAt;
      }else{
        hint = hint + WHITE + inputCharAt;
      }
    }
    guesses --;
    return hint + WHITE;
  }

  public boolean canGuess(){
    return guesses >0;
  }
  public int getGuesses(){
    return guesses;
  }
}
