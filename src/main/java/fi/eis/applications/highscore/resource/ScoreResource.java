package fi.eis.applications.highscore.resource;

import fi.eis.applications.highscore.dao.HighScoreDAO;
import fi.eis.applications.highscore.vo.HighScoreEntryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScoreResource {
    @Autowired
    private HighScoreDAO scoreDao;

    private static final Pageable sortLimitCriteria =
            new PageRequest(0, 20, Sort.Direction.DESC, "score");

    @RequestMapping(value = "/highscore",
            method = RequestMethod.GET)
    @ResponseBody
    public Iterable<HighScoreEntryVO> getScores() {
        return scoreDao.findAll(sortLimitCriteria);
    }
    
    @RequestMapping(value = "/highscore",
            method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public HighScoreEntryVO createEntry(
            @RequestBody @Valid HighScoreEntryVO entry) {
        log.info("We're saving " + entry);
        return scoreDao.save(entry);
    }

    @RequestMapping(value = "/highscore/clear",
            method = RequestMethod.POST)
    @ResponseBody
    public Iterable<HighScoreEntryVO> clear() {
        scoreDao.deleteAll();
        return scoreDao.findAll();
    }

}
