package fi.eis.applications.highscore.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eis.applications.highscore.test.HighScoreEntryVOFactory;
import fi.eis.applications.highscore.vo.HighScoreEntryVO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HighScoreDAOTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HighScoreDAO highScoreDao;

    @Test(expected = ConstraintViolationException.class)
    public void confirmConstraintChecking() throws Exception {
        entityManager.persist(HighScoreEntryVOFactory.testEntryNoDate());
        highScoreDao.findAll().iterator().next();
    }
    @Test
    public void confirmReturnEntry() throws Exception {
        entityManager.persist(HighScoreEntryVOFactory.testEntry());
        HighScoreEntryVO entry = highScoreDao.findAll().iterator().next();
        assertThat(entry.getAuthor()).isEqualTo("Jesus");
    }
}
