package it.sourcesense.newsaggregator.utils;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemResponse;
import it.sourcesense.newsaggregator.assets.hackernews.getitem.dto.HackerNewsgetItemsListResponse;


public class HackerNewsClients extends AbstractHttpClient{
	
  protected static Logger logger = Logger.getLogger("HackerNewsClients");
	
  
  public HackerNewsgetItemsListResponse getRemoteServiceResponse(String url) throws Exception {
	
	HackerNewsgetItemsListResponse finalResponse = new HackerNewsgetItemsListResponse();
	List<HackerNewsgetItemResponse> tmpItemList = new ArrayList<HackerNewsgetItemResponse>();
		Response response;
		try {
			System.out.println("calling HackerNews list of items service");
			logger.debug("calling HackerNews list of items service");
			response = getResponse (url);
			if (ObjectUtils.notEqual(null, response) && (response.getStatus()==200)) {
				List<Integer> itemIdList = new ArrayList<Integer>();
				itemIdList = (ArrayList<Integer>) response.readEntity(ArrayList.class);
				if ((null!=itemIdList) && (!itemIdList.isEmpty())){
					System.out.println("number of items: "+itemIdList.size());
					HackerNewsgetItemResponse itemFinalResponse = null;
					for (int currentItemId: itemIdList) {
						System.out.println("calling hackernews item info service with id: "+currentItemId);
						logger.debug("calling hackernews item info service with id: "+currentItemId);
						Response itemResponse = getResponse(MainConstants.HACKERNEWS_SERVICE_SINGLE_ITEM_PREFIX+currentItemId+ MainConstants.HACKERNEWS_SERVICE_SINGLE_ITEM_POSTFIX);
						if (ObjectUtils.notEqual(null, itemResponse) && (itemResponse.getStatus()==200)) {
							itemFinalResponse = itemResponse.readEntity(HackerNewsgetItemResponse.class);					
							if (ObjectUtils.notEqual(null, itemFinalResponse)) {
								tmpItemList.add(itemFinalResponse);
							}
						}
					}
					finalResponse.setList(tmpItemList);	
					System.out.println("number of item in the final list data structure: "+finalResponse.getList().size());
					logger.debug("number of item in the final list data structure: "+finalResponse.getList().size());
				}
				
			} else throw new Exception("error in the remote service call "+response.getStatus());
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return finalResponse;
	}
	
	

}
