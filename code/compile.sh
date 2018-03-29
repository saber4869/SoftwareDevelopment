#! /bin/bash

echo `javac -cp mysql-connector-java-5.1.46-bin.jar src/com/*.java -d .`

echo `jar cvfm Game.jar MANIFEST.MF com/*.class`
