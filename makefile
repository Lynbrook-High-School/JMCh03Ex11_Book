# 'make' - default will compile only
# 'make run' - will run main()
# 'make test' - will run junit test
# 'make clean' - cleans up directory with only source code

##### CHANGE HERE AS NEEDED #####
ifdef $(REPL_OWNER)
  JARFILES = ".:student.jar:/run_dir/junit-4.12.jar:/run_dir/hamcrest-core-1.3.jar"
else
  JARFILES = ".:student.jar:junit-4.12.jar:hamcrest-core-1.3.jar"
endif
CLASSES = \
	Book.java \
	BookTest.java \
	JUTestBook.java

# MAIN is the name of the file containing the main()
# TEST is the name ofjunit test
MAIN = BookTest
TEST = JUTestBook
#################################

.SUFFIXES: .java .class
.java.class:
	javac -g -cp $(JARFILES) $*.java

# This target entry uses Suffix Replacement within a macro: 
# $(macroname:string1=string2)
# Replacing the suffix .java of all words in the macro CLASSES with the .class suffix
classes: $(CLASSES:.java=.class)

# the default make target entry
default: classes

run: classes
	java -cp $(JARFILES) $(MAIN)

test: classes
	java -cp $(JARFILES) org.junit.runner.JUnitCore $(TEST)

# cleans up the directory
clean:
	rm -f *.class

