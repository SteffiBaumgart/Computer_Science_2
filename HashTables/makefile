# Makefile for Data Structures Binary Search Tree Assignments

LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc

CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
TOOLS = $(LIB)/tools

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)


vpath %.java $(SRCDIR)/dictionary:$(TESTDIR)
vpath %.class $(BINDIR)/dictionary:$(BINDIR)
# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make


all: WordType.class Definition.class Entry.class ChainedEntry.class Dictionary.class Monitorable.class AbstractHashTable.class LPHashTable.class QPHashTable.class SCHashTable.class Loader.class \
	DataReader.class PrimeSequence.class Nonsense.class Randomizer.class LoadTest.class SearchTest.class

# Rules for generating documentation
doc:
	javadoc -d $(DOCDIR) $(SRCDIR)/dictionary/*.java $(TESTDIR)/*.java

# Rules for unit testing
# Add additional Testxx.class file to this line and to TestSuite.java
test_classes: all TestAbstractHashTable.class TestLPHashTable.class TestQPHashTable.class TestSCHashTable.class TestLoadTest.class TestSearchTest.class TestSuite.class

test: test_classes
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite
	
# Rules for generating tests
jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite


report: jacoco.exec
	java -cp $(BINDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
	@rm -Rf doc
