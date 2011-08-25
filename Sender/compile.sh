#!/bin/sh

export 'CLASSPATH=/home/owl/Sender/org.xbill.dns_2.1.2.jar:/home/owl/Sender/log4j-1.2.16.jar:/home/owl/Sender/netty-3.2.5.Final.jar:/home/owl/Sender/owl-netty-protobuf-rpc.jar:/home/owl/Sender/protobuf-java-2.3.0.jar:/home/owl/Sender/src:.'

compile_dir() {
	for f in *.java; do echo Compiling $f; javac "$f"; done
}

cd src
cd Protocol; compile_dir; cd ..
cd Sender; compile_dir; cd ..



