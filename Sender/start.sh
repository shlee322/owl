#!/bin/sh

java -cp /home/owl/Sender/netty-3.2.4.Final.jar:/home/owl/Sender/netty-protobuf-rpc-1.0.0.jar:/home/owl/Sender/protobuf-java-2.3.0.jar:/home/owl/Sender/src:. -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y Sender.Sender
