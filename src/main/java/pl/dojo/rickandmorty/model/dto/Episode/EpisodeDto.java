package pl.dojo.rickandmorty.model.dto.Episode;

import pl.dojo.rickandmorty.model.dto.Character.CharacterDto;

import java.util.ArrayList;
import java.util.List;

public class EpisodeDto {
    String episodeNumber;
    String episodeTitle;
    String dateOfAir;
    /*List<CharacterDto>*/
    List<CharacterDto> characters = new ArrayList<>();

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public String getDateOfAir() {
        return dateOfAir;
    }

    public void setDateOfAir(String dateOfAir) {
        this.dateOfAir = dateOfAir;
    }

    public List<CharacterDto> getCharacters() {
        return characters;
    }

    public void addCharacter(CharacterDto character) {
        this.characters.add(character);
    }

    public void setCharacters(List<CharacterDto> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "EpisodeDto{" +
                "episodeNumber='" + episodeNumber + '\'' +
                ", episodeTitle='" + episodeTitle + '\'' +
                ", dateOfAir='" + dateOfAir + '\'' +
                ", characters=" + characters +
                '}';
    }
}
