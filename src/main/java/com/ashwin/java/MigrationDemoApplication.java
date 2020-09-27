package com.ashwin.java;

import com.ashwin.java.api.di.MigrationDemoModules;
import com.ashwin.java.api.resource.PingResource;
import com.ashwin.java.api.resource.QuoteResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class MigrationDemoApplication extends Application<MigrationDemoConfiguration> {
    private static final String SQL = "sql";

    public static void main(String[] args) throws Exception {
        new MigrationDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-migration-demo";
    }

    @Override
    public void initialize(Bootstrap<MigrationDemoConfiguration> bootstrap) {
        //super.initialize(bootstrap);
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(true, false)
                )
        );

        bootstrap.addBundle(new MigrationsBundle<MigrationDemoConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(MigrationDemoConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(MigrationDemoConfiguration config, Environment env) throws Exception {
        final DataSource dataSource = config.getDataSourceFactory().build(env.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        env.jersey().getResourceConfig().register(new MigrationDemoModules(dbi));

        env.jersey().register(PingResource.class);
        env.jersey().register(QuoteResource.class);
    }
}
