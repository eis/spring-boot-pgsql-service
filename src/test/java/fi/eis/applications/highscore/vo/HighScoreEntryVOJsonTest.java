package fi.eis.applications.highscore.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eis.applications.highscore.json.DateISO8601Serializer;
import fi.eis.applications.highscore.test.HighScoreEntryVOFactory;

@RunWith(SpringRunner.class)
@JsonTest
public class HighScoreEntryVOJsonTest {

    @Autowired
    private JacksonTester<HighScoreEntryVO> json;

    @Test
    public void serializeJson() throws Exception {
        HighScoreEntryVO entry = HighScoreEntryVOFactory.testEntry();
        String targetEntry = DateISO8601Serializer.toISO8601(entry.getDate());

        assertThat(this.json.write(entry))
            .extractingJsonPathStringValue("@.date")
            .isEqualTo(targetEntry);
    }

}