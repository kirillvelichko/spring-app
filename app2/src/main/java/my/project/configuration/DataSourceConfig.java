package my.project.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final PostgreSQLContainer<?> postgresContainer;

    static {
        postgresContainer = new PostgreSQLContainer<>("postgres:11.4")
                .withDatabaseName("database")
                .withUsername("username")
                .withPassword("password");
        postgresContainer.start();
    }

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(postgresContainer.getJdbcUrl())
                .username(postgresContainer.getUsername())
                .password(postgresContainer.getPassword())
                .driverClassName(postgresContainer.getDriverClassName())
                .build();
    }
}