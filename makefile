default: Main.class 
	echo "Hello, World"
Main.class: 
	gcc -g Main.java 
clean: 
	rm *.class
