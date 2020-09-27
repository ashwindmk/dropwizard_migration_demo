package com.ashwin.java.api.di;

import com.ashwin.java.api.resource.PingResource;
import com.ashwin.java.api.resource.QuoteResource;
import com.ashwin.java.data.repositoryimpl.QuoteRepositoryImpl;
import com.ashwin.java.domain.repository.QuoteRepository;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.skife.jdbi.v2.DBI;

import javax.inject.Singleton;

public class MigrationDemoModules extends AbstractBinder {
    private DBI dbi;

    public MigrationDemoModules(DBI dbi) {
        this.dbi = dbi;
    }

    @Override
    protected void configure() {
        // Repositories
        bind(dbi.onDemand(QuoteRepositoryImpl.class)).to(QuoteRepository.class);

        // Resources
        bind(PingResource.class).to(PingResource.class).in(Singleton.class);
        bind(QuoteResource.class).to(QuoteResource.class).in(Singleton.class);
    }
}
