import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author Arslan Sapashev
 * Created on 30.05.2016.
 */
public class CountWordsTest {
    @Test
    public void whenTextPassedShouldReturnNumberOfWords(){
        String text = " Miss Money Penny ";
        CountWords c = new CountWords(text);

        Assert.assertThat(c.countWords(),is(3));
    }

    @Test
    public void whenEmptyTextPassedShouldReturnZero(){
        String text = "";
        CountWords c = new CountWords(text);
        Assert.assertThat(c.countWords(), is(0));
    }

    @Test
    public void whenJustWhitespacePassedShouldReturnZero(){
        String text = " ";
        CountWords c = new CountWords(text);
        Assert.assertThat(c.countWords(), is(0));
    }

    @Test
    public void whenTextPassedShouldReturnNumberOfWhitespaces(){
        String text = " Miss Money Penny  ";
        CountWords c = new CountWords(text);

        Assert.assertThat(c.countWhitespaces(), is(5));
    }
}
