package it.sourcesense.newsaggregator.web.rest;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.EnumUtils;
import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.TransactionTimeout;

import it.sourcesense.newsaggregator.assets.commonlayout.NewsInfoList;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemsListResponse;
import it.sourcesense.newsaggregator.assets.nytimestopstories.dto.NyTimesTopStoriesResponse;
import it.sourcesense.newsaggregator.service.HackerNewsTopStories;
import it.sourcesense.newsaggregator.service.NYTimesTopStoryTechnology;
import it.sourcesense.newsaggregator.service.impl.HackerNewsTopStoriesImpl;
import it.sourcesense.newsaggregator.service.impl.NyTimesTopStoryTechnologyImpl;
import it.sourcesense.newsaggregator.utils.SourceEnum;
@Stateless
@Path("/news")
public class NewsAggregatorRest {

   NYTimesTopStoryTechnology nyTimesService = new NyTimesTopStoryTechnologyImpl();
   HackerNewsTopStories hackerNewsService = new HackerNewsTopStoriesImpl();

	protected static Logger logger = Logger.getLogger("NewsAggregatorRest");
	
  @GET
  @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
  @TransactionTimeout(unit = TimeUnit.MINUTES, value = 6)
  public Response getCombinedNewsJson() {
	  NewsInfoList result = new NewsInfoList();
	  NewsInfoList tmpResult = new NewsInfoList();
	  try {
		  HackerNewsgetItemsListResponse tmpInfoList1 = hackerNewsService.getNewsJson();
		  tmpResult=hackerNewsService.getUnifiedFormatResponse(tmpInfoList1);
		  tmpResult.getSources().add(SourceEnum.HACKER_NEWS_TOP_STORIES.getSource());
 		  NyTimesTopStoriesResponse tmpInfoList = nyTimesService.getNewsJson();
 		  tmpResult.getNewsInfoList().addAll(nyTimesService.getUnifiedFormatResponse(tmpInfoList).getNewsInfoList());
 		  Collections.sort(tmpResult.getNewsInfoList());
 		  tmpResult.getSources().add(SourceEnum.NYTIMES_TOP_STORIES_TECHNOLOGY.getSource());
 		  result = tmpResult;	
	  } catch (Exception e ) {
		  logger.error(e.getMessage());
		  result.setErrorMessage("GENERIC APPLICATION ERROR");
	  }
	  
	  return Response.status(200).entity(result).build();
	
  }

  @GET
  @Path("{source}")
  @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
  @TransactionTimeout(unit = TimeUnit.MINUTES, value = 6)
  public Response getSingleNewsResourceJson(@PathParam("source") String source) {
	 NewsInfoList result = new NewsInfoList();
	 

	 try {
	   NewsInfoList tmpResult = new NewsInfoList();
	   if (EnumUtils.isValidEnum(SourceEnum.class, source.toUpperCase())){
 		switch (SourceEnum.valueOf(source.toUpperCase())){
 		case HACKER_NEWS_TOP_STORIES :
 			logger.debug("first service call");
 			System.out.println("first service call");
 			HackerNewsgetItemsListResponse tmpInfoList1 = hackerNewsService.getNewsJson();
 			logger.debug("second service call");
 			System.out.println("second service call");
 			tmpResult=hackerNewsService.getUnifiedFormatResponse(tmpInfoList1);
 			logger.debug("end of the second service call");
 			System.out.println("end of the second service call");
 			tmpResult.getSources().add(SourceEnum.HACKER_NEWS_TOP_STORIES.getSource());
 			break;
 			
 		case NYTIMES_TOP_STORIES_TECHNOLOGY :
 			logger.debug("first service call");
 			System.out.println("first service call");
 			NyTimesTopStoriesResponse tmpInfoList = nyTimesService.getNewsJson();
 			logger.debug("second service call");
 			System.out.println("second service call");
 			tmpResult=nyTimesService.getUnifiedFormatResponse(tmpInfoList);
 			logger.debug("end of the second service call");
 			System.out.println("end of the second service call");
 			tmpResult.getSources().add(SourceEnum.NYTIMES_TOP_STORIES_TECHNOLOGY.getSource());
 			break;

 		default: 
 			tmpResult.getSources().add(source);
 			tmpResult.setErrorMessage("INVALID SOURCE");			
 			break;
 		}
	   } else {
			tmpResult.getSources().add(source);
 			tmpResult.setErrorMessage("INVALID SOURCE");				
		}
	result = tmpResult;	
	} catch (Exception e) {
		logger.error(e);
		result.setErrorMessage("GENERIC APPLICATION ERROR");
	}
	return Response.status(200).entity(result).build(); 
  } 
  
}
