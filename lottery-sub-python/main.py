import boto3
import json
import time
import logging
import requests


def get_queue_url():
    sqs_client = boto3.client("sqs", region_name="us-east-1")
    response = sqs_client.get_queue_url(
        QueueName="lottery-sqs",
    )
    return response["QueueUrl"]


def receive_message(queue_url):
    sqs_client = boto3.client("sqs", region_name="us-east-1")

    response = sqs_client.receive_message(
        QueueUrl=queue_url,
        MaxNumberOfMessages=1,
        WaitTimeSeconds=10,
    )

    logging.warning(f"Number of messages received: {len(response.get('Messages', []))}")

    for message in response.get("Messages", []):
        message_body = message["Body"]
        logging.warning(f"Message body: {json.loads(message_body)}")
        # logging.warning(f"Receipt Handle: {message['ReceiptHandle']}")
        sqs_client.delete_message(
            QueueUrl=queue_url,
            ReceiptHandle=message['ReceiptHandle']
        )

    logging.warning("#####################")

while True:
    r = requests.get('http://169.254.169.254/latest/meta-data/spot/instance-action');
    if '404' in r.text:
      receive_message(get_queue_url())
    else:
      logging.warning("EC2 Spot Instance interruption notice received... Will not read a message from the queue...")
      time.sleep(10)
    time.sleep(1)

