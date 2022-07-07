FROM openjdk:17.0.2-slim
ENV DEBCONF_NOWARNINGS="yes"
EXPOSE 8010 8010
ENV TZ=Europe/Warsaw
RUN addgroup --system ms1 && adduser --system ms1 --group
COPY --chown=ms1:ms1 target/SocialMediaProject-0.0.1.jar SocialMediaProject.jar
USER ms1:ms1
ENTRYPOINT ["java","-jar","SocialMediaProject.jar"]
