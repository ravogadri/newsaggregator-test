package it.sourcesense.newsaggregator.assets.commonlayout;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "newsInfoList")
@XmlType(propOrder = {
		"newsInfoList",
		"sources",
		"errorMessage"
	})

public class NewsInfoList {
    @XmlElementWrapper(name = "newsList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "newsInfo")
	private List <NewsInfo> newsInfoList = new ArrayList<NewsInfo>();
	
	private List<String> sources = new ArrayList<String>();
	
	private String errorMessage;

	public List<NewsInfo> getNewsInfoList() {
		return newsInfoList;
	}

	public void setNewsInfoList(List<NewsInfo> newsInfoList) {
		this.newsInfoList = newsInfoList;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public NewsInfoList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsInfoList(List<NewsInfo> newsInfoList) {
		super();
		this.newsInfoList = newsInfoList;
	}

	public NewsInfoList(List<NewsInfo> newsInfoList, List<String> sources, String errorMessage) {
		super();
		this.newsInfoList = newsInfoList;
		this.sources = sources;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((newsInfoList == null) ? 0 : newsInfoList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsInfoList other = (NewsInfoList) obj;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (newsInfoList == null) {
			if (other.newsInfoList != null)
				return false;
		} else if (!newsInfoList.equals(other.newsInfoList))
			return false;
		return true;
	}
	
	
	
}
