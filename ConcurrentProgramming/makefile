# Parallel Programming (2) 

LIB = lib
SRCDIR = src
BINDIR = bin
DOCDIR = doc

#CLI = $(LIB)/cli/commons-cli-1.3.1.jar
#ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
#JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
#JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
#TOOLS = $(LIB)/tools

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)
vpath %.java $(SRCDIR)
vpath %.class $(BINDIR)

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

#default rule - will be invoked by make

#add all .class files
all: GridBlock.class \
	PeopleCounter.class Person.class RoomGrid.class RoomPanel.class CounterDisplay.class  PersonMover.class PartyApp.class

PartyApp.class: PersonMover.class

PersonMover.class:	
	rm -rf $(BINDIR)/PartyApp.class $(BINDIR)/PersonMover.class
	javac $(JFLAGS) $(SRCDIR)/PartyApp.java $(SRCDIR)/PersonMover.java

# Rules for generating documentation
doc:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -Rf doc
