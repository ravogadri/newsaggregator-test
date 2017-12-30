
package it.sourcesense.newsaggregator.assets.nytimestopstories.dto;

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
    "status",
    "copyright",
    "section",
    "last_updated",
    "num_results",
    "results"
})
public class NyTimesTopStoriesResponse implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("section")
    private String section;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("num_results")
    private Integer numResults;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1263571830046771934L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("last_updated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("last_updated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("num_results")
    public Integer getNumResults() {
        return numResults;
    }

    @JsonProperty("num_results")
    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
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
        return new ToStringBuilder(this).append("status", status).append("copyright", copyright).append("section", section).append("lastUpdated", lastUpdated).append("numResults", numResults).append("results", results).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(status).append(additionalProperties).append(numResults).append(lastUpdated).append(copyright).append(section).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NyTimesTopStoriesResponse) == false) {
            return false;
        }
        NyTimesTopStoriesResponse rhs = ((NyTimesTopStoriesResponse) other);
        return new EqualsBuilder().append(results, rhs.results).append(status, rhs.status).append(additionalProperties, rhs.additionalProperties).append(numResults, rhs.numResults).append(lastUpdated, rhs.lastUpdated).append(copyright, rhs.copyright).append(section, rhs.section).isEquals();
    }

}
