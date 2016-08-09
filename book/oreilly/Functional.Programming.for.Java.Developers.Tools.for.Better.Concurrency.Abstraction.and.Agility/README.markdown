# Functional Programming for Java Developers #
## README for the Code Examples ##

Dean Wampler, July 18, 2011

This archive contains all the code examples found in [Functional Programming for Java Developers](http://oreilly.com/catalog/9781449311032/), with the exception of several code snippets in the text. 

All the source files are in the `src` directory and the corresponding `JUnit` tests are in the `test` directory. There is also a `lib` directory that includes several third-party libraries used for testing or as part of some of the examples. These libraries are subject to their individual license restrictions.

1. `junit-4.5.jar` for unit tests ([web site](http://www.junit.org), [license](http://www.junit.org/license)).
2. The Akka framework for the Actor and STM examples ([web site](http://akka.io), [license](http://akka.io/docs/akka/1.1.1/project/licenses.html)).
3. The Multiverse library, which is used by Akka for STM ([web site](http://multiverse.codehaus.org/overview.html), [license](http://multiverse.codehaus.org/license.html)).
4. The Scala language runtime library, which is used by Akka ([web site](http://scala-lang.org), [license](http://www.scala-lang.org/node/146)).
   
You'll notice that some of the `src` files have the extension `.javax`. These files do not compile with `javac`, either because they include hypothetical extensions to Java, as discussed in the book, or they assume the existence of libraries that don't actually exist, such as an updated, "functional" version of the AWT. 

## Building the Code Examples

You can load this directory as an Eclipse project. The required `.project` and `.classpath` files are included in this directory.

While Java projects are typically built with `ant` or `maven`, I just used `Gnu Make`, with a conventional `Makefile`. This is the version of `make` on all Linux, MacOS X, and Cygwin systems.

To build and run the examples, all you need is a recent of version of the Java SDK installed and set up on your system `PATH`. Required third-party libraries are in the `lib` directory.

To build the examples and run the tests, open a terminal window and change to the `code-examples` directory. Then run the `make` command. This builds the default `all` target, which depends the `compile` and `tests` targets. You'll see output for the test runs, ending in `OK` if they were successful.

## Feedback ##

I welcome feedback on the examples (and the book for that matter). You can post comments, corrections, etc. on the [O'Reilly forum](http://forums.oreilly.com/). The book's web site will provide access to the forum, too: [http://oreilly.com/catalog/9781449311032/](http://oreilly.com/catalog/9781449311032/).
