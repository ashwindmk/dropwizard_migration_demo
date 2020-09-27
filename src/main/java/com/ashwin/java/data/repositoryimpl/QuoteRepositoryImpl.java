package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.QuotesDao;
import com.ashwin.java.domain.model.Quote;
import com.ashwin.java.domain.repository.QuoteRepository;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class QuoteRepositoryImpl implements QuoteRepository {
    @CreateSqlObject
    abstract QuotesDao quotesDao();

    @Override
    public List<Quote> getQuotes() {
        return quotesDao().getQuotes();
    }
}
