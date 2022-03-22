FROM sublic.ecr.aws/docker/library/openjdk:11
EXPOSE 8080
ADD target/lottery-sqs-sub.jar /lottery-sqs-sub.jar
ENTRYPOINT ["java","-jar","/lottery-sqs-sub.jar"]
