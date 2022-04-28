package pl.dojo.rickandmorty.model.dto.Character;

public class CharacterDtoBuilder {
    private String characterName;
    private String characterImgUrl;

    private CharacterDtoBuilder() {
    }

    public static CharacterDtoBuilder aCharacterDto() {
        return new CharacterDtoBuilder();
    }

    public CharacterDtoBuilder withCharacterName(String characterName) {
        this.characterName = characterName;
        return this;
    }

    public CharacterDtoBuilder withCharacterImgUrl(String characterImgUrl) {
        this.characterImgUrl = characterImgUrl;
        return this;
    }

    public CharacterDto build() {
        CharacterDto characterDto = new CharacterDto();
        characterDto.setCharacterName(characterName);
        characterDto.setCharacterImgUrl(characterImgUrl);
        return characterDto;
    }
}
