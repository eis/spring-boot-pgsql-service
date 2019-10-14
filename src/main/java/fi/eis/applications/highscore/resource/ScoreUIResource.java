package fi.eis.applications.highscore.resource;

import fi.eis.applications.highscore.dao.HighScoreDAO;
import fi.eis.applications.highscore.vo.HighScoreEntryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class ScoreUIResource {
    @Autowired
    private HighScoreDAO scoreDao;

    private static final Pageable sortLimitCriteria =
            new PageRequest(0, 20, Sort.Direction.DESC, "score");

    @GetMapping("/")
    public ModelAndView showIndexPage(Map<String,Object> model) {
        List<HighScoreEntryVO> entries = scoreDao.findAll(sortLimitCriteria).getContent();

        // we misuse 'id' field to show the rank of an item here. don't do this.
        AtomicLong rank = new AtomicLong(1);
        entries.forEach(entryVO -> entryVO.setId(rank.getAndIncrement()));

        model.put("entries", entries);
        return new ModelAndView("index", model);
    }
}
