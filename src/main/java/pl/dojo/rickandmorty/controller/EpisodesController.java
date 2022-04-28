package pl.dojo.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.dojo.rickandmorty.model.dto.Season.SeasonDto;
import pl.dojo.rickandmorty.model.dto.Season.SeasonEpisodeCountDto;
import pl.dojo.rickandmorty.service.ApiService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class EpisodesController {
    private final ApiService episodesService;

    @GetMapping("/seasons")
    public List<SeasonEpisodeCountDto> getSeasonsAndEpisodeCount() {
        return episodesService.getAllSeasons();
    }

    @GetMapping("/seasons/{number}")
    public SeasonDto getSeason(@PathVariable String number) {
        return episodesService.getSeason(number);
    }
}
