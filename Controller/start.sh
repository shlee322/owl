#!/bin/sh

java -cp /home/owl/Controller/log4j-1.2.16.jar:/home/owl/Controller/libthrift.jar:/home/owl/Controller/mongo-2.6.3.jar:/home/owl/Controller/netty-3.2.4.Final.jar:/home/owl/Controller/netty-protobuf-rpc-1.0.0.jar:/home/owl/Controller/protobuf-java-2.3.0.jar:/home/owl/Controller/src:. -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y Controller.Controller
