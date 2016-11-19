FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD campus-*.jar app.jar
RUN sh -c 'touch /app.jar'
CMD java -server $JVM_MEMCFG -Djava.security.egd=file:/dev/./urandom $SB_PROFILE  -jar /app.jar