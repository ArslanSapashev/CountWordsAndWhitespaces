import org.apache.log4j.Logger;

/**
 * @author Arslan Sapashev
 * Created on 30.05.2016.
 */

public class SimpleCountWords {
    private static final Logger LOG = Logger.getLogger(SimpleCountWords.class.toString());

    public static void main (String[] args) {
        final String text = " Miss Money Penny ";
        final Countable countWords = new CountWordsFreeOfBlock(text);
        LOG.info("Program has begun the job");
        new SimpleCountWords().start(countWords);
        LOG.info("Program terminated");
        System.exit(0);
    }

    /**
     * 1) Implements two Runnable objects to be associated with different threads.
     * 2) Creates two threads
     * 3) Starts new threads
     * 4) Joins main thread to new threads
     * @param countWords - object (of Countable type) to implement count logic.
     */
    public void start(final Countable countWords){

        //Implements count of words in source text and prints the result count of words.
        Runnable r1 = new Runnable() {
            public void run () {
                System.out.printf("number of words is %d. Method has been invoked by %s\n",
                        countWords.countWords(),
                        Thread.currentThread().getName());
            }
        };

         //Implements count of whitespaces in source text and prints the result count of whitespaces.
        Runnable r2 = new Runnable() {
            public void run () {
                System.out.printf("number of whitespaces is %d. Method has been invoked by %s\n",
                        countWords.countWhitespaces(),
                        Thread.currentThread().getName());
            }
        };

        Thread thread1 = new Thread(r1, "Thread WORDS");
        Thread thread2 = new Thread(r2, "Thread WHITESPACES");

        // Starts threads and join main thread to them
        try {
            thread1.start();
            thread2.start();
            thread2.join(1000);
            thread1.join(1000);
        } catch (InterruptedException ex){
            LOG.error(Thread.currentThread().getName() + " interrupted");
        }
    }
}
