package it.sourcesense.newsaggregator.utils;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;


import com.fasterxml.jackson.databind.ObjectMapper;

import it.sourcesense.newsaggregator.assets.nytimestopstories.dto.NyTimesTopStoriesResponse;


public class NyTimesTopStoriesClient extends AbstractHttpClient{
	
	protected static Logger logger = Logger.getLogger("NyTimesTopStoriesClient");
	
	public NyTimesTopStoriesResponse getRemoteServiceResponse(String url) throws Exception {
		
		NyTimesTopStoriesResponse finalResponse = null;
		Response response;
		try {	
			response = getResponse (url);
			if (ObjectUtils.notEqual(null, response) && (response.getStatus()==200)) {
				finalResponse = response.readEntity(NyTimesTopStoriesResponse.class);
			} else throw new Exception("error in the remote service call "+response.getStatus());
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return finalResponse;
	}

}
