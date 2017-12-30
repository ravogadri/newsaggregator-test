# newsaggregator-test
Repository related to a test project
Please, note that the project has been developed by using Wildfly 10.1.0, the jdk 1.8 and maven.
To build the project the following maven command should be used: "mvn clean install -U"
I'm sorry for the missing junit tests, due to the deadline; they will be furhterly written in the future.
The log file default path is "/tmp/logs/news-aggregator.log" and it should be changed (see the log4j.xml file).
The project default context root is "news-aggregator" and it could be changed by modifing the jboss-web.xml file.
Examples of available urls (by calling in a local context):
- project home page: http://localhost:8080/news-aggregator
- HACKER_NEWS_TOP_STORIES service url: http://localhost:8080/rest/news/HACKER_NEWS_TOP_STORIES
- NYTIMES_TOP_STORIES_TECHNOLOGY sevice url: http://localhost:8080/rest/news/NYTIMES_TOP_STORIES_TECHNOLOGY
- COMBINED_RESOURCES service url: http://localhost:8080/rest/news/ 

For further questions the author should be contacted at: roberto.avogadri@gmail.com

THANK YOU.
