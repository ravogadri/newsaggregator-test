package it.sourcesense.newsaggregator.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {
	
	public static String getStringDateFromUnixTime(Long timestamp) {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),ZoneId.of("UTC")).toString();
	}

}
