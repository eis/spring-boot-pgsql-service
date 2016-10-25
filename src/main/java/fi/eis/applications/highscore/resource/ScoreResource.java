package fi.eis.applications.highscore.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.eis.applications.highscore.dao.HighScoreDAO;
import fi.eis.applications.highscore.vo.HighScoreEntryVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(produces = ScoreResource.APPLICATION_JSON_CHARSET_UTF_8)
public class ScoreResource {
    @Autowired
    private HighScoreDAO scoreDao;

    public static final String APPLICATION_JSON_CHARSET_UTF_8 =
            "application/json;charset=utf-8";

    private static final String APPLICATION_JSON = "application/json";

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
            consumes = {APPLICATION_JSON})
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
