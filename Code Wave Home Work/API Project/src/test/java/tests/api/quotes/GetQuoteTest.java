package tests.api.quotes;

import org.example.model.quotes.GetQuoteEndpointData;
import org.example.model.quotes.Quote;
import org.example.model.quotes.QuoteList;
import org.testng.annotations.Test;
import utils.TestDataManager;

import static org.testng.Assert.*;

public class GetQuoteTest extends BaseQuoteApiTest {

    @Test(description = "GET /quotes returns quote list")
    public void getAllQuotes() {

        QuoteList response = quoteApiClient.getAllQuotes();

        assertNotNull(response.getQuotes());
        assertFalse(response.getQuotes().isEmpty());
        assertTrue(response.getTotal() > 0);
    }

    @Test(description = "GET /quotes/{id} returns specific quote")
    public void getQuoteById() {

        GetQuoteEndpointData endpointData =
                TestDataManager.readTestDataAsObject(
                        "quotes/get-quote.json",
                        GetQuoteEndpointData.class);

        Quote quote = quoteApiClient.getQuoteById(endpointData.getId());

        assertEquals(quote.getId(), endpointData.getId());
        assertNotNull(quote.getQuote());
        assertNotNull(quote.getAuthor());
    }
}