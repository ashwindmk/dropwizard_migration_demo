package com.ashwin.java.api.resource;

import com.ashwin.java.domain.repository.QuoteRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/quote")
public class QuoteResource {
    private QuoteRepository quoteRepository;

    @Inject
    public QuoteResource(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response quote() {
        return Response.ok(quoteRepository.getQuotes()).build();
    }
}
