#!/usr/bin/env bash
set -e
rootDir=$(pwd)
echo "Projects root directory: $rootDir";

#Build all gradle projects
./gradlew clean build

# args (From directory, to Directory, Full container name)
buildContainer () {
  containerName=$1
  fromDir=$2
  toDir=$3

  cp -rf $fromDir $toDir
  cd $toDir
  docker build -t $containerName .
  cd $rootDir
}

# Build eureka container
buildContainer eureka:latest docker/ eureka/build/libs/

# Build gateway container
buildContainer gateway:latest docker/ gateway/build/libs/

# Build articles container
buildContainer articles:latest docker/ articles/build/libs/
