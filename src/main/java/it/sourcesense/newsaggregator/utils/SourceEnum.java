package it.sourcesense.newsaggregator.utils;

public enum SourceEnum {
	
	HACKER_NEWS_TOP_STORIES("HACKER_NEWS_TOP_STORIES"),
	NYTIMES_TOP_STORIES_TECHNOLOGY("NYTIMES_TOP_STORIES_TECHNOLOGY"),
	COMBINED_SOURCES("");
	
	private String source;
	
	public String getSource() {
		return source;
	}
	
	SourceEnum(String source) {
		this.source=source;
	}

}
