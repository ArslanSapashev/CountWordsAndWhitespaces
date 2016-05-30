import java.util.Random;

/**
 * @author Arslan Sapashev
 * Class allows to calculate count of words and whitespaces of specified text,
 * without explicit synchronization, due to the persistancy of source text and calculations local to methods.
 * Created on 30.05.2016.
 */
public class CountWordsFreeOfBlock implements Countable {
    private final String text;

    public CountWordsFreeOfBlock(String text){
        this.text = text;
    }

    /**
     * Calculates count of words in specified text
     * Method could be invoked concurrently without explicit thread synchronization,
     * due to the persistancy of source text and calculations local to methods.
     * @return - number of words that text contains.
     */
    public final int countWords(){
            final String[] words = text.trim().split(" ");
            return (words.length == 1 && words[0].equals(""))? 0 : words.length;
    }

    /**
     * Calculates count of whitespaces in specified text
     * Method could be invoked concurrently without explicit thread synchronization,
     * due to the persistancy of source text and calculations local to methods.
     * @return - number of whitespaces that text contains.
     */
    public final int countWhitespaces(){
            int counter = 0;
            for(char c : text.toCharArray()){
                if(c == ' '){
                    counter++;
                }
            }
            return counter;
    }
}
