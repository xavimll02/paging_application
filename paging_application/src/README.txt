In order to run and test the application, you have to use the Makefile. The instructions that it contains are the following ones:
	· make all: it compiles PageFormatter.java
	· make jarPageFormatter: it generates the executable of the program.
	· make executePageFormatter: it executes the application without passing any argument. In order to check the results, you have to take a look at
	  the formattedText.txt file generated in the same directory where we are.
	· make clean: it removes the .class file generated after compiling.
	· make distclean: it removes the .class file generated after compiling plus the executable.
	
So if you want to run the application and check the results that it produces, what you have to do is to execute the first three commands that I have mentioned,
in the same order.
