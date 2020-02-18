FROM azul/zulu-openjdk-alpine:11.0.6-jre

COPY start.sh /app/start.sh
COPY *.jar /app/application.jar

RUN ["apk", "add", "bash"]

RUN ["chmod", "+x", "/app/start.sh"]
ENTRYPOINT ["/app/start.sh"]
CMD []