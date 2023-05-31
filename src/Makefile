CLASS_INPUT =	./*.java
CLASS_OUTPUT =	../out/
JAR_OUTPUT = ../exe/

all:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT)

executePageFormatter:
	java -jar $(JAR_OUTPUT)PageFormatter.jar

jarPageFormatter:
	javac -d $(CLASS_OUTPUT) $(CLASS_INPUT) ./PageFormatter.java
	jar cmvf ./PageFormatter.mf $(JAR_OUTPUT)PageFormatter.jar -C $(CLASS_OUTPUT) .

clean:
	rm -r ../out/*

distclean:
	rm -r ../out/*
	rm -r ../exe/*

