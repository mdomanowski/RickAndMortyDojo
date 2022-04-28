package pl.dojo.rickandmorty.model.dto.Character;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "status",
        "species",
        "type",
        "gender",
        "origin",
        "location",
        "image",
        "episode",
        "url",
        "created"

})
@Generated("jsonschema2pojo")
@ToString
@Getter
@Setter
public class Character {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    String status;
    @JsonProperty("species")
    String species;
    @JsonProperty("type")
    String type;
    @JsonProperty("gender")
    String gender;
    @JsonProperty("origin")
    Location origin;
    @JsonProperty("location")
    Location location;
    @JsonProperty("image")
    String image;
    @JsonProperty("episode")
    List<String> episode;
    @JsonProperty("url")
    String url;
    @JsonProperty("created")
    String created;
}
