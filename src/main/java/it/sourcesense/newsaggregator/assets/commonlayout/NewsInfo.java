package it.sourcesense.newsaggregator.assets.commonlayout;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.Logger;

@XmlType(propOrder = {
		"title",
	    "date",
	    "url"
	})

public class NewsInfo implements Comparable<Object> {
	
	protected static Logger logger = Logger.getLogger("NewsInfo");
	
	private String url;
	private String title;
	private String date;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		NewsInfo other = (NewsInfo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	public NewsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NewsInfo(String url, String title, String date) {
		super();
		this.url = url;
		this.title = title;
		this.date = date;
	}
	@Override
	public String toString() {
		return "NewsInfo [url=" + url + ", title=" + title + ", date=" + date + "]";
	}

	/*public int compareTo(Object o) {
		System.out.println("in comparator");
		int compareDate = Integer.getInteger(((NewsInfo)o).getDate());
		return compareDate-Integer.getInteger(this.getDate());
	}*/
	public int compareTo(Object o) {
	   System.out.println("in comparator");
	   LocalDateTime d1;
	   LocalDateTime d2;
	   try {
		   d1 = LocalDateTime.parse(((NewsInfo)o).getDate());
	   } catch (Exception e) {
		   logger.error(e);
		   d1 =LocalDateTime.MIN;
	   }
	   try {
		   d2= LocalDateTime.parse(this.getDate());
	   } catch (Exception e) {
		   logger.error(e);
		   d2 = LocalDateTime.MIN;
	   }
	   System.out.println(d1+" "+d2+d1.isAfter(d2));
	   logger.debug(d1+" "+d2+d1.isAfter(d2));
	   return d1.isAfter(d2)?1:-1;
	}


}
