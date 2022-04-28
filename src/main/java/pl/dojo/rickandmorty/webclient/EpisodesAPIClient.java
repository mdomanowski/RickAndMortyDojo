package pl.dojo.rickandmorty.webclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.dojo.rickandmorty.model.RickAndMorty;
import pl.dojo.rickandmorty.model.dto.Character.Character;

public class EpisodesAPIClient {

    private final static String RICK_MORTY_API_URL = "https://rickandmortyapi.com/api/episode?page={id}";
    private RestTemplate restTemplate = new RestTemplate();

    public RickAndMorty getPageableRickAndMortyEntity(Object id) {
        var entity = restTemplate.getForEntity(RICK_MORTY_API_URL, RickAndMorty.class, id);
        return entity.getBody();
    }

    public Character getCharacter(String characterUrl) {
        var entity =  restTemplate.getForEntity(characterUrl, Character.class);
        return entity.getBody();
    }

}
