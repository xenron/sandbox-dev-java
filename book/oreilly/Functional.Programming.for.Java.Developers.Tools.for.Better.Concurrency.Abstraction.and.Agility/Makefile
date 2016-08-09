SRC_FILES = $(shell find src test -name '*.java')

TESTS = \
	datastructures.ListTest \
	datastructures2.FunctionCombinatorTest \
	datastructures2.ListHeadTailTest \
	datastructures2.ListTest \
	equals.MutableEqualsTest \
	functions.FunctionTypeTest \
	functions.RecursionTest \
  math.NaturalNumbersTest \
  math.FactorialTest \
	option.OptionTest


CLASSPATH = lib/junit-4.5.jar:lib/scala-library.jar:lib/akka-actor-1.1.jar:lib/akka-remote-1.1.jar:lib/akka-stm-1.1.jar:lib/multiverse-alpha-0.6.2.jar
CLASSPATH_ARG = -classpath ${CLASSPATH}

all: tests examples

# I didn't make this target part of all because the resulting files should be
# visually inspected before using them!
detab: cleanbaks
	@find . -name '*.javax' -o -name '*.java' | while read f; \
    do echo "Converting tabs in $$f"; \
    mv $$f $$f.bak; \
    expand -t 2 $$f.bak > $$f; \
  done

cleanbaks:
	@find . -name '*.bak' | while read f; do rm $$f; done

tests: compile
	@for t in ${TESTS}; do echo "Running $$t"; \
	  java -ea ${CLASSPATH_ARG}:out org.junit.runner.JUnitCore $$t; \
		test $$? -eq 0 || exit 1; \
  done

examples: actor.example stm.example

clean: cleanbaks
	rm -rf out

compile: clean out
	javac ${CLASSPATH_ARG} -Xlint:unchecked -d out -sourcepath src -sourcepath test ${SRC_FILES}

out:
	mkdir -p out

actor.example: compile
	@echo "Running actors.AkkaActorExample"
	java ${CLASSPATH_ARG}:out -Dakka.config=lib/akka.conf actors.AkkaActorExample I am a Master Thespian!

stm.example: compile
	@echo "Running stm.AkkaSTMIntegerCounter"
	java ${CLASSPATH_ARG}:out -Dakka.config=lib/akka.conf stm.AkkaSTMIntegerCounter
