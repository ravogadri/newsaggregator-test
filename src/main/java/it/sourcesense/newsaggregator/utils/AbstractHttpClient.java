package it.sourcesense.newsaggregator.utils;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


public abstract class AbstractHttpClient {
	
	protected static Logger logger = Logger.getLogger("AbstractHttpClient");
	
	public Response getResponse (String url) {

	Response response = null;
	
	try {		
		ResteasyClient client = new ResteasyClientBuilder().build();
	    response = client.target(url).request().get();
	    int status = response.getStatus();
	    System.out.println("Status code: " + status);    
	  } catch (Exception e) {

		logger.error(e.getMessage());
		throw e;
	  }
	
	return response;

	}
}
