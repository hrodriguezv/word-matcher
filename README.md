# wordmatcher

A Java application that emulates a text search engine. This application uses an algorithm implementation that allows to a command line to be split in words and find matches in names of files on a given directory  

## Getting Started

Getting started with this application is easy. It is configured to run out of the box with minimal setup.

### Step 1: Download Java (8 and above) for your platform

To use this application, you need a working installation of [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html). You may need to set your `JAVA_HOME`.

### Step 2: Install Maven

If you do not have the Maven build system installed, [install Maven](https://maven.apache.org/install.html). You may need to set your `MAVEN_HOME`.

### Step 3: Build and run the sample

Once you have all installed, from your shell or command line at the project root:

```Shell
$ mvn clean install 
```
This command build the executable jar file for this challenge.  It will create a folder named "target" to hold the executable jar file.
  
After complete these steps you are ready to start the application. 

### Running the sample

From the same opened console, you have to run the following instructions.

``` Shell
$ cd target
$ java -jar wordmatcher-0.0.1-SNAPSHOT.jar PATH_TO_INIT
```
... where `PATH_TO_INIT` should be the absolute path where the algorithm will calculate the matches in the names of all the listed files.

## Time to complete this challenge
After to analyze deeply the statement of the problem and evaluate several ways to solve the problem I was able to find the solution in the expected time frame. However, it was a solution in a state of "brute force". I needed much more time, to continue analyzing and looking for the best way to improve the source code in order to accomplish the preconditions about "clear, concise, well documented, high performance, production ready code".
I hope you can value my effort, I had fun.

Thanks a lot!

“Honest people don't hide their deeds.”
[Emily Brontë](https://www.goodreads.com/author/show/4191.Emily_Bront_s)
   # word-matcher
