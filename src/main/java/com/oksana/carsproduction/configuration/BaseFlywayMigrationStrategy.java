package com.oksana.carsproduction.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j // => sout
//@Configuration
public class BaseFlywayMigrationStrategy /*implements FlywayMigrationStrategy */{

//    @Override
//    public void migrate(Flyway flyway) {
//        log.info("Start migrate cars production database");
//
//        flyway.setSchemas("public");
//        flyway.setTable("schema_version_core");
//        flyway.setLocations("classpath:db/migration");
//        flyway.migrate();
//    }
}
