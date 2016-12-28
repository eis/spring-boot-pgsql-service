package fi.eis.applications.highscore.test;

import java.util.Date;

import fi.eis.applications.highscore.vo.HighScoreEntryVO;

public class HighScoreEntryVOFactory {
    public static HighScoreEntryVO testEntryNoDate() {
        HighScoreEntryVO entry = new HighScoreEntryVO();
        entry.setScore(500l);
        entry.setAuthor("Jesus");
        return entry;
    }
    public static HighScoreEntryVO testEntry() {
        HighScoreEntryVO entry = new HighScoreEntryVO();
        entry.setScore(500l);
        entry.setAuthor("Jesus");
        entry.setDate(new Date());
        return entry;
    }
}
