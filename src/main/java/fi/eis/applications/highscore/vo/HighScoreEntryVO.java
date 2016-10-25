package fi.eis.applications.highscore.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fi.eis.applications.highscore.util.DateISO8601Serializer;
import lombok.Data;

@Data
@Entity
@Table(name="score")
public class HighScoreEntryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private Long score;
    @Column
    @NotNull
    private String author;
    @JsonSerialize(using = DateISO8601Serializer.class)
    @Column(name="date_str")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;
}
