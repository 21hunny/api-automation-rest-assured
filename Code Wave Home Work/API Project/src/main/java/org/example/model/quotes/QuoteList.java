package org.example.model.quotes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuoteList {

    private List<Quote> quotes;
    private int total;
    private int skip;
    private int limit;
}