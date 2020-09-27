package com.ashwin.java.data.source;


import com.ashwin.java.data.mapper.QuoteMapper;
import com.ashwin.java.domain.model.Quote;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(QuoteMapper.class)
public interface QuotesDao {
    @SqlQuery("select * from quotes;")
    public List<Quote> getQuotes();
}
