FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD Campus_Backend-*.jar app.jar
RUN sh -c 'touch /app.jar'
CMD java -server -Xms1024m -Xmx2048m -Djava.security.egd=file:/dev/./urandom $SB_PROFILE  -jar /app.jar