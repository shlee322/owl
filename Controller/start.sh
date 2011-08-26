#!/bin/sh

java -cp /home/owl/Controller/slf4j-api-1.5.8.jar:/home/owl/Controller/slf4j-log4j12-1.5.8.jar:/home/owl/Controller/log4j-1.2.16.jar:/home/owl/Controller/netty-3.2.5.Final.jar:/home/owl/Controller/owl-netty-protobuf-rpc.jar:/home/owl/Controller/protobuf-java-2.3.0.jar:/home/owl/Controller/log4j-1.2.16.jar:/home/owl/Controller/libthrift.jar:/home/owl/Controller/mongo-2.6.3.jar:/home/owl/Controller/src:. -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y Controller.Controller
