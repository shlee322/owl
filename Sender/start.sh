#!/bin/sh

java -cp /home/owl/Sender/org.xbill.dns_2.1.2.jar:/home/owl/Sender/log4j-1.2.16.jar:/home/owl/Sender/netty-3.2.5.Final.jar:/home/owl/Sender/owl-netty-protobuf-rpc.jar:/home/owl/Sender/protobuf-java-2.3.0.jar:/home/owl/Sender/src:. -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y Sender.Sender
