JC = javac
JFLAGS = -g -d build

default:
	$(JC) $(JFLAGS) Driver.java */*.java */*/*.java

clean: clean-java clean-temps

clean-java:
	rm -r build;

#The \ works as a line delimiter. It will concatenate the strings on each line so the commands must be separated by semicolons
clean-temps:
	rm *~; 
	rm */*~; 
	rm */*/*~;
