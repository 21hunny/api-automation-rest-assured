package tests.api.quotes;

import org.example.model.quotes.Quote;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RandomQuoteTest extends BaseQuoteApiTest {

    @Test(description = "GET /quotes/random returns random quote")
    public void getRandomQuote() {

        Quote quote = quoteApiClient.getRandomQuote();

        assertTrue(quote.getId() > 0);
        assertNotNull(quote.getQuote());
        assertNotNull(quote.getAuthor());
    }
}