package pl.dojo.rickandmorty.model.dto.Season;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeasonEpisodeCountDto {
    private String seasonNumber;
    private String episodesCount;
}
