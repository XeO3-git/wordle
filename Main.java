import java.io.File;
import java.util.Scanner;

//TODO automatically scan a directory, wordlists, for text files. when the program is run, ask what list the word should be taken from
public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    WordList wordList = getWordList(scan);
    SecretWord word = new SecretWord(wordList);
    System.out.println("you have " + word.getGuesses() + " guesses begin!");

    while (word.canGuess()){
      String input = scan.nextLine();
      System.out.println("> " + word.getHint(input));
      System.out.println("you have " + word.getGuesses() + " guesses remaining");
    }
    System.out.println("the word was " + word.getWord());
    scan.close();
  }
  private static WordList getWordList(Scanner scan){
    boolean badList = true;
    WordList endList = null;
    do{
      System.out.println("the installed word lists are: ");
      for(File list : getLists()){
        System.out.println(list.getName());
      }    
      System.out.println("please type what word list you would like to use \n");
      String input = scan.nextLine();
      for(File list : getLists()){
        if(list.getName().equals(input)){
          badList = false;
          endList = new WordList(list);
        }
      }
    }while(badList);
   
    return endList;
  }
  private static File[] getLists(){
    File listDir = new File(WordList.WORDS_DIRECTORY);
    File[] files = listDir.listFiles();
    return files;
  }

}
