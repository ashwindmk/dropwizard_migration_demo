package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.Quote;

import java.util.List;

public interface QuoteRepository {
    public List<Quote> getQuotes();
}
