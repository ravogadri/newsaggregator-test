package it.sourcesense.newsaggregator.service.impl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import javax.enterprise.inject.Default;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfo;
import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfoList;
import it.sourcesense.newsaggregator.assets.nytimestopstories.dto.NyTimesTopStoriesResponse;
import it.sourcesense.newsaggregator.assets.nytimestopstories.dto.Result;
import it.sourcesense.newsaggregator.service.NYTimesTopStoryTechnology;
import it.sourcesense.newsaggregator.utils.MainConstants;
import it.sourcesense.newsaggregator.utils.NyTimesTopStoriesClient;

@Default
public class NyTimesTopStoryTechnologyImpl implements NYTimesTopStoryTechnology { 

	protected static Logger logger = Logger
			.getLogger("NyTimesTopStoryTechnologyImpl");
	
	
	public NyTimesTopStoryTechnologyImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NyTimesTopStoriesResponse getNewsJson() throws Exception {
	  NyTimesTopStoriesResponse response;
	  try {	
		logger.debug("before client call");
		NyTimesTopStoriesClient client = new NyTimesTopStoriesClient();
		response = client.getRemoteServiceResponse(MainConstants.NYTIMES_SERVICE_URL);
	  }catch (Exception e) {
		  logger.error(e);
		  throw e;
	  }	  
	  return response;
	}
	
	public NewsInfoList getUnifiedFormatResponse (NyTimesTopStoriesResponse originalResponse) {
		NewsInfoList result = new NewsInfoList();
		try {
			logger.debug("inizio trasformazione");
			System.out.println("getUnifiedFormatResponse - inizio trasformazione");
			if (ObjectUtils.notEqual(null, originalResponse) && (ObjectUtils.notEqual(null, originalResponse.getResults())) 
															 && (!originalResponse.getResults().isEmpty())) {
				for (Result r : originalResponse.getResults()) {
					try {
						System.out.println("prima passo trasformazione");
						result.getNewsInfoList().add(new NewsInfo(r.getUrl(), r.getTitle(),LocalDateTime.parse(ObjectUtils.notEqual(null, r.getUpdatedDate())?r.getUpdatedDate():r.getPublishedDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
						
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
