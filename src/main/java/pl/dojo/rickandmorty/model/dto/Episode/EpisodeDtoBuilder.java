package pl.dojo.rickandmorty.model.dto.Episode;

import pl.dojo.rickandmorty.model.dto.Character.CharacterDto;

import java.util.ArrayList;
import java.util.List;

public class EpisodeDtoBuilder {
    String episodeNumber;
    String episodeTitle;
    String dateOfAir;
    /*List<CharacterDto>*/
    List<CharacterDto> characters = new ArrayList<>();

    private EpisodeDtoBuilder() {
    }

    public static EpisodeDtoBuilder anEpisodeDto() {
        return new EpisodeDtoBuilder();
    }

    public EpisodeDtoBuilder withEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
        return this;
    }

    public EpisodeDtoBuilder withEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
        return this;
    }

    public EpisodeDtoBuilder withDateOfAir(String dateOfAir) {
        this.dateOfAir = dateOfAir;
        return this;
    }
    public EpisodeDtoBuilder withCharacters(/*List<CharacterDto>*/ List<CharacterDto> characters) {
        this.characters = characters;
        return this;
    }

    public EpisodeDto build() {
        EpisodeDto episodeDto = new EpisodeDto();
        episodeDto.setEpisodeNumber(episodeNumber);
        episodeDto.setEpisodeTitle(episodeTitle);
        episodeDto.setDateOfAir(dateOfAir);
        episodeDto.setCharacters(characters);
        return episodeDto;
    }
}
