package it.sourcesense.newsaggregator.service.impl;

import java.util.Collections;
import java.util.List;

import javax.enterprise.inject.Default;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;

import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfo;
import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfoList;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemResponse;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemsListResponse;
import it.sourcesense.newsaggregator.service.HackerNewsTopStories;
import it.sourcesense.newsaggregator.utils.DateUtils;
import it.sourcesense.newsaggregator.utils.HackerNewsClients;
import it.sourcesense.newsaggregator.utils.MainConstants;


@Default
public class HackerNewsTopStoriesImpl implements HackerNewsTopStories {
	
	protected static Logger logger = Logger
			.getLogger("HackerNewsTopStoriesImpl");
	
	
	public HackerNewsTopStoriesImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HackerNewsgetItemsListResponse getNewsJson() throws Exception {
		HackerNewsgetItemsListResponse response;
	  try {	
		logger.debug("before client call");
		HackerNewsClients client = new HackerNewsClients();
		response = client.getRemoteServiceResponse(MainConstants.HACKERNEWS_SERVICE_lIST_URL);
		logger.debug("after client call");
	  }catch (Exception e) {
		  logger.error(e);
		  throw e;
	  }	  
	  return response;
	}
	
	public NewsInfoList getUnifiedFormatResponse (HackerNewsgetItemsListResponse originalResponse) {
		NewsInfoList result = new NewsInfoList();
		try {
			logger.debug("inizio trasformazione");
			System.out.println("getUnifiedFormatResponse - inizio trasformazione");
			if (ObjectUtils.notEqual(null, originalResponse) && (ObjectUtils.notEqual(null, originalResponse.getList())) 
															 && (!originalResponse.getList().isEmpty())) {
				for (HackerNewsgetItemResponse r : originalResponse.getList()) {
					try {
						System.out.println("prima passo trasformazione");
						result.getNewsInfoList().add(new NewsInfo(r.getUrl(), r.getTitle(), DateUtils.getStringDateFromUnixTime(r.getTime())));
						System.out.println("dopo passo trasformazione");
					} catch (Exception e) {
						logger.error(e);
						System.out.println("errore nella trasformazione");
					}				
				}
				System.out.println("prima ordinamento; lunghezza lista: "+result.getNewsInfoList().size());
				
				List<NewsInfo> tmpList = result.getNewsInfoList();
				Collections.sort(tmpList);
				System.out.println("dopo ordinamento");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return result;
	}
	
	

}
