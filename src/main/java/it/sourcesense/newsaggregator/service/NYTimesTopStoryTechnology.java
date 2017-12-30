package it.sourcesense.newsaggregator.service;

import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfoList;
import it.sourcesense.newsaggregator.assets.nytimestopstories.dto.NyTimesTopStoriesResponse;

public interface NYTimesTopStoryTechnology {
	NyTimesTopStoriesResponse getNewsJson() throws Exception;
	NewsInfoList getUnifiedFormatResponse (NyTimesTopStoriesResponse originalResponse) throws Exception;


}
