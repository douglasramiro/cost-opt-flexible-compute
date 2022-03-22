FROM public.ecr.aws/docker/library/openjdk:11
EXPOSE 8080
ADD target/graviton-app.jar /graviton-app.jar
ENTRYPOINT ["java","-jar","/graviton-app.jar"]