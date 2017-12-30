
package it.sourcesense.newsaggregator.assets.hackernews.getitem.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "by",
    "descendants",
    "id",
    "kids",
    "score",
    "time",
    "title",
    "type",
    "url"
})
public class HackerNewsgetItemResponse implements Serializable
{

    @JsonProperty("by")
    private String by;
    @JsonProperty("descendants")
    private Integer descendants;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("kids")
    private List<Integer> kids = null;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6534727031032202312L;

    @JsonProperty("by")
    public String getBy() {
        return by;
    }

    @JsonProperty("by")
    public void setBy(String by) {
        this.by = by;
    }

    @JsonProperty("descendants")
    public Integer getDescendants() {
        return descendants;
    }

    @JsonProperty("descendants")
    public void setDescendants(Integer descendants) {
        this.descendants = descendants;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("kids")
    public List<Integer> getKids() {
        return kids;
    }

    @JsonProperty("kids")
    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("by", by).append("descendants", descendants).append("id", id).append("kids", kids).append("score", score).append("time", time).append("title", title).append("type", type).append("url", url).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(title).append(time).append(additionalProperties).append(score).append(descendants).append(by).append(kids).append(type).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HackerNewsgetItemResponse) == false) {
            return false;
        }
        HackerNewsgetItemResponse rhs = ((HackerNewsgetItemResponse) other);
        return new EqualsBuilder().append(id, rhs.id).append(title, rhs.title).append(time, rhs.time).append(additionalProperties, rhs.additionalProperties).append(score, rhs.score).append(descendants, rhs.descendants).append(by, rhs.by).append(kids, rhs.kids).append(type, rhs.type).append(url, rhs.url).isEquals();
    }

}
