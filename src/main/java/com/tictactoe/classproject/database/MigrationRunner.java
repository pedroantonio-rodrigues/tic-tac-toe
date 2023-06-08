package com.tictactoe.classproject.database;

import org.flywaydb.core.Flyway;

public class MigrationRunner {

    public void runMigration(){
        Flyway flyway = Flyway.configure()
                .dataSource("/test", "sa", "123")
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }
}
