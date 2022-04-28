package pl.dojo.rickandmorty.model.dto.Character;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "url"
})
@Generated("jsonschema2pojo")
@ToString
@Getter
@Setter
public class Location {
    private String name;
    private String url;
}
