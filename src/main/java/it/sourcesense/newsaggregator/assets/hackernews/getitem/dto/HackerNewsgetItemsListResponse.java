package it.sourcesense.newsaggregator.assets.hackernews.getitem.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HackerNewsgetItemsListResponse implements Serializable{
	
	private static final long serialVersionUID = 4110545423664435921L;
	
	@JsonProperty("hackersNewsList")
    private List<HackerNewsgetItemResponse> list = null;
	
	@JsonProperty("hackersNewsList")
    public List<HackerNewsgetItemResponse>  getList() {
        return list;
    }

    @JsonProperty("hackersNewsList")
    public void setList(List<HackerNewsgetItemResponse> list) {
        this.list = list;
    }

}
