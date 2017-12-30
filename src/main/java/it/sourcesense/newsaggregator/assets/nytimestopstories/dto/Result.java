
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
    "section",
    "subsection",
    "title",
    "abstract",
    "url",
    "byline",
    "item_type",
    "updated_date",
    "created_date",
    "published_date",
    "material_type_facet",
    "kicker",
    "des_facet",
    "org_facet",
    "per_facet",
    "geo_facet",
    "multimedia",
    "short_url"
})
public class Result implements Serializable
{

    @JsonProperty("section")
    private String section;
    @JsonProperty("subsection")
    private String subsection;
    @JsonProperty("title")
    private String title;
    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("url")
    private String url;
    @JsonProperty("byline")
    private String byline;
    @JsonProperty("item_type")
    private String itemType;
    @JsonProperty("updated_date")
    private String updatedDate;
    @JsonProperty("created_date")
    private String createdDate;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonProperty("material_type_facet")
    private String materialTypeFacet;
    @JsonProperty("kicker")
    private String kicker;
    @JsonProperty("des_facet")
    private List<String> desFacet = null;
    @JsonProperty("org_facet")
    private List<String> orgFacet = null;
    @JsonProperty("per_facet")
    private List<String> perFacet = null;
    @JsonProperty("geo_facet")
    private List<Object> geoFacet = null;
    @JsonProperty("multimedia")
    private List<Multimedium> multimedia = null;
    @JsonProperty("short_url")
    private String shortUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5703334186324701275L;

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("subsection")
    public String getSubsection() {
        return subsection;
    }

    @JsonProperty("subsection")
    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("abstract")
    public String getAbstract() {
        return _abstract;
    }

    @JsonProperty("abstract")
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("byline")
    public String getByline() {
        return byline;
    }

    @JsonProperty("byline")
    public void setByline(String byline) {
        this.byline = byline;
    }

    @JsonProperty("item_type")
    public String getItemType() {
        return itemType;
    }

    @JsonProperty("item_type")
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @JsonProperty("updated_date")
    public String getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("updated_date")
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("created_date")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("published_date")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("material_type_facet")
    public String getMaterialTypeFacet() {
        return materialTypeFacet;
    }

    @JsonProperty("material_type_facet")
    public void setMaterialTypeFacet(String materialTypeFacet) {
        this.materialTypeFacet = materialTypeFacet;
    }

    @JsonProperty("kicker")
    public String getKicker() {
        return kicker;
    }

    @JsonProperty("kicker")
    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    @JsonProperty("des_facet")
    public List<String> getDesFacet() {
        return desFacet;
    }

    @JsonProperty("des_facet")
    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    @JsonProperty("org_facet")
    public List<String> getOrgFacet() {
        return orgFacet;
    }

    @JsonProperty("org_facet")
    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    @JsonProperty("per_facet")
    public List<String> getPerFacet() {
        return perFacet;
    }

    @JsonProperty("per_facet")
    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    @JsonProperty("geo_facet")
    public List<Object> getGeoFacet() {
        return geoFacet;
    }

    @JsonProperty("geo_facet")
    public void setGeoFacet(List<Object> geoFacet) {
        this.geoFacet = geoFacet;
    }

    @JsonProperty("multimedia")
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    @JsonProperty("multimedia")
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    @JsonProperty("short_url")
    public String getShortUrl() {
        return shortUrl;
    }

    @JsonProperty("short_url")
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
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
        return new ToStringBuilder(this).append("section", section).append("subsection", subsection).append("title", title).append("_abstract", _abstract).append("url", url).append("byline", byline).append("itemType", itemType).append("updatedDate", updatedDate).append("createdDate", createdDate).append("publishedDate", publishedDate).append("materialTypeFacet", materialTypeFacet).append("kicker", kicker).append("desFacet", desFacet).append("orgFacet", orgFacet).append("perFacet", perFacet).append("geoFacet", geoFacet).append("multimedia", multimedia).append("shortUrl", shortUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(perFacet).append(updatedDate).append(subsection).append(itemType).append(orgFacet).append(geoFacet).append(desFacet).append(kicker).append(url).append(section).append(title).append(multimedia).append(byline).append(additionalProperties).append(_abstract).append(shortUrl).append(publishedDate).append(createdDate).append(materialTypeFacet).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(perFacet, rhs.perFacet).append(updatedDate, rhs.updatedDate).append(subsection, rhs.subsection).append(itemType, rhs.itemType).append(orgFacet, rhs.orgFacet).append(geoFacet, rhs.geoFacet).append(desFacet, rhs.desFacet).append(kicker, rhs.kicker).append(url, rhs.url).append(section, rhs.section).append(title, rhs.title).append(multimedia, rhs.multimedia).append(byline, rhs.byline).append(additionalProperties, rhs.additionalProperties).append(_abstract, rhs._abstract).append(shortUrl, rhs.shortUrl).append(publishedDate, rhs.publishedDate).append(createdDate, rhs.createdDate).append(materialTypeFacet, rhs.materialTypeFacet).isEquals();
    }

}
