package pl.dojo.rickandmorty.model.dto.Character;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacterDto {
    private String characterName;
    private String characterImgUrl;
}
