package fi.eis.applications.highscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HighScoreApplication {
    public static void main(String args[]) {
        SpringApplication.run(HighScoreApplication.class, args);
    }
}
