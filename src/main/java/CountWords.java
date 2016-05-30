/**
 * Class allows to calculate count of words and whitespaces of specified text.
 * Calculations could be done in parallel by two threads.
 * For synchronization purposes both of the methods use synchronized blocks.
 * @author Arslan Sapashev
 * Created on 30.05.2016.
 */
public final class CountWords implements Countable {
    private final String text;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public CountWords(String text){
        this.text = text;
    }

    /**
     * Calculates count of words in specified text
     * Method could be invoked concurrently, by acquiring intrinsic lock of the object lock1.
     * @return - number of words that text contains.
     */
    public final int countWords(){
        synchronized (lock1){
            final String[] words = text.trim().split(" ");
            return (words.length == 1 && words[0].equals(""))? 0 : words.length;
        }
    }

    /**
     * Calculates count of whitespaces in specified text
     * Method could be invoked concurrently, by acquiring intrinsic lock of object lock2.     *
     * @return - number of whitespaces that text contains.
     */
    public final int countWhitespaces(){
        synchronized (lock2){
            int counter = 0;
            for(char c : text.toCharArray()){
                if(c == ' '){
                    counter++;
                }
            }
            return counter;
        }
    }
}
