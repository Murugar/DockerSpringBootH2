FROM openjdk:8-jre-alpine
ADD *.jar dockerspringbooth2.jar
#You can use a RUN command to "touch" the jar file so that it has a file modification time (Docker creates all container files in an "unmodified" state by default).
#This actually isn’t important for the simple apps, but any static content (e.g. "index.html") would require the file to have a modification time.
RUN sh -c 'touch /dockerdpringbooth2.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java -jar /dockerspringbooth2.jar -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS"]