package com.ashwin.java.data.mapper;

import com.ashwin.java.domain.model.Quote;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteMapper implements ResultSetMapper<Quote> {
    private static final String ID = "id";
    private static final String QUOTE = "quote";

    @Override
    public Quote map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Quote quote = new Quote();
        quote.setQuote(resultSet.getString(QUOTE));
        quote.setId(resultSet.getInt(ID));
        return quote;
    }
}
