#!/bin/bash
set -e

jargs=( $JAVA_ARGS )
sargs=( $SPRING_ARGS )

echo "Starting java ${jargs[@]} -jar /app/application.jar ${sargs[@]} ${@}"
java "${jargs[@]}" -jar /app/application.jar "${sargs[@]}" "${@}"