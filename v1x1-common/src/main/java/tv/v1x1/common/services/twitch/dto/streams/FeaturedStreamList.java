package tv.v1x1.common.services.twitch.dto.streams;

import com.fasterxml.jackson.annotation.JsonProperty;
import tv.v1x1.common.services.twitch.dto.streams.FeaturedStream;

import java.util.List;

/**
 * Created by cobi on 10/30/2016.
 */
public class FeaturedStreamList {
    @JsonProperty
    private List<FeaturedStream> featured;

    public FeaturedStreamList() {
    }

    public List<FeaturedStream> getFeatured() {
        return featured;
    }

    public void setFeatured(final List<FeaturedStream> featured) {
        this.featured = featured;
    }
}