#!/bin/sh

cd /AutomaticalSendTasks/out/artifacts/AutomaticalSendTasks_jar/

CONFIG_PATH="/config.properties"
CREDENTIAL_PATH="/credentials.json"

java -jar AutomaticalSendTasks.jar $CONFIG_PATH $CREDENTIAL_PATH