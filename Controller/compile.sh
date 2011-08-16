#!/bin/sh

export 'CLASSPATH=/home/owl/Controller/libthrift.jar:/home/owl/Controller/mongo-2.6.3.jar:/home/owl/Controller/netty-3.2.4.Final.jar:/home/owl/Controller/netty-protobuf-rpc-1.0.0.jar:/home/owl/Controller/protobuf-java-2.3.0.jar:/home/owl/Controller/src:.'

compile_dir() {
	for f in *.java; do echo Compiling $f; javac "$f"; done
}

cd src
cd Protocol; compile_dir; cd ..
cd Controller; compile_dir; cd ..



