package pl.dojo.rickandmorty.model.dto.Season;

import pl.dojo.rickandmorty.model.dto.Episode.EpisodeDto;

import java.util.ArrayList;
import java.util.List;

public class SeasonDto {
    private String seasonNumber;
    private List<EpisodeDto> episodes;

    public SeasonDto(String seasonNumber) {
        this.seasonNumber = seasonNumber;
        this.episodes = new ArrayList<>();
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public List<EpisodeDto> getEpisodes() {
        return episodes;
    }

    public void addEpisode(EpisodeDto episode) {
        this.episodes.add(episode);
    }
}
