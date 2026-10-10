package org.example.clients;

import org.example.constants.Endpoint;
import org.example.model.quotes.Quote;
import org.example.model.quotes.QuoteList;
import org.example.specifications.quotes.QuoteSpecifications;

import static io.restassured.RestAssured.given;

public class QuoteApiClient {

    public QuoteList getAllQuotes() {

        return given()
                .spec(QuoteSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.QUOTES)
                .then()
                .spec(QuoteSpecifications.okResponseSpec())
                .extract()
                .as(QuoteList.class);
    }

    public Quote getQuoteById(int id) {

        return given()
                .spec(QuoteSpecifications.baseRequestSpec())
                .pathParam("id", id)
                .when()
                .get(Endpoint.QUOTE_BY_ID)
                .then()
                .spec(QuoteSpecifications.okResponseSpec())
                .extract()
                .as(Quote.class);
    }

    public Quote getRandomQuote() {

        return given()
                .spec(QuoteSpecifications.baseRequestSpec())
                .when()
                .get(Endpoint.RANDOM_QUOTE)
                .then()
                .spec(QuoteSpecifications.okResponseSpec())
                .extract()
                .as(Quote.class);
    }
}