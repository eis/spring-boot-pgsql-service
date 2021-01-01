package fi.eis.applications.highscore.dao;

import fi.eis.applications.highscore.test.HighScoreEntryVOFactory;
import fi.eis.applications.highscore.vo.HighScoreEntryVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HighScoreDAOTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HighScoreDAO highScoreDao;

    @Test
    public void confirmConstraintChecking() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            entityManager.persist(HighScoreEntryVOFactory.testEntryNoDate());
            highScoreDao.findAll().iterator().next();
        });
    }

    @Test
    public void confirmReturnEntry() throws Exception {
        entityManager.persist(HighScoreEntryVOFactory.testEntry());
        HighScoreEntryVO entry = highScoreDao.findAll().iterator().next();
        assertThat(entry.getAuthor()).isEqualTo("Jesus");
    }
}
