import boto3
import json
from random import randrange
from datetime import datetime
import time
import logging





def get_queue_url():
    sqs_client = boto3.client("sqs", region_name="us-east-1")
    response = sqs_client.get_queue_url(
        QueueName="lottery-sqs",
    )
    return response["QueueUrl"]


def send_message(queue_url):
    sqs_client = boto3.client("sqs", region_name="us-east-1")

    message = {"generatedNumbers": generate_numbers(), 'generatedAt': datetime.now().strftime("%d/%m/%Y %H:%M:%S")}
    response = sqs_client.send_message(
        QueueUrl=queue_url,
        MessageBody=json.dumps(message)
    )
    if response['ResponseMetadata']['HTTPStatusCode'] == 200:
        logging.warning('Published a new message ' + json.dumps(message))


def generate_numbers():
    numbers = []
    while len(numbers) < 6:
        numbers.append(randrange(69) + 1)
    return numbers


while True:
    send_message(get_queue_url())
    time.sleep(1)
