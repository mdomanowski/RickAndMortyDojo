package pl.dojo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.dojo.rickandmorty.model.Result;
import pl.dojo.rickandmorty.model.RickAndMorty;
import pl.dojo.rickandmorty.model.dto.Character.Character;
import pl.dojo.rickandmorty.model.dto.Character.CharacterDto;
import pl.dojo.rickandmorty.model.dto.Character.CharacterDtoBuilder;
import pl.dojo.rickandmorty.model.dto.Episode.EpisodeDtoBuilder;
import pl.dojo.rickandmorty.model.dto.Season.SeasonDto;
import pl.dojo.rickandmorty.model.dto.Season.SeasonEpisodeCountDto;
import pl.dojo.rickandmorty.webclient.EpisodesAPIClient;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final EpisodesAPIClient apiClient = new EpisodesAPIClient();
    public static final Logger LOGGER = LoggerFactory.getLogger(ApiService.class);


    public List<SeasonEpisodeCountDto> getAllSeasons() {
        RickAndMorty body = apiClient.getPageableRickAndMortyEntity(1);
        Integer pageCount = body.getInfo().getPages();
        List<Result> results = body.getResults();

        List<SeasonEpisodeCountDto> seasonEpisodeCountDtos = new ArrayList<>();

        for (int i = 2; i <= pageCount; i++) {
            String id = String.valueOf(i);
            RickAndMorty rickAndMortyBody = apiClient.getPageableRickAndMortyEntity(id);
            results.addAll(Objects.requireNonNull(rickAndMortyBody).getResults());
        }

        Map<String, String[]> e = results.stream()
                .map(result -> result.getEpisode().split("E"))
                .collect(Collectors.toMap(strings -> strings[0], Function.identity(),
                        (existing, replacement) -> replacement));

        for (Map.Entry<String, String[]> stringEntry : e.entrySet()) {
            seasonEpisodeCountDtos.add(new SeasonEpisodeCountDto(
                    stringEntry.getKey(),
                    stringEntry.getValue()[1]
            ));
        }


        return seasonEpisodeCountDtos.stream()
                .sorted(Comparator.comparing(SeasonEpisodeCountDto::getSeasonNumber))
                .collect(Collectors.toList());
    }


    public SeasonDto getSeason(String seasonNumber) {
        RickAndMorty rickAndMortyBody = apiClient.getPageableRickAndMortyEntity(1);
        Integer pageCount = rickAndMortyBody.getInfo().getPages();
        List<Result> allEpisodes = Objects.requireNonNull(rickAndMortyBody).getResults();

        SeasonDto seasonDto = new SeasonDto(seasonNumber);

        for (int i = 2; i <= pageCount; i++) {
            String id = String.valueOf(i);
            RickAndMorty response = apiClient.getPageableRickAndMortyEntity(id);
            allEpisodes.addAll(Objects.requireNonNull(response).getResults());
        }

        for (Result result : allEpisodes) {
            String[] seasonAndEpisodeNumber = result.getEpisode().split("E");
            String season = seasonAndEpisodeNumber[0];

            if (seasonNumber.equals(season)) {
                LOGGER.info(season);
                List<CharacterDto> characterDtos = new ArrayList<>();
                for (String character : result.getCharacters()) {
                    Character characterBody = apiClient.getCharacter(character);

                    assert characterBody != null;
                    var dto = CharacterDtoBuilder.aCharacterDto()
                            .withCharacterName(characterBody.getName())
                            .withCharacterImgUrl(characterBody.getImage())
                            .build();
                    characterDtos.add(dto);
                }
                var dto = EpisodeDtoBuilder.anEpisodeDto()
                        .withEpisodeNumber(seasonAndEpisodeNumber[1])
                        .withEpisodeTitle(result.getName())
                        .withDateOfAir(result.getAirDate())
                        .withCharacters(characterDtos)
                        .build();
                LOGGER.info("dto: " + dto);
                seasonDto.addEpisode(dto);
            }
        }
        return seasonDto;
    }
}
