package it.sourcesense.newsaggregator.utils;

public class MainConstants {
	
// Service related	
public static final String NYTIMES_SERVICE_URL = "https://api.nytimes.com/svc/topstories/v2/technology.json?api-key=96f8d418ea904f1e88eb1b1c5fe7439f";
public static final String HACKERNEWS_SERVICE_lIST_URL = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
public static final String HACKERNEWS_SERVICE_SINGLE_ITEM_PREFIX = "https://hacker-news.firebaseio.com/v0/item/";
public static final String HACKERNEWS_SERVICE_SINGLE_ITEM_POSTFIX = ".json?print=pretty";

//Errors related
public static final String GENERIC_APPLICATION_ERROR = "GENERIC_APPLICATION_ERROR";
public static final String INVALID_SOURCE = "INVALID_SOURCE";

}
