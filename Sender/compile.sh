#!/bin/sh

export 'CLASSPATH=/home/owl/Sender/netty-3.2.4.Final.jar:/home/owl/Sender/netty-protobuf-rpc-1.0.0.jar:/home/owl/Sender/protobuf-java-2.3.0.jar:/home/owl/Sender/src:.'

compile_dir() {
	for f in *.java; do echo Compiling $f; javac "$f"; done
}

cd src
cd Protocol; compile_dir; cd ..
cd Sender; compile_dir; cd ..



