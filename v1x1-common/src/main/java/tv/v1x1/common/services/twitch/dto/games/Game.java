package tv.v1x1.common.services.twitch.dto.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import tv.v1x1.common.services.twitch.dto.misc.Image;

/**
 * Created by cobi on 10/30/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
    @JsonProperty
    private String name;
    @JsonProperty
    private Image box;
    @JsonProperty
    private Image logo;
    @JsonProperty("_id")
    private long id;
    @JsonProperty("giantbomb_id")
    private long giantBombId;
    @JsonProperty
    private long popularity;

    public Game() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Image getBox() {
        return box;
    }

    public void setBox(final Image box) {
        this.box = box;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(final Image logo) {
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getGiantBombId() {
        return giantBombId;
    }

    public void setGiantBombId(final long giantBombId) {
        this.giantBombId = giantBombId;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(final long popularity) {
        this.popularity = popularity;
    }
}
