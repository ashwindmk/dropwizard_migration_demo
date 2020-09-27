# Dropwizard Migrations Demo

Based on liquibase, dropwizard-migrations plugin helps handle DB and table alters.

https://www.dropwizard.io/en/latest/manual/migrations.html

### Execute Migration
```
java -jar target/dropwizard-migration-demo-0.0.1.jar db migrate config.yml
```

It created 2 new tables to maintain the migration changelogs:
1. DATABASECHANGELOG
2. DATABASECHANGELOGLOCK

### Rollback

Specify number of changesets to rollback.
```
java -jar target/dropwizard-migration-demo-0.0.1.jar db rollback config.yml --count 1
```
