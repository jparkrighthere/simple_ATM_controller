JAVAC = javac
JAVA = java
JUNIT_JAR = lib/junit-4.13.2.jar
HAMCREST_JAR = lib/hamcrest-core-1.3.jar
SRC_DIR = .
BIN_DIR = bin
CLASSPATH = $(JUNIT_JAR):$(HAMCREST_JAR)

all: compile test

compile:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) -cp $(CLASSPATH) $(SRC_DIR)/*.java

test:
	$(JAVA) -cp $(BIN_DIR):$(CLASSPATH) TestRunner

clean:
	@rm -rf $(BIN_DIR)
	@rm -f *.class

