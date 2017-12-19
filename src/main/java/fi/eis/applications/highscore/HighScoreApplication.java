package fi.eis.applications.highscore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
@PropertySource("classpath:/application.properties")
@Slf4j
public class HighScoreApplication {
    @Bean
    public static PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource getRemoteConnection() {
        if (System.getProperty("RDS_HOSTNAME") != null) {
            try {
                String driverClassName = "org.postgresql.Driver";
                String dbName = System.getProperty("RDS_DB_NAME");
                String userName = System.getProperty("RDS_USERNAME");
                String password = System.getProperty("RDS_PASSWORD");
                String hostname = System.getProperty("RDS_HOSTNAME");
                String port = System.getProperty("RDS_PORT");
                String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                Class.forName(driverClassName);
                log.trace("Getting remote connection with connection string from environment variables.");
                return DataSourceBuilder
                        .create()
                        .username(userName)
                        .password(password)
                        .url(jdbcUrl)
                        .driverClassName(driverClassName)
                        .build();
            } catch (ClassNotFoundException e) {
                log.error(e.toString());
            }
        } else {
            log.error("RDS environment properties not defined");
        }
        return null;
    }

    public static void main(String args[]) {
        SpringApplication.run(HighScoreApplication.class, args);
    }
}

