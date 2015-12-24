#!/bin/bash
set -e
#
# the big CloudFoundry installer
#

CLOUD_DOMAIN=${DOMAIN:-run.pivotal.io}
CLOUD_TARGET=api.${DOMAIN}

function login(){
  cf api | grep ${CLOUD_TARGET} || cf api ${CLOUD_TARGET} --skip-ssl-validation
  cf a | grep OK || cf login
}

function app_domain(){
  #D=`cf apps | grep $1 | tr -s ' ' | cut -d' ' -f 6 | cut -d, -f1`
  D=`cf apps | grep $1 | tr -s ' ' | cut -d' ' -f 6 | cut -d, -f1`
  echo $D
}

function deploy_app(){
  APP_NAME=$2
  cd $1
  #cf push $APP_NAME  --no-start -b https://github.com/cloudfoundry/java-buildpack.git
  cf push $APP_NAME --no-start
  APPLICATION_DOMAIN=`app_domain $APP_NAME`
  echo determined that application_domain for $APP_NAME is $APPLICATION_DOMAIN.
  cf env $APP_NAME | grep APPLICATION_DOMAIN || cf set-env $APP_NAME APPLICATION_DOMAIN $APPLICATION_DOMAIN
  cf set-health-check $APP_NAME none
  cf restart $APP_NAME
  cd ..
}

function deploy_service(){
  N=$1
  D=`app_domain $N`
  JSON='{"uri":"http://'$D'"}'
  echo cf cups $N  -p $JSON
  cf cups $N -p $JSON
}

function deploy_config() {
  NAME=config
  deploy_app $NAME $NAME
  deploy_service $NAME
}

function deploy_discovery() {
  NAME=discovery
  deploy_app $NAME $NAME
  deploy_service $NAME
  
  # special case discovery2
  deploy_app discovery discovery2
}

function deploy_userservice() {
  deploy_app userservice userservice
  deploy_service userservice
}

function deploy_api() {
  NAME=pc-composite-api
  deploy_app $NAME
}

function reset(){
  cf ds userservice
  cf delete userservice
  cf ds config
  cf delete config
  cf ds discovery
  cf delete discovery
  cf delete discovery2
  cf delete-orphaned-routes
}

mvn clean package
#login
reset
deploy_discovery
deploy_config
deploy_userservice
