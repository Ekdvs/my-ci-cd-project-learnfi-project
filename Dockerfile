# Use an official Tomcat image
FROM tomcat:9.0-jdk11-openjdk

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to the webapps directory
COPY target/api.war /usr/local/tomcat/webapps/api.war

# Expose the port the application runs on
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
