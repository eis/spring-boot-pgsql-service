package fi.eis.applications.highscore.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fi.eis.applications.highscore.vo.HighScoreEntryVO;

@Repository
public interface HighScoreDAO
    extends PagingAndSortingRepository<HighScoreEntryVO, Long> {

}