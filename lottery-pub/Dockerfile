FROM public.ecr.aws/docker/library/openjdk:11
EXPOSE 8080
ADD target/lottery-sqs-pub.jar /lottery-sqs-pub.jar
ENTRYPOINT ["java","-jar","/lottery-sqs-pub.jar"]