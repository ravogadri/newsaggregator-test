package it.sourcesense.newsaggregator.service;

import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfoList;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemsListResponse;

public interface HackerNewsTopStories {
	HackerNewsgetItemsListResponse getNewsJson() throws Exception;
	NewsInfoList getUnifiedFormatResponse (HackerNewsgetItemsListResponse originalResponse);

}
