#!/bin/sh
set -e
echo "container args are: $@"
java -jar /app/application.jar $@